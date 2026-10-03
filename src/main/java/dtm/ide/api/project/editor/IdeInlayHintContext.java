package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeInlayHintContext(String text, Path filePath, int firstLine, int lastLine, long documentVersion) {
    public IdeInlayHintContext(String text, Path filePath, int firstLine, int lastLine) {
        this(text, filePath, firstLine, lastLine, -1);
    }
}
