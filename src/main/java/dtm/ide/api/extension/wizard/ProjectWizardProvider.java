package dtm.ide.api.extension.wizard;

import dtm.ide.api.extension.PluginContext;

import java.util.Collection;

public abstract class ProjectWizardProvider extends PluginContext {

    public abstract Collection<ProjectWizard> getProjectWizards();
}
