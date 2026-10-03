package dtm.ide.api.instrumentation;

import java.util.function.Consumer;

public interface PluginManagerListenerInstrumentation {
    void executeSilentAction(Consumer<PluginManagerInstrumentation> action);

    String registerPluginEvent(
            PluginEventInstrumentation eventType,
            Consumer<PluginInstrumentation> eventConsumer
    );

    boolean removePluginEvent(PluginEventInstrumentation eventType, String eventId);

    String registerLoadEvent(Consumer<PluginManagerInstrumentation> eventConsumer);
    boolean removeLoadEvent(String eventId);
}
