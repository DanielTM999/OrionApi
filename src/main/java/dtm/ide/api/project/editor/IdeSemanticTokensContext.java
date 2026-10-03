package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeSemanticTokensContext(String text, Path filePath, long documentVersion) {
    public IdeSemanticTokensContext(String text, Path filePath) {
        this(text, filePath, -1);
    }
}
