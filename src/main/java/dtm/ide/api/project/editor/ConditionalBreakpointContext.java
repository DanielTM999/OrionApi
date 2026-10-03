package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record ConditionalBreakpointContext(
        Path file,
        int line,
        String currentCondition,
        IdeEditorContext sourceEditorContext
) {}
