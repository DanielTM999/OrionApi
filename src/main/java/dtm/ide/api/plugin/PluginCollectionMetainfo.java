package dtm.ide.api.plugin;

import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public interface PluginCollectionMetainfo {
    String getPluginCollectionId();
    String getPluginCollectionName();
    String getPluginCollectionVersion();
    String getPluginCollectionDescription();
    String getPluginCollectionAuthor();
    String getPluginCollectionAuthorEmail();
    String getPluginCollectionWebsite();
    String getPluginLicense();
    String getPluginMinimumAppVersion();
    String getPluginCollectionImage();
    Set<String> getPluginClassesNames();
    Path getPluginCollectionPath();
    URLClassLoader getPluginCollectionClassLoader();

    default List<String> getPermissions() {
        return List.of();
    }

    default boolean isRequiresRestart() {
        return false;
    }
}
