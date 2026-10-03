package dtm.ide.api.extension;

import dtm.ide.api.extension.runconfig.RunConfigurationContribution;
import dtm.ide.api.extension.runconfig.RunConfigurationData;
import dtm.ide.api.extension.runconfig.RunExecutionContext;
import dtm.ide.api.extension.runconfig.RunProcessHandle;

import java.util.Collection;
import java.util.List;

public interface IdeAdapterRunConfigurationCallbacks {

    default List<RunConfigurationContribution> getRunConfigurationContributions() { return List.of(); }
    default Collection<RunConfigurationData> getStaticRunConfigurations() { return List.of(); }
    default void onRunConfigurationChanged(RunConfigurationData runConfiguration) {}
    default RunProcessHandle launch(RunConfigurationData runConfiguration, RunExecutionContext context) throws Exception { return RunProcessHandle.empty(); }
    default RunProcessHandle launchDebug(RunConfigurationData runConfiguration, RunExecutionContext context) throws Exception { return RunProcessHandle.empty(); }
    default RunProcessHandle launchCoverage(RunConfigurationData runConfiguration, RunExecutionContext context) throws Exception { return launch(runConfiguration, context); }
    default void stop(RunConfigurationData runConfiguration) throws Exception {}
    default void onHotReload(RunConfigurationData runConfiguration) throws Exception {}
}
