package dtm.ide.api.extension.menu;

import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public interface IdeMenuBuilder {

    IdeMenuBuilder item(String text, ActionListener actionListener);

    IdeMenuBuilder item(String text, Icon icon, ActionListener actionListener);

    IdeMenuBuilder item(String text, boolean enabled, ActionListener actionListener);

    IdeMenuBuilder item(String text, Icon icon, boolean enabled, ActionListener actionListener);

    IdeMenuBuilder submenu(String text, Consumer<IdeMenuBuilder> builder);

    IdeMenuBuilder submenu(String text, Icon icon, Consumer<IdeMenuBuilder> builder);

    IdeMenuBuilder submenu(String text, Icon icon, boolean enabled, Consumer<IdeMenuBuilder> builder);

    IdeMenuBuilder separator();

    IdeMenuBuilder at(int index);

    IdeMenuBuilder withId(String id);

    IdeMenuBuilder into(String submenuId);

    IdeMenuBuilder into(String submenuId, Consumer<IdeMenuBuilder> builder);
}
