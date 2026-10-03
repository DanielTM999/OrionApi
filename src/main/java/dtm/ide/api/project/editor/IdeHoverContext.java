package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeHoverContext(String text, Path filePath, int line, int col, int offset, long documentVersion) {
    public IdeHoverContext(String text, Path filePath, int line, int col, int offset) {
        this(text, filePath, line, col, offset, -1);
    }
}
