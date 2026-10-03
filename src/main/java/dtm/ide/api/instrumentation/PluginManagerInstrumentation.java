package dtm.ide.api.instrumentation;

import dtm.di.exceptions.NewInstanceException;
import dtm.ide.api.plugin.PluginScope;

import java.util.List;
import java.util.Set;

public interface PluginManagerInstrumentation {

    void reload();
    boolean isLoaded();
    void awaitDiscovery();

    boolean deleteCollectionPlugin(String name);

    String switchPluginVersion(PluginInstrumentation plugin, String newVersion) throws PluginVersionNotFoundInstrumentationException;

    String switchPluginVersion(Class<?> pluginClass, String newVersion) throws PluginVersionNotFoundInstrumentationException;

    String switchPluginVersion(String pluginClassName, String newVersion) throws PluginVersionNotFoundInstrumentationException;

    void switchCollectionVersion(String collectionName, String version) throws PluginVersionNotFoundInstrumentationException;

    boolean disablePluginCollection(String collectionId);
    boolean activatePluginCollection(String collectionId);

    boolean disablePlugin(PluginInstrumentation plugin);
    boolean activatePlugin(PluginInstrumentation plugin);

    List<PluginCollectionInstrumentation> getPluginCollections();
    List<List<PluginCollectionSlotInstrumentation>> getPluginCollectionsByVersion();

    boolean hasPluginsCollection(String name);
    boolean hasPluginsCollection(String name, String version);

    List<List<PluginInstrumentation>> getPluginsGroupedByVersion();

    Set<PluginInstrumentation> getActivePlugins();
    Set<PluginInstrumentation> getActivePluginsByScope(PluginScope scope);

    Set<PluginInstrumentation> getAllPlugins();
    Set<PluginInstrumentation> getAllPlugins(boolean all);

    Set<PluginInstrumentation> getAllPluginByClass(Class<?> targetClass);
    Set<PluginInstrumentation> getAllPluginByClass(Class<?> targetClass, boolean all);

    <T> T newInstance(PluginInstrumentation plugin, Object... args) throws NewInstanceException;
    <T> T newInstanceWithAspect(PluginInstrumentation plugin, Object... args) throws NewInstanceException;

    boolean installPlugin(byte[] jarBytes, String fileName);

    int getPluginsCollectionLoadedCount();
    int getPluginsCollectionCount();

    PluginCollectionMetainfoInstrumentation getPluginCollectionSettings(Class<?> pluginClass);
}
