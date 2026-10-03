package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record IdeTabMenuContext(
        String tabKey,
        String title,
        Path filePath,
        boolean pinned,
        boolean dirty,
        boolean closable
) {}
