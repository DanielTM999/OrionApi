package dtm.ide.api.project;

import dtm.ide.api.context.ProjectContext;

import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.util.function.BiConsumer;

public interface IdeProjectFileWatcher {
    ProjectContext getProjectContext();

    String addFileWatcherListener(BiConsumer<Path, WatchEvent.Kind<?>> consumer);

    boolean removeFileWatcherListener(String listenerId);

    void releaseDirectory(Path directory);

    void close();
}
