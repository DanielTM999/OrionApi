package dtm.ide.api.extension;

import dtm.ide.api.extension.menu.IdeMenuBarBuilder;

public interface IdeAdapterMenuContributions {

    default void contributeMenuBar(IdeMenuBarBuilder menu) {}
}
