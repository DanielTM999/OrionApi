package dtm.ide.api.registry;

import java.util.List;

public interface ExtensionPointRegistry {

    <T> void declare(String extensionPointId, Class<T> contractType);

    <T> String register(String extensionPointId, T contribution);

    boolean unregister(String extensionPointId, String contributionId);

    <T> List<T> getExtensions(String extensionPointId, Class<T> contractType);

    boolean isDeclared(String extensionPointId);

    List<String> getDeclaredExtensionPoints();
}
