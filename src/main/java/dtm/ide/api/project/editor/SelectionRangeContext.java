package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record SelectionRangeContext(Path filePath, String text, int offset, long documentVersion) {
}
