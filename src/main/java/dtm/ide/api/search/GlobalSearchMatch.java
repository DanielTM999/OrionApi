package dtm.ide.api.search;

import java.nio.file.Path;

public record GlobalSearchMatch(
        Path file,
        int line,
        int startCol,
        int endCol,
        String preview,
        MatchKind kind
) {

    public static GlobalSearchMatch fileName(Path file) {
        return new GlobalSearchMatch(file, -1, -1, -1, null, MatchKind.FILE_NAME);
    }

    public static GlobalSearchMatch content(Path file, int line, int startCol, int endCol, String preview) {
        return new GlobalSearchMatch(file, line, startCol, endCol, preview, MatchKind.CONTENT);
    }

    public boolean hasLine() {
        return line >= 0;
    }

    public boolean hasSelection() {
        return line >= 0 && startCol >= 0 && endCol > startCol;
    }
}
