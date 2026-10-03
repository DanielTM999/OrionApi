package dtm.ide.api.context;

import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public final class IdeProjectContext {

    private final ProjectContext projectContext;

    public IdeProjectContext(ProjectContext projectContext) {
        this.projectContext = projectContext;
    }

    public String getContextId() {
        return projectContext.getContextId();
    }

    public boolean isOpen() {
        return projectContext.isOpen();
    }

    public Optional<String> getProjectId() {
        return projectContext.getProjectId();
    }

    public Optional<Path> getProjectPath() {
        return projectContext.getProjectPath();
    }

    public Optional<String> getProjectName() {
        return projectContext.getProjectName();
    }

    public Map<String, Object> getProperties() {
        return projectContext.getProperties();
    }

    public <T> Optional<T> getProperty(String key, Class<T> type) {
        return projectContext.getProperty(key, type);
    }

    public void setProperty(String key, Object value) {
        projectContext.setProperty(key, value);
    }

    public String registerProjectOpenedListener(Consumer<IdeProjectContext> listener) {
        return projectContext.registerProjectOpenedListener(ctx -> listener.accept(this));
    }

    public String registerProjectClosedListener(Consumer<IdeProjectContext> listener) {
        return projectContext.registerProjectClosedListener(ctx -> listener.accept(this));
    }

    public boolean removeProjectOpenedListener(String id) {
        return projectContext.removeProjectOpenedListener(id);
    }

    public boolean removeProjectClosedListener(String id) {
        return projectContext.removeProjectClosedListener(id);
    }
}
