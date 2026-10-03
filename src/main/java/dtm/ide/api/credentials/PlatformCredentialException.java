package dtm.ide.api.credentials;

import dtm.stools.i18n.I18n;
import lombok.Getter;

@Getter
public class PlatformCredentialException extends RuntimeException {

    private final String operation;
    private final String namespace;
    private final String key;
    private final String reason;

    public PlatformCredentialException(String operation, String namespace, String key, String reason) {
        super(buildMessage(operation, namespace, key, reason));
        this.operation = operation;
        this.namespace = namespace;
        this.key = key;
        this.reason = reason;
    }

    public PlatformCredentialException(String operation, String reason) {
        this(operation, null, null, reason);
    }

    private static String buildMessage(String operation, String namespace, String key, String reason) {
        StringBuilder message = new StringBuilder(getText("message.operation", "credential operation"))
                .append(" '")
                .append(operation)
                .append("' ")
                .append(getText("message.failed", "failed"));

        if (namespace != null) {
            message.append(" [namespace=").append(namespace);
            message.append(", key=").append(key).append("]");
        }

        if (reason != null && !reason.isBlank()) {
            message.append(": ").append(reason);
        }

        return message.toString();
    }

    private static String getText(String key, String defaultValue) {
        return I18n.getText(PlatformCredentialException.class, key, defaultValue);
    }

    @Override
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

}
