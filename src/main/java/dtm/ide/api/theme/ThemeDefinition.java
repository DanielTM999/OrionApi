package dtm.ide.api.theme;

import javax.swing.LookAndFeel;

public interface ThemeDefinition {

    String getThemeId();

    String getThemeName();

    LookAndFeel getTheme();

    boolean isNeedReload();

    ThemeColorMode getThemeColorMode();

    EditorTheme getEditorTheme();
}
