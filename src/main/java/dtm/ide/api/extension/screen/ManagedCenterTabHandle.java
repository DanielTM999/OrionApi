package dtm.ide.api.extension.screen;

public interface ManagedCenterTabHandle {

    String key();

    boolean isOpen();

    void select();

    void updateTitle(String title);

    boolean close();
}
