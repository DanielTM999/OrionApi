package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeWordCaretContext(
        String text,
        Path filePath,
        String word,
        int line,
        int col,
        int startOffset,
        int endOffset,
        int mouseX,
        int mouseY,
        IdeEditorContext editorContext
) {}

