package dtm.ide.api.extension.output;

import dtm.ide.api.extension.runconfig.RunProcessHandle;

public record OutputPanelOptions(
        OutputPanelMode mode,
        OutputPanelContext context,
        RunProcessHandle processHandle
) {

    public OutputPanelOptions {
        mode = mode == null ? OutputPanelMode.OUTPUT : mode;
    }

    public static OutputPanelOptions output() {
        return new OutputPanelOptions(OutputPanelMode.OUTPUT, null, null);
    }

    public static OutputPanelOptions output(OutputPanelContext context) {
        return new OutputPanelOptions(OutputPanelMode.OUTPUT, context, null);
    }

    public static OutputPanelOptions interactive(RunProcessHandle processHandle) {
        return new OutputPanelOptions(OutputPanelMode.INTERACTIVE, null, processHandle);
    }

    public static OutputPanelOptions interactive(OutputPanelContext context, RunProcessHandle processHandle) {
        return new OutputPanelOptions(OutputPanelMode.INTERACTIVE, context, processHandle);
    }
}
