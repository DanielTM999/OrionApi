package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeInlayHintContext(
        String text,
        Path filePath,
        int firstLine,
        int lastLine
) {}
