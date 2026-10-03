package dtm.ide.api.project.editor;

import dtm.ide.api.extension.IdeAdapterEditorCallbacks;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.file.Path;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ApiEvolutionCompatibilityTest {

    @Test
    void oldContextConstructorsExposeUnknownDocumentVersion() {
        Path file = Path.of("Example.java");
        assertEquals(-1, new IdeCompletionContext("", file, 0, 0, 0, "", "", 0, null)
                .documentVersion());
        assertEquals(-1, new IdeHoverContext("", file, 0, 0, 0).documentVersion());
        assertEquals(-1, new IdeInlayHintContext("", file, 0, 0).documentVersion());
        assertEquals(-1, new IdeSemanticTokensContext("", file).documentVersion());
        assertEquals(-1, new IdeSignatureHelpContext("", file, 0, 0, 0, "", null,
                '\0', false, null).documentVersion());
    }

    @Test
    void newCallbacksDelegateToLegacyImplementations() {
        AtomicInteger changed = new AtomicInteger();
        IdeAdapterEditorCallbacks adapter = new IdeAdapterEditorCallbacks() {
            @Override
            public void onCodeEditorTextChanged(IdeEditorContext context) {
                changed.incrementAndGet();
            }

            @Override
            public Set<Character> getCompletionTriggerCharacters() {
                return Set.of('.');
            }
        };

        adapter.onCodeEditorTextChanged(null, new TextChange(2, 1, "x", 3));
        assertEquals(1, changed.get());
        assertEquals(Set.of('.'), adapter.getCompletionTriggerCharacters(Path.of("Example.java")));
        assertFalse(adapter.getSelectionRanges(new SelectionRangeContext(null, "", 0, -1))
                .join().iterator().hasNext());
    }

    @Test
    void offsetSelectionUsesTheExistingLineAndColumnSelection() {
        AtomicReference<int[]> selection = new AtomicReference<>();
        IdeEditorContext context = (IdeEditorContext) Proxy.newProxyInstance(
                IdeEditorContext.class.getClassLoader(), new Class<?>[]{IdeEditorContext.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("getText")) {
                        return "a\nbc";
                    }
                    if (method.getName().equals("setSelection")) {
                        selection.set(new int[]{(int) args[0], (int) args[1], (int) args[2], (int) args[3]});
                        return null;
                    }
                    if (method.isDefault()) {
                        return InvocationHandler.invokeDefault(proxy, method, args);
                    }
                    throw new AssertionError(method.getName());
                });

        context.select(2, 4);
        assertArrayEquals(new int[]{1, 0, 1, 2}, selection.get());
    }
}
