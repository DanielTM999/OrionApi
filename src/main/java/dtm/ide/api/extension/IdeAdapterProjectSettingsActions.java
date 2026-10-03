package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;
import dtm.ide.api.context.IdeProjectContext;

public interface IdeAdapterProjectSettingsActions {

    @Delegated
    default IdeProjectContext getProjectContext() { return null; }
}
