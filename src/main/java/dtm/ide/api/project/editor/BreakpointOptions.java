package dtm.ide.api.project.editor;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public record BreakpointOptions(String condition, String hitCondition, String logMessage) {

    private static final String PREFIX = "orion-bp:v1?";
    private static final BreakpointOptions EMPTY = new BreakpointOptions(null, null, null);

    public BreakpointOptions {
        condition = normalize(condition);
        hitCondition = normalize(hitCondition);
        logMessage = normalize(logMessage);
    }

    public static BreakpointOptions empty() {
        return EMPTY;
    }

    public static BreakpointOptions ofCondition(String condition) {
        return new BreakpointOptions(condition, null, null);
    }

    public boolean isEmpty() {
        return condition == null && hitCondition == null && logMessage == null;
    }

    public boolean hasCondition() {
        return condition != null;
    }

    public boolean hasHitCondition() {
        return hitCondition != null;
    }

    public boolean isLogPoint() {
        return logMessage != null;
    }

    public String encode() {
        if (isEmpty()) {
            return null;
        }
        if (hitCondition == null && logMessage == null && !condition.startsWith(PREFIX)) {
            return condition;
        }
        List<String> parts = new ArrayList<>();
        append(parts, "c", condition);
        append(parts, "h", hitCondition);
        append(parts, "l", logMessage);
        return PREFIX + String.join("&", parts);
    }

    public static BreakpointOptions decode(String stored) {
        if (stored == null || stored.isBlank()) {
            return EMPTY;
        }
        if (!stored.startsWith(PREFIX)) {
            return ofCondition(stored);
        }
        String condition = null;
        String hitCondition = null;
        String logMessage = null;
        for (String part : stored.substring(PREFIX.length()).split("&")) {
            int equals = part.indexOf('=');
            if (equals <= 0) {
                continue;
            }
            String value = URLDecoder.decode(part.substring(equals + 1), StandardCharsets.UTF_8);
            switch (part.substring(0, equals)) {
                case "c" -> condition = value;
                case "h" -> hitCondition = value;
                case "l" -> logMessage = value;
                default -> {
                }
            }
        }
        return new BreakpointOptions(condition, hitCondition, logMessage);
    }

    private static void append(List<String> parts, String key, String value) {
        if (value != null) {
            parts.add(key + "=" + URLEncoder.encode(value, StandardCharsets.UTF_8));
        }
    }

    private static String normalize(String value) {
        return value == null || value.isBlank() ? null : value.trim();
    }
}
