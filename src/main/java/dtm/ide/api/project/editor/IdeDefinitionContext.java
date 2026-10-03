package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeDefinitionContext(
        String text,
        Path filePath,
        int line,
        int col,
        int offset
) {}
