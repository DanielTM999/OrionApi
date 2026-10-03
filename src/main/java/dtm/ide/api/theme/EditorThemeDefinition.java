package dtm.ide.api.theme;

import java.nio.file.Path;

public record EditorThemeDefinition(
        String id,
        String name,
        Path source,
        EditorTheme theme
) {}
