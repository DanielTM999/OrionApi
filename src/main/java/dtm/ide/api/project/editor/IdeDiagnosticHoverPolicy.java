package dtm.ide.api.project.editor;

import dtm.stools.component.panels.editor.code.diagnostics.DiagnosticSeverity;

public record IdeDiagnosticHoverPolicy(boolean enabled, Order order, DiagnosticSeverity minimumSeverity) {

    public enum Order {
        DOCUMENTATION_FIRST,
        DIAGNOSTIC_FIRST
    }

    public IdeDiagnosticHoverPolicy {
        order = order == null ? Order.DOCUMENTATION_FIRST : order;
        minimumSeverity = minimumSeverity == null ? DiagnosticSeverity.HINT : minimumSeverity;
    }

    public static IdeDiagnosticHoverPolicy disabled() {
        return new IdeDiagnosticHoverPolicy(false, Order.DOCUMENTATION_FIRST, DiagnosticSeverity.HINT);
    }

    public static IdeDiagnosticHoverPolicy documentationFirst() {
        return new IdeDiagnosticHoverPolicy(true, Order.DOCUMENTATION_FIRST, DiagnosticSeverity.HINT);
    }

    public static IdeDiagnosticHoverPolicy diagnosticFirst() {
        return new IdeDiagnosticHoverPolicy(true, Order.DIAGNOSTIC_FIRST, DiagnosticSeverity.HINT);
    }

    public IdeDiagnosticHoverPolicy withMinimumSeverity(DiagnosticSeverity severity) {
        return new IdeDiagnosticHoverPolicy(enabled, order, severity);
    }

    public boolean accepts(DiagnosticSeverity severity) {
        return enabled && severity != null && severity.ordinal() <= minimumSeverity.ordinal();
    }

    public boolean showsDiagnosticFirst() {
        return enabled && order == Order.DIAGNOSTIC_FIRST;
    }
}
