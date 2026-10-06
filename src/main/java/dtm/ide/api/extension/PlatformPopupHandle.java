package dtm.ide.api.extension;

import java.awt.Dialog;

/** Controls a popup created by the workbench without exposing its Swing window. */
public interface PlatformPopupHandle {
    enum State {
        OPENING,
        VISIBLE,
        HIDDEN,
        CLOSED
    }

    State state();

    default boolean isOpen() {
        return state() != State.CLOSED;
    }

    Dialog.ModalityType modalityType();

    void focus();

    void close();
}
