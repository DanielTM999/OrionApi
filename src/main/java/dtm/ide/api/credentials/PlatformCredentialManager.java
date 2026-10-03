package dtm.ide.api.credentials;

public interface PlatformCredentialManager {

    void store(String namespace, String key, String secret);

    String retrieve(String namespace, String key);

    void delete(String namespace, String key);

    boolean isAvailable();

}
