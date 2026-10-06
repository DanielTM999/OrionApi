package dtm.ide.api.extension;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import javax.swing.JComponent;
import java.awt.Dialog;
import java.awt.Dimension;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.BooleanSupplier;

@Getter
@Builder
public final class PlatformPopupBuilder {

    @NonNull
    private final JComponent component;
    private final String title;
    private final Dimension size;
    private final Dialog.ModalityType modalityType;
    private final Consumer<JComponent> onDrawing;
    private final Consumer<JComponent> onLoad;
    private final Consumer<JComponent> onClose;
    /** Return false to keep the popup open after a user close request. */
    private final BooleanSupplier onCloseRequest;
    private final Consumer<JComponent> onLostFocus;
    private final Consumer<JComponent> onFocus;
    private final Consumer<PopupResizeContext> onResize;
    private final Consumer<PopupMoveContext> onMove;
    private final Consumer<JComponent> onShow;
    private final Consumer<JComponent> onHidden;
    private final BiConsumer<String, Throwable> onError;

    public static class PlatformPopupBuilderBuilder {
        public PlatformPopupBuilderBuilder size(@NonNull Dimension size) {
            this.size = new Dimension(size);
            return this;
        }

        public PlatformPopupBuilderBuilder size(int width, int height) {
            return size(new Dimension(width, height));
        }
    }
}
