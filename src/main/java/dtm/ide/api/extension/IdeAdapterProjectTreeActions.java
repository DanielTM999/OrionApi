package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;

import java.nio.file.Path;
import java.util.Collection;

public interface IdeAdapterProjectTreeActions {

    @Delegated
    default void requestProjectTreeViewRefresh() {
    }

    @Delegated
    default void requestProjectTreeViewRefresh(boolean fullReload) {
    }

    @Delegated
    default void requestProjectTreeRevealCreated(Path path) {
    }

    @Delegated
    default void requestProjectTreeNodeIconRefresh(Collection<Path> paths) {
    }
}
