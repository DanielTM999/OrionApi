package dtm.ide.api.instrumentation;

import java.nio.file.Path;
import java.util.Set;

public interface PluginCollectionMetainfoInstrumentation {
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
}
