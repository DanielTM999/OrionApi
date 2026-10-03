package dtm.ide.api.extension;

import lombok.Builder;
import lombok.Getter;

import javax.swing.Icon;

@Getter
@Builder
public class NotificationContext {

    private String title;
    private String message;
    private Icon icon;
    private Runnable action;

    public NotificationContext() {
    }

    public NotificationContext(String title, String message) {
        this(title, message, null, null);
    }

    public NotificationContext(String title, String message, Icon icon, Runnable action) {
        this.title = title;
        this.message = message;
        this.icon = icon;
        this.action = action;
    }
}
