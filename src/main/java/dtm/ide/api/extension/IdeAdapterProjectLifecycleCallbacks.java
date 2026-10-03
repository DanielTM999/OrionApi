package dtm.ide.api.extension;

import dtm.ide.api.context.IdeProjectContext;

public interface IdeAdapterProjectLifecycleCallbacks {

    default void onProjectOpened(IdeProjectContext projectContext) {
    }

    default void onProjectClosed(IdeProjectContext projectContext) {
    }

    default void clearCaches() {
    }
}
