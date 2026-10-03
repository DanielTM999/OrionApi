package dtm.ide.api.instrumentation;

import dtm.ide.api.plugin.PluginScope;

import java.nio.file.Path;

public interface PluginInstrumentation {
    String getPluginClassName();
    Path getPathFile();
    boolean isStatic();
    long getPriority();
    boolean isEnabled();
    PluginScope getScope();
    String[] getDependsOn();

    String getCollectionId();
    String getCollectionName();
    String getCollectionVersion();
    String getWebsite();
    String getId();
    String getRefId();
    String getName();
    String getVersion();
    String getDescription();
}
