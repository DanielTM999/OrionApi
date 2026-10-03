package dtm.ide.api.extension;

import dtm.ide.api.extension.settings.PluginSettingsPage;

import java.util.List;

public interface IdeAdapterSettings {

    default List<PluginSettingsPage> getSettingsPages() {
        return List.of();
    }
}
