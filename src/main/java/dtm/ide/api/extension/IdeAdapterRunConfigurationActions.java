package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;
import dtm.ide.api.extension.runconfig.RunBreakpointData;
import dtm.ide.api.extension.runconfig.RunConfigurationData;
import dtm.ide.api.extension.runconfig.RunProcessHandle;

import java.util.List;

public interface IdeAdapterRunConfigurationActions {

    @Delegated
    default List<RunBreakpointData> requestWorkspaceBreakpoints() {
        return List.of();
    }

    @Delegated
    default List<RunConfigurationData> requestRunConfigurations() {
        return List.of();
    }

    @Delegated
    default RunConfigurationData requestSaveRunConfiguration(RunConfigurationData configuration) {
        return configuration;
    }

    @Delegated
    default boolean requestRemoveRunConfiguration(String configurationId) {
        return false;
    }

    @Delegated
    default RunProcessHandle requestRunConfigurationExecution(String configurationId, boolean debug) {
        return RunProcessHandle.empty();
    }
}
