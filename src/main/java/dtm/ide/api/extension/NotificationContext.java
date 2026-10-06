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
    private boolean beep;
    private Runnable action;

    public NotificationContext() {
    }

    public NotificationContext(String title, String message) {
        this(title, message, null, null);
    }
    
    public NotificationContext(String title, String message, boolean beep) {
        this(title, message, null, beep, null);
    }

    public NotificationContext(String title, String message, Icon icon, Runnable action) {
         this(title, message, null, false, null);
    }
    
    public NotificationContext(String title, String message, Icon icon, boolean beep, Runnable action) {
        this.title = title;
        this.message = message;
        this.icon = icon;
        this.action = action;
        this.beep = beep;
    }
}
