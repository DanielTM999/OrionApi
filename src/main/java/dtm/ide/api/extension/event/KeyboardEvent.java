package dtm.ide.api.extension.event;

import java.awt.event.KeyEvent;

public record KeyboardEvent(
        int id,
        int keyCode,
        char keyChar,
        int modifiers,
        int modifiersEx,
        int keyLocation,
        long when,
        boolean actionKey,
        boolean consumed
) {

    public static KeyboardEvent of(KeyEvent event) {
        return new KeyboardEvent(
                event.getID(),
                event.getKeyCode(),
                event.getKeyChar(),
                event.getModifiers(),
                event.getModifiersEx(),
                event.getKeyLocation(),
                event.getWhen(),
                event.isActionKey(),
                event.isConsumed()
        );
    }

    public boolean isPressed() {
        return id == KeyEvent.KEY_PRESSED;
    }

    public boolean isReleased() {
        return id == KeyEvent.KEY_RELEASED;
    }

    public boolean isTyped() {
        return id == KeyEvent.KEY_TYPED;
    }
}
