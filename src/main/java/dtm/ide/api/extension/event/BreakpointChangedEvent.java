package dtm.ide.api.extension.event;

import dtm.ide.api.project.editor.BreakpointIde;
import dtm.ide.api.project.editor.IdeEditorContext;
import lombok.Getter;

import java.nio.file.Path;

@Getter
public class BreakpointChangedEvent {
    private final BreakpointIde breakpointIde;
    private final Path file;
    private final IdeEditorContext editorContext;
    private final boolean breakpointAdded;
    private final BreakpointChangeType changeType;
    private final String condition;

    public BreakpointChangedEvent(
            BreakpointIde breakpointIde,
            Path file,
            IdeEditorContext editorContext,
            boolean breakpointAdded
    ) {
        this(breakpointIde, file, editorContext, breakpointAdded, BreakpointChangeType.BREAKPOINT, null);
    }

    public BreakpointChangedEvent(
            BreakpointIde breakpointIde,
            Path file,
            IdeEditorContext editorContext,
            boolean breakpointAdded,
            BreakpointChangeType changeType,
            String condition
    ) {
        this.breakpointIde = breakpointIde;
        this.file = file;
        this.editorContext = editorContext;
        this.breakpointAdded = breakpointAdded;
        this.changeType = changeType == null ? BreakpointChangeType.BREAKPOINT : changeType;
        this.condition = condition;
    }
}
