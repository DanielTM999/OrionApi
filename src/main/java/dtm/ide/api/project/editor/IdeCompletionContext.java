package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeCompletionContext(String text, Path filePath, int caretOffset, int caretLine, int caretCol, String currentLine, String prefix, int prefixOffset, IdeCompletionTriggerKind triggerKind, long documentVersion) {
    public IdeCompletionContext(String text, Path filePath, int caretOffset, int caretLine,
                                int caretCol, String currentLine, String prefix,
                                int prefixOffset, IdeCompletionTriggerKind triggerKind) {
        this(text, filePath, caretOffset, caretLine, caretCol, currentLine, prefix, prefixOffset, triggerKind, -1);
    }
}
