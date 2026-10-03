package dtm.ide.api.registry;

import java.util.List;
import java.util.Optional;

public interface ToolWindowRegistry {

    void register(ToolWindowDescriptor descriptor);

    boolean unregister(String toolWindowId);

    Optional<ToolWindowDescriptor> get(String toolWindowId);

    List<ToolWindowDescriptor> getAll();

    List<ToolWindowDescriptor> getByAnchor(ToolWindowDescriptor.Anchor anchor);
}
