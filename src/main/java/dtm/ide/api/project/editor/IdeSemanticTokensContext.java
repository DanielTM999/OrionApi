package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeSemanticTokensContext(
        String text,
        Path filePath
) {}
