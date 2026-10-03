package dtm.ide.api.extension.screen;

public interface ManagedCenterTabListener {

    default void onSelected() {
    }

    default void onClosed() {
    }

    default boolean onSaveRequested() {
        return false;
    }
}
