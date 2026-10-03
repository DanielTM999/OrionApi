package dtm.ide.api.extension;

import dtm.di.annotations.Inject;
import dtm.ide.api.context.ApplicationContext;
import dtm.ide.api.context.ApplicationPropertiesManager;
import dtm.ide.api.plugin.PluginCollectionMetainfo;
import dtm.ide.api.theme.ThemeManager;
import lombok.Getter;

public abstract class Context implements DelegatedContext {

    @Inject
    @Getter
    private ApplicationContext applicationContext;

    private final PluginCollectionMetainfo pluginCollectionMetainfo = null;

    public PluginCollectionMetainfo getMetainfo() {
        return pluginCollectionMetainfo;
    }

    public <T> T newInstance(Class<T> clazz, Object... args) {
        return applicationContext.newInstance(clazz, args);
    }

    public <T> T getService(Class<T> clazz) {
        return applicationContext.getService(clazz);
    }

    public ApplicationPropertiesManager getApplicationPropertiesManager() {
        return getService(ApplicationPropertiesManager.class);
    }

    public ThemeManager getThemeManager() {
        return getService(ThemeManager.class);
    }
}
