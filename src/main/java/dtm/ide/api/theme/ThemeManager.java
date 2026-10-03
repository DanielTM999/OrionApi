package dtm.ide.api.theme;

import java.util.Set;

public interface ThemeManager {

    Set<ThemeDefinition> getAllThemes();

    ThemeDefinition getTheme(String id);

    ThemeDefinition getTheme(String id, ThemeDefinition defaultTheme);

    ThemeDefinition getCurrentTheme();

    EditorTheme getCurrentEditorTheme();

    void setThemeById(String id);

    boolean isCurrentTheme(String id);

    String getCurrentThemeId();

    void addThemeListener(Runnable listener);

    void addThemeListener(String id, Runnable listener);

    void removeThemeListener(String id);
}
