package dtm.ide.api.extension;

public interface IdeAdapterProjectSettingsCallbacks {

    default boolean isProjectOpen() {
        return false;
    }
}
