package dtm.ide.api.extension.settings;

import dtm.ide.api.settings.SettingKey;

import javax.swing.JComponent;
import java.util.List;

public interface PluginSettingsPage {

    String getTitle();

    JComponent getView();

    default void onApply() {
    }

    default void onRestoreDefaults() {
    }

    default List<SettingKey<?>> getSettingKeys() {
        return List.of();
    }
}
