package dtm.ide.api.exceptions;

import dtm.stools.component.popup.ModernDialog;
import lombok.Getter;

import java.awt.Color;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class DisplayException extends RuntimeException {

    private final AtomicBoolean cancel = new AtomicBoolean(false);

    private String displayTitle = "Erro";
    private ModernDialog.Type displayType = ModernDialog.Type.ERROR;
    private Color accentColor = null;
    private boolean draggable = false;
    private boolean stackInMessage = false;

    public DisplayException() {
        super();
    }

    public DisplayException(String message) {
        super(message);
    }

    public DisplayException(Throwable cause) {
        super(cause);
    }

    public DisplayException(String message, Throwable cause) {
        super(message, cause);
    }

    public DisplayException title(String title) {
        this.displayTitle = title;
        return this;
    }

    public DisplayException type(ModernDialog.Type type) {
        this.displayType = type;
        return this;
    }

    public DisplayException stackInMessage() {
        this.stackInMessage = true;
        return this;
    }

    public DisplayException accent(Color color) {
        this.accentColor = color;
        return this;
    }

    public DisplayException draggable(boolean draggable) {
        this.draggable = draggable;
        return this;
    }

    public final void cancel() {
        cancel.compareAndSet(false, true);
    }

    public final boolean isCancelled() {
        return cancel.get();
    }
}
