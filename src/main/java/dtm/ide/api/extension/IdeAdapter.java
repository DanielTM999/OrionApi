package dtm.ide.api.extension;

import dtm.ide.api.credentials.PlatformCredentialManagerProvider;

import java.nio.file.Path;

public abstract class IdeAdapter extends PluginContext implements
        IdeAdapterProjectLifecycle,
        IdeAdapterSelectionCallbacks,
        IdeAdapterProjectSettings,
        IdeAdapterFileOperations,
        IdeAdapterEditorIntegration,
        IdeAdapterProjectTreeIntegration,
        IdeAdapterScreenActions,
        IdeAdapterDiagnosticsActions,
        IdeAdapterStatusBar,
        IdeAdapterRunConfigurations,
        IdeAdapterMenuContributions,
        IdeAdapterOutputPanel,
        IdeAdapterTerminalActions,
        IdeAdapterGlobalSearch,
        IdeAdapterSettings,
        IdeAdapterOpenedProject,
        PlatformCredentialManagerProvider
{

    public abstract boolean supports(Path projectPath);

    public abstract String getProjectType();

    public boolean handlesPath(Path path) {
        return true;
    }

    public void onUnload() {}
}
