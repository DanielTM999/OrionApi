package dtm.ide.api.project.diagnostics;

import dtm.stools.component.panels.editor.code.diagnostics.DiagnosticSeverity;

import java.nio.file.Path;

public record IdeProblem(Path file, int line, int column, DiagnosticSeverity severity, String message, String source, String code) {

    public IdeProblem {
        line = Math.max(0, line);
        column = Math.max(0, column);
        severity = severity == null ? DiagnosticSeverity.ERROR : severity;
        message = message == null ? "" : message;
        source = source == null ? "" : source;
        code = code == null ? "" : code;
    }

    public static IdeProblem of(Path file, int line, int column, DiagnosticSeverity severity, String message, String source) {
        return new IdeProblem(file, line, column, severity, message, source, "");
    }

    public static IdeProblem global(DiagnosticSeverity severity, String message, String source) {
        return new IdeProblem(null, 0, 0, severity, message, source, "");
    }

    public boolean hasLocation() {
        return line > 0;
    }
}
