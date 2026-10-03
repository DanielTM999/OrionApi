package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeCompletionContext(
        String text,
        Path filePath,
        int caretOffset,
        int caretLine,
        int caretCol,
        String currentLine,
        String prefix,
        int prefixOffset,
        IdeCompletionTriggerKind triggerKind
) {}
