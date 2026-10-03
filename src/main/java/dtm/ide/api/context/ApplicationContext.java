package dtm.ide.api.context;

import dtm.di.exceptions.NewInstanceException;

import java.nio.file.Path;

public interface ApplicationContext {

    <T> T newInstance(Class<T> clazz) throws NewInstanceException;
    <T> T newInstance(Class<T> clazz, Object... args) throws NewInstanceException;

    <T> T getService(Class<T> clazz);

    WindowFactory getWindowFactory();

    ProjectContext getProjectContext();

    String getApplicationName();
    String getApplicationVersion();

    Path getPublicOsPath();
    Path getPublicOsPath(String component);

    Path getResourcesPath();
    boolean setResourcesPath(Path path);
    boolean setResourcesPath(Path path, boolean moveExistingContent);
}
