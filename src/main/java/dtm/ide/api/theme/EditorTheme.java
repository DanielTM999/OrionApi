package dtm.ide.api.theme;

import dtm.ide.api.project.editor.SemanticToken;
import dtm.stools.component.panels.editor.code.documenthighlight.DocumentHighlight;
import dtm.stools.component.panels.editor.code.prototype.styles.TextStyle;

import java.awt.Color;

public interface EditorTheme extends EditorThemeConfig {

    EditorThemeConfig getConfigByFileType(String fileType);

    default Color documentHighlightColor(DocumentHighlight.Kind kind) {
        return null;
    }

    default TextStyle semanticTokenStyle(SemanticToken token) {
        return null;
    }

    default Color getBackground() {
        return null;
    }

    default Color getForeground() {
        return null;
    }

    default Color getCaretColor() {
        return null;
    }

    default Color getSelectionColor() {
        return null;
    }

    default Color getCurrentLineBackground() {
        return null;
    }

    default Color getGutterBackground() {
        return null;
    }

    default Color getLineNumberForeground() {
        return null;
    }
}
