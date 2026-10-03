package dtm.ide.api.registry;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ActionRegistry {

    void register(IdeAction action);

    boolean unregister(String actionId);

    Optional<IdeAction> get(String actionId);

    List<IdeAction> getAll();

    List<IdeAction> getByCategory(String category);

    Map<String, List<IdeAction>> getShortcutConflicts();

    boolean execute(String actionId, Object source);
}
