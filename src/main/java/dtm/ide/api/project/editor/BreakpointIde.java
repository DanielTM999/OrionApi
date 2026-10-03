package dtm.ide.api.project.editor;


public record BreakpointIde(int line, boolean active, String condition, String hitCondition,
                            String logMessage) {

    public BreakpointIde(int line, boolean active) {
        this(line, active, null, null, null);
    }

    public BreakpointIde(int line, boolean active, String condition) {
        this(line, active, condition, null, null);
    }

    public static BreakpointIde of(int line, boolean active, BreakpointOptions options) {
        BreakpointOptions resolved = options == null ? BreakpointOptions.empty() : options;
        return new BreakpointIde(line, active, resolved.condition(), resolved.hitCondition(),
                resolved.logMessage());
    }

    public BreakpointOptions options() {
        return new BreakpointOptions(condition, hitCondition, logMessage);
    }

    public boolean hasCondition() {
        return condition != null && !condition.isBlank();
    }

    public boolean hasHitCondition() {
        return hitCondition != null && !hitCondition.isBlank();
    }

    public boolean isLogPoint() {
        return logMessage != null && !logMessage.isBlank();
    }
}
