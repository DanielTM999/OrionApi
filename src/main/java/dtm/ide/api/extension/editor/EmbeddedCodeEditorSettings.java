package dtm.ide.api.extension.editor;

public record EmbeddedCodeEditorSettings(boolean languageHighlight) {

    public static EmbeddedCodeEditorSettings defaults() {
        return new EmbeddedCodeEditorSettings(false);
    }

    public static EmbeddedCodeEditorSettings highlighted() {
        return new EmbeddedCodeEditorSettings(true);
    }

    public EmbeddedCodeEditorSettings withLanguageHighlight(boolean enabled) {
        return new EmbeddedCodeEditorSettings(enabled);
    }
}
