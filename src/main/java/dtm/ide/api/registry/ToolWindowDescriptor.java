package dtm.ide.api.registry;

import lombok.Builder;
import lombok.Data;

import javax.swing.JComponent;
import java.util.function.Supplier;

@Data
@Builder
public class ToolWindowDescriptor {

    public enum Anchor { LEFT, RIGHT, BOTTOM, TOP }

    private final String id;
    private final String title;
    private final Anchor anchor;
    private final boolean visibleByDefault;
    private final Supplier<JComponent> componentFactory;
}
