package dtm.ide.api.extension;

import dtm.ide.api.context.IdeProjectContext;

public interface IdeAdapterProjectLifecycleCallbacks {

    default void onProjectOpened(IdeProjectContext projectContext) {
    }

    default void onProjectClosed(IdeProjectContext projectContext) {
    }

    default void onProjectSwitched(IdeProjectContext oldContext, IdeProjectContext newContext) {
        if (oldContext != null) {
            onProjectClosed(oldContext);
        }
        if (newContext != null) {
            onProjectOpened(newContext);
        }
    }

    default void clearCaches() {
    }
}
