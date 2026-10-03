package dtm.ide.api.credentials;

import dtm.ide.api.annotations.Delegated;

import java.util.function.Consumer;

public interface PlatformCredentialManagerProvider {

    @Delegated
    default boolean isCredentialManagerEnabled() {
        return false;
    }

    @Delegated
    default PlatformCredentialManager getCredentialManager() {
        return null;
    }

    @Delegated
    default void executeIfCredentialManagerEnabled(Consumer<PlatformCredentialManager> action) {
    }

}
