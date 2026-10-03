package dtm.ide.api.extension;

import javax.swing.JComponent;
import java.util.Objects;

public record PopupMoveContext(int x, int y, JComponent rootComponent) {

    public PopupMoveContext {
        Objects.requireNonNull(rootComponent, "rootComponent cannot be null");
    }
}
