package dtm.ide.api.extension.output;

import javax.swing.JComponent;

public class OutputPanelContext {

    private final JComponent component;
    private final OutputPanelAreaPosition position;
    private final int width;
    private final int height;
    private final boolean resizable;
    private final Long processPid;

    public OutputPanelContext(JComponent component, OutputPanelAreaPosition position, int width, int height) {
        this(component, position, width, height, true);
    }

    public OutputPanelContext(
            JComponent component,
            OutputPanelAreaPosition position,
            int width,
            int height,
            boolean resizable
    ) {
        this(component, position, width, height, resizable, null);
    }

    public OutputPanelContext(
            JComponent component,
            OutputPanelAreaPosition position,
            int width,
            int height,
            boolean resizable,
            Long processPid
    ) {
        this.component = component;
        this.position = position == null ? OutputPanelAreaPosition.RIGHT : position;
        this.width = width;
        this.height = height;
        this.resizable = resizable;
        this.processPid = processPid;
    }

    public static OutputPanelContext monitoring(long processPid) {
        return new OutputPanelContext(null, null, 0, 0, true, processPid);
    }

    public OutputPanelContext withProcessPid(long processPid) {
        return new OutputPanelContext(component, position, width, height, resizable, processPid);
    }

    public Long getProcessPid() {
        return processPid;
    }

    public static OutputPanelContext of(JComponent component, OutputPanelAreaPosition position, int width, int height) {
        return new OutputPanelContext(component, position, width, height);
    }

    public static OutputPanelContext of(
            JComponent component,
            OutputPanelAreaPosition position,
            int width,
            int height,
            boolean resizable
    ) {
        return new OutputPanelContext(component, position, width, height, resizable);
    }

    public static OutputPanelContext fixed(JComponent component, OutputPanelAreaPosition position, int width, int height) {
        return new OutputPanelContext(component, position, width, height, false);
    }

    public JComponent getComponent() {
        return component;
    }

    public OutputPanelAreaPosition getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isResizable() {
        return resizable;
    }

    public boolean isFixed() {
        return !resizable;
    }
}
