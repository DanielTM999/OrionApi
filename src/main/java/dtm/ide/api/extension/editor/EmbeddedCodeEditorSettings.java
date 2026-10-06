package dtm.ide.api.extension.editor;

public record EmbeddedCodeEditorSettings(boolean languageHighlight, boolean availableAdapterHighlight) {

    public EmbeddedCodeEditorSettings(boolean languageHighlight) {
        this(languageHighlight, false);
    }

    public static EmbeddedCodeEditorSettings defaults() {
        return new EmbeddedCodeEditorSettings(false, false);
    }

    public static EmbeddedCodeEditorSettings highlighted() {
        return new EmbeddedCodeEditorSettings(true, false);
    }

    public EmbeddedCodeEditorSettings withLanguageHighlight(boolean enabled) {
        return new EmbeddedCodeEditorSettings(enabled, availableAdapterHighlight);
    }

    /** Resolve lexical highlight from an enabled adapter for the virtual file name. */
    public EmbeddedCodeEditorSettings withAvailableAdapterHighlight(boolean enabled) {
        return new EmbeddedCodeEditorSettings(languageHighlight, enabled);
    }
}
