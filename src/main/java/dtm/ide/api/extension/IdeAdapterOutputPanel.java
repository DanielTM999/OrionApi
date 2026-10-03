package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;
import dtm.ide.api.extension.output.OutputPanelHandle;
import dtm.ide.api.extension.output.OutputPanelContext;
import dtm.ide.api.extension.output.OutputPanelOptions;

public interface IdeAdapterOutputPanel {

    @Delegated
    default OutputPanelHandle requestOutputPanel(String name) {
        return null;
    }

    @Delegated
    default OutputPanelHandle requestOutputPanel(String name, OutputPanelContext context) {
        return requestOutputPanel(name);
    }

    @Delegated
    default OutputPanelHandle requestOutputPanel(String name, OutputPanelOptions options) {
        return requestOutputPanel(name, options == null ? null : options.context());
    }

    @Delegated
    default void requestShowRunOutput() {
    }


    @Delegated
    default void requestSetRunOutputSize(int size) {
    }

    @Delegated
    default void requestShowRunOutput(int size) {
        requestShowRunOutput();
    }
}
