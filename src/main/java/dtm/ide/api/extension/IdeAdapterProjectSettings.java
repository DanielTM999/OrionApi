package dtm.ide.api.extension;

import dtm.ide.api.context.IdeProjectContext;

public interface IdeAdapterProjectSettings extends IdeAdapterProjectSettingsCallbacks, IdeAdapterProjectSettingsActions {

    @Override
    default boolean isProjectOpen() {
        IdeProjectContext context = getProjectContext();
        return context != null && context.isOpen();
    }
}
