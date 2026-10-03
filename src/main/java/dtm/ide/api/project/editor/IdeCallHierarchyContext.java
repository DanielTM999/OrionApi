package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeCallHierarchyContext(
        String text,
        Path filePath,
        int line,
        int col,
        int offset
) {}
