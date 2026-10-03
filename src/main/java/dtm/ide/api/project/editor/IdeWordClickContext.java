package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeWordClickContext(
        String text,
        Path filePath,
        String word,
        int line,
        int col,
        int startOffset,
        int endOffset,
        int mouseButton,
        int clickCount,
        int modifiersEx,
        IdeEditorContext editorContext
) {}
