package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;
import dtm.ide.api.extension.terminal.TerminalLinkHandle;
import dtm.ide.api.extension.terminal.TerminalLinkProvider;

public interface IdeAdapterTerminalActions {

    @Delegated
    default TerminalLinkHandle registerTerminalLinkProvider(String ownerId, TerminalLinkProvider provider) {
        return null;
    }

    @Delegated
    default void unregisterTerminalLinkProvider(String handleId) {
    }

    @Delegated
    default void clearTerminalLinkProviders(String ownerId) {
    }
}
