package dtm.ide.api.extension.screen;

import javax.swing.Icon;
import javax.swing.JComponent;
import java.util.Objects;

public record ManagedCenterTabRequest(
        String key,
        String title,
        JComponent component,
        boolean closable,
        Icon icon,
        ManagedCenterTabListener listener
) {

    public ManagedCenterTabRequest {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("Center tab key must not be blank");
        }
        component = Objects.requireNonNull(component, "component");
        title = title == null || title.isBlank() ? key : title;
        listener = listener == null ? new ManagedCenterTabListener() { } : listener;
    }

    public static ManagedCenterTabRequest of(String key, String title, JComponent component) {
        return new ManagedCenterTabRequest(key, title, component, true, null, null);
    }
}
