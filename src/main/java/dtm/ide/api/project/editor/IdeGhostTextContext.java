package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeGhostTextContext(
        String text,
        Path filePath,
        int caretOffset,
        int caretLine,
        int caretCol,
        String currentLine,
        IdeGhostTextTriggerKind triggerKind
) {}
