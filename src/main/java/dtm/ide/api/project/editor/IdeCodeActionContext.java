package dtm.ide.api.project.editor;

import dtm.stools.component.panels.editor.code.api.Range;
import dtm.stools.component.panels.editor.code.diagnostics.Diagnostic;

import java.nio.file.Path;
import java.util.List;

public record IdeCodeActionContext(
        String text,
        Path filePath,
        Range range,
        List<Diagnostic> diagnostics
) {}
