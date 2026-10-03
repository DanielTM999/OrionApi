package dtm.ide.api.settings;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface SettingsRegistry {

    <T> void register(SettingKey<T> descriptor);

    <T> T get(SettingKey<T> key);

    <T> void set(SettingKey<T> key, T value);

    List<SettingKey<?>> getAll();

    List<SettingKey<?>> getByCategory(String category);

    Map<String, Object> getRawValues();

    void exportTo(Path path);

    void importFrom(Path path);
}
