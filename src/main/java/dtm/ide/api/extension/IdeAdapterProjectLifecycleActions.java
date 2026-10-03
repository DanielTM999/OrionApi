package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;

import java.nio.file.Path;

public interface IdeAdapterProjectLifecycleActions {

    @Delegated
    default void requestOpenProject(Path projectPath) {
    }

    @Delegated
    default void requestOpenProject(Path projectPath, boolean addToRecents) {
    }
}
