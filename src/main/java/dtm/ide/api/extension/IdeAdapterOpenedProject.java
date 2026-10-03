package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;

import java.nio.file.Path;
import java.util.Optional;

public interface IdeAdapterOpenedProject {

    @Delegated
    default Optional<Path> getCurrentOpenedProject() {
        return Optional.empty();
    }

    default void onProjectOpen(Path projectPath) {
    }
}
