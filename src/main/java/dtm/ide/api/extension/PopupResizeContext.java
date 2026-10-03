package dtm.ide.api.extension;

import javax.swing.JComponent;
import java.util.Objects;

public record PopupResizeContext(int width, int height, JComponent rootComponent) {

    public PopupResizeContext {
        Objects.requireNonNull(rootComponent, "rootComponent cannot be null");
    }
}
