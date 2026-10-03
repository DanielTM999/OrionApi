package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;
import dtm.ide.api.extension.editor.CodeEditorFactory;
import dtm.ide.api.extension.editor.EmbeddedCodeEditorSettings;
import dtm.ide.api.project.editor.IdeEditorContext;
import dtm.ide.api.project.editor.IdeWorkspaceEdit;
import dtm.ide.api.theme.EditorThemeConfig;
import dtm.stools.component.panels.editor.code.CodeEditor;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public interface IdeAdapterEditorActions {

    @Delegated
    default IdeEditorContext getEditor(Path filePath) {
        return getEditor(filePath, false);
    }

    @Delegated
    default IdeEditorContext getEditor(Path filePath, boolean createIfAbsent) {
        return null;
    }

    @Delegated
    default IdeEditorContext getEditor(Path filePath, Consumer<IdeEditorContext> configurer) {
        return getEditor(filePath, true, configurer);
    }

    @Delegated
    default IdeEditorContext getEditor(Path filePath, boolean createIfAbsent, Consumer<IdeEditorContext> configurer) {
        return getEditor(filePath, createIfAbsent);
    }

    @Delegated
    default void setCaretPosition(int line, int col) {
    }

    @Delegated
    default CodeEditor requestEmbeddedCodeEditor(String virtualFileName, String initialText) {
        return requestEmbeddedCodeEditor(virtualFileName, initialText, EmbeddedCodeEditorSettings.defaults());
    }

    @Delegated
    default CodeEditor requestEmbeddedCodeEditor(String virtualFileName, String initialText, EmbeddedCodeEditorSettings settings) {
        return null;
    }

    @Delegated
    default <E extends CodeEditor> E requestEmbeddedCodeEditor(String virtualFileName, String initialText, CodeEditorFactory<E> codeEditorFactory) {
        return requestEmbeddedCodeEditor(virtualFileName, initialText, EmbeddedCodeEditorSettings.defaults(), codeEditorFactory);
    }

    @Delegated
    default <E extends CodeEditor> E requestEmbeddedCodeEditor(String virtualFileName, String initialText, EmbeddedCodeEditorSettings settings, CodeEditorFactory<E> codeEditorFactory) {
        return null;
    }

    @Delegated
    default EditorThemeConfig requestEditorThemeConfig(String fileType) {
        return null;
    }

    @Delegated
    default CompletableFuture<Boolean> requestApplyWorkspaceEdit(IdeWorkspaceEdit edit) {
        return CompletableFuture.completedFuture(false);
    }

    @Delegated
    default void requestRefreshDiagnostics(Path path) {}

    @Delegated
    default void requestRefreshCodeLenses(Path path) {}

    @Delegated
    default void requestRefreshInlayHints(Path path) {}

    @Delegated
    default void requestRefreshSemanticTokens(Path path) {}

    @Delegated
    default void requestRefreshCodeNavigationMenu() {}

    @Delegated
    default void requestShowCodeActions() {}

    @Delegated
    default void requestShowCodeActions(Path path) {}

    @Delegated
    default void requestRepaintCodeEditor() {}

    @Delegated
    default void requestRepaintCodeEditor(Path path) {}

    @Delegated
    default void requestRepaintCodeEditorBreakpointLine() {}

    @Delegated
    default void requestRepaintCodeEditorBreakpointLine(Path path) {}

    @Delegated
    default void requestCodeEditorAutocomplete(){}
}
