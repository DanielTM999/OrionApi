package dtm.ide.api.registry;

import lombok.Builder;
import lombok.Data;

import java.util.function.Consumer;

@Data
@Builder
public class IdeAction {
    private final String id;
    private final String label;
    private final String description;
    private final String keystroke;
    private final String category;
    private final Consumer<ActionEvent> handler;

    @Data
    @Builder
    public static class ActionEvent {
        private final String actionId;
        private final Object source;
    }
}
