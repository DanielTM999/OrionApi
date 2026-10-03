package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeCodeLensContext(String text, Path filePath) {}
