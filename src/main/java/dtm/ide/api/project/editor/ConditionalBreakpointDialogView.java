package dtm.ide.api.project.editor;

import java.awt.Component;
import java.awt.Window;

public interface ConditionalBreakpointDialogView {

    ConditionalBreakpointContext getBreakpointContext();

    IdeEditorContext getConditionEditorContext();

    void setTitle(String title);

    void setDescription(String description);

    void setEnabledCheckBoxVisible(boolean visible);

    void setEnabledCheckBoxText(String text);

    boolean isBreakpointEnabled();

    void setBreakpointEnabled(boolean enabled);

    void setSaveButtonText(String text);

    void setCancelButtonText(String text);

    void addComponent(Component component);

    Window getDialogWindow();

    default void setHitConditionSupported(boolean supported) {
    }

    default void setLogMessageSupported(boolean supported) {
    }

    default void setConditionStatus(ConditionStatus status, String message) {
    }

    default void addCloseListener(Runnable listener) {
    }
}
