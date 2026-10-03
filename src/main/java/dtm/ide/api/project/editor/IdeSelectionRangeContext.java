package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeSelectionRangeContext(String text, Path filePath, int offset) {}
