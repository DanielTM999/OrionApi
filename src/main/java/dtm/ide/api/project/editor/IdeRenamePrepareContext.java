package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeRenamePrepareContext(
        String text,
        Path filePath,
        int line,
        int col,
        int offset,
        String wordAtCaret
) {}
