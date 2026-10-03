package dtm.ide.api.extension.terminal;

public interface TerminalLinkHandle {

    String getId();

    String getOwnerId();

    default void unregister() {
    }
}
