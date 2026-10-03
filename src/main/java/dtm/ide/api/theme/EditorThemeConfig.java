package dtm.ide.api.theme;

import dtm.stools.component.panels.editor.code.prototype.Token;
import dtm.stools.component.panels.editor.code.prototype.styles.TextStyle;

import java.awt.Color;

public interface EditorThemeConfig {

    Color getColorByToken(Token token);

    default Color getColorByToken(String token) {
        return null;
    }

    default TextStyle getStyleByToken(Token token) {
        return token == null ? null : getStyleByToken(token.getType());
    }

    default TextStyle getStyleByToken(String token) {
        return null;
    }
}
