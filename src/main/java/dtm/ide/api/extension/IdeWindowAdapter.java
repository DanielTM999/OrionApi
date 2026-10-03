package dtm.ide.api.extension;

import dtm.ide.api.credentials.PlatformCredentialManagerProvider;


public abstract class IdeWindowAdapter extends PluginContext implements
        IdeAdapterEditorActions,
        IdeAdapterProjectLifecycle,
        IdeAdapterScreenActions,
        IdeAdapterDiagnosticsActions,
        IdeAdapterStatusBar,
        IdeAdapterOutputPanel,
        IdeAdapterMenuContributions,
        IdeAdapterSettings,
        IdeAdapterOpenedProject,
        PlatformCredentialManagerProvider {

    public void onLoad() {
    }

    public void onUnload() {
    }
}
