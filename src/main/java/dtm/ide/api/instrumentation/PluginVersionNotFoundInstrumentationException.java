package dtm.ide.api.instrumentation;

public class PluginVersionNotFoundInstrumentationException extends Exception {

    private final String pluginId;
    private final String version;

    public PluginVersionNotFoundInstrumentationException(String pluginId, String version, Throwable cause) {
        super("Version '" + version + "' not found for plugin '" + pluginId + "'", cause);
        this.pluginId = pluginId;
        this.version = version;
    }

    public String getPluginId() {
        return pluginId;
    }

    public String getVersion() {
        return version;
    }
}
