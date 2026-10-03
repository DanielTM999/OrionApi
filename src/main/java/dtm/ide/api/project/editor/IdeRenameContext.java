package dtm.ide.api.project.editor;

import java.nio.file.Path;
import java.util.Map;

public record IdeRenameContext(
        String text,
        Path filePath,
        int line,
        int col,
        int offset,
        String newName,
        Map<String, Boolean> options
) {

    public IdeRenameContext {
        options = options == null ? Map.of() : Map.copyOf(options);
    }

    public IdeRenameContext(String text, Path filePath, int line, int col, int offset, String newName) {
        this(text, filePath, line, col, offset, newName, Map.of());
    }

    public boolean option(String id) {
        return Boolean.TRUE.equals(options.get(id));
    }
}
