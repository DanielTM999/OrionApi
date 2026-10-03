package dtm.ide.api.theme;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface EditorThemeManager {

    List<EditorThemeDefinition> getAvailableThemes();

    EditorThemeDefinition getTheme(String id);

    String getSelectedThemeId();

    EditorTheme getSelectedTheme();

    EditorTheme getCurrentEditorTheme();

    Path getThemesDirectory();

    boolean selectTheme(String id);

    void clearSelection();

    void reloadThemes();

    EditorThemeDefinition importTheme(Path source, boolean replaceExisting) throws IOException;

    void addListener(String id, Runnable listener);

    void removeListener(String id);
}
