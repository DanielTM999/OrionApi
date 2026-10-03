package dtm.ide.api.extension.terminal;

public record TerminalLink(int startOffset, int endOffset, Runnable action, boolean requiresModifier) {

    public TerminalLink(int startOffset, int endOffset, Runnable action) {
        this(startOffset, endOffset, action, true);
    }

    public boolean isValid() {
        return action != null && startOffset >= 0 && endOffset > startOffset;
    }
}
