package dtm.ide.api.context;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

public interface ApplicationProperties {

    <T> T getProperty(String key, Class<T> as, T defaultValue);

    <T, C extends Collection<T>> C getCollectionProperty(String key, Class<C> as, Class<T> parametrizedClass, C defaultValue);

    <T> T computeIfAbsent(String key, Class<T> as, Supplier<T> defaultAction);

    <T> T computeIfAbsent(String key, Class<T> as, Supplier<T> defaultAction, boolean autoCommit);

    boolean setProperty(String key, Object value);

    boolean setProperty(String key, Object value, boolean autoCommit);

    boolean removeProperty(String key);

    boolean removeProperty(String key, boolean autoCommit);

    boolean commitChanges();

    void reload();

    Map<String, Object> getAllProperties();

    void replaceAllProperties(Map<String, Object> values, boolean autoCommit);
}
