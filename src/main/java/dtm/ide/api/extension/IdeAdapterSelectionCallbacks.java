package dtm.ide.api.extension;

import dtm.ide.api.context.IdeProjectContext;

public interface IdeAdapterSelectionCallbacks {

    default void onAdapterSelected(IdeProjectContext projectContext) {
    }
}
