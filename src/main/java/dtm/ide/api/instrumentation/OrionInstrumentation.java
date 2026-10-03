package dtm.ide.api.instrumentation;

public interface OrionInstrumentation {
    PluginManagerInstrumentation getPluginManagerInstrumentation();
    PluginManagerListenerInstrumentation getPluginManagerListenerInstrumentation();
}
