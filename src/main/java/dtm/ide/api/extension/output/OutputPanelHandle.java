package dtm.ide.api.extension.output;

import java.io.Closeable;
import java.io.OutputStream;
import java.util.function.BooleanSupplier;
import java.util.function.LongSupplier;

public interface OutputPanelHandle extends Closeable {

    String getId();

    String getName();

    OutputStream getOutputStream();

    default OutputPanelHandle setInputEnabled(boolean enabled) {
        return this;
    }

    default OutputPanelHandle show() {
        return this;
    }

    default OutputPanelHandle onClosePanel(Runnable action) {
        return this;
    }

    default OutputPanelHandle attachProcessMonitor(long processPid) {
        return attachProcessMonitor(() -> processPid);
    }

    default OutputPanelHandle attachProcessMonitor(LongSupplier processPidSupplier) {
        return attachProcessMonitor(processPidSupplier, () -> false);
    }

    default OutputPanelHandle attachProcessMonitor(LongSupplier processPidSupplier, BooleanSupplier keepWaitingSupplier) {
        return this;
    }

    default OutputPanelHandle detachProcessMonitor() {
        return this;
    }

    void clear();

    @Override
    void close();
}
