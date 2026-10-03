package dtm.ide.api.settings;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.function.Predicate;

@Data
@Builder
public class SettingKey<T> {
    private final String id;
    private final Class<T> type;
    private final T defaultValue;
    private final Predicate<T> validator;
    private final String label;
    private final String category;
    private final List<String> options;

    public boolean isValid(T value) {
        return validator == null || validator.test(value);
    }
}
