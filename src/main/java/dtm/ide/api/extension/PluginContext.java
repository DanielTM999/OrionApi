package dtm.ide.api.extension;

import dtm.di.utils.ProxyUtils;
import dtm.stools.i18n.I18n;
import java.util.concurrent.atomic.AtomicReference;

public abstract class PluginContext extends Context {

    private final AtomicReference<Class<?>> selfClass = new AtomicReference<>();

    public String getText(String key, String defaultValue) {
        Class<?> clazz = linkSelfClass();
        return I18n.getText(clazz, key, defaultValue);
    }

    public Class<?> getSelfClass() {
        return linkSelfClass();
    }

    public void releaseSelfClass(){
        selfClass.set(null);
    }

    protected Class<?> linkSelfClass() {
        return selfClass.updateAndGet(current -> {
            if (current == null) {
                Object instance = ProxyUtils.getRealInstanceProxy(PluginContext.this);
                return instance != null ? instance.getClass() : PluginContext.this.getClass();
            }

            return current;
        });
    }

}
