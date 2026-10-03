package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeDocumentSymbolContext(String text, Path filePath) {}
