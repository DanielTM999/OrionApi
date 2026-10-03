package dtm.ide.api.context;

import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public interface ProjectContext {

    String getContextId();

    boolean isOpen();

    Optional<String> getProjectId();

    Optional<Path> getProjectPath();

    Optional<String> getProjectName();

    Map<String, Object> getProperties();

    <T> Optional<T> getProperty(String key, Class<T> type);

    void setProperty(String key, Object value);

    void openProject(Path projectPath);

    void closeProject();

    String registerProjectOpenedListener(Consumer<ProjectContext> listener);
    String registerProjectClosedListener(Consumer<ProjectContext> listener);

    boolean removeProjectOpenedListener(String id);
    boolean removeProjectClosedListener(String id);
}
