package dtm.ide.api.extension.menu;

import dtm.stools.component.menu.bar.event.MenuBarEvent;
import dtm.stools.component.menu.bar.tree.MenuNode;

import java.util.function.Consumer;

public interface IdeMenuBarBuilder {

    IdeMenuBarBuilder add(MenuNode node);

    IdeMenuBarBuilder add(MenuNode... nodes);

    IdeMenuBarBuilder item(String id, String text, Consumer<MenuBarEvent> onClick);

    IdeMenuBarBuilder submenu(String id, String text, Consumer<IdeMenuBarBuilder> builder);

    IdeMenuBarBuilder separator();

    IdeMenuBarBuilder at(int index);

    IdeMenuBarBuilder into(String menuId);

    IdeMenuBarBuilder into(String menuId, Consumer<IdeMenuBarBuilder> builder);
}
