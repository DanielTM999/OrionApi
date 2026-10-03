package dtm.ide.api.instrumentation;

import java.util.List;

public interface PluginCollectionInstrumentation extends PluginCollectionMetainfoInstrumentation {
    List<List<PluginInstrumentation>> getPlugins();
}
