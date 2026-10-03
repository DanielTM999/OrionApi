package dtm.ide.api.search;

import java.nio.file.Path;
import java.util.List;

public record GlobalSearchQuery(
        String term,
        boolean caseSensitive,
        boolean wholeWord,
        boolean regex,
        String fileMask,
        Path projectPath,
        List<String> includeGlobs,
        List<String> excludeGlobs,
        int maxResults,
        long maxFileSizeBytes,
        boolean useIndex,
        boolean includeFileNames,
        boolean includeContent,
        boolean respectGitIgnore,
        List<String> scopeGlobs
) {

    private static final int DEFAULT_MAX_RESULTS = 500;
    private static final long DEFAULT_MAX_FILE_SIZE_BYTES = 2L * 1024L * 1024L;

    public GlobalSearchQuery {
        term = term == null ? "" : term;
        fileMask = fileMask == null || fileMask.isBlank() ? "*" : fileMask;
        projectPath = projectPath == null ? null : projectPath.toAbsolutePath().normalize();
        includeGlobs = includeGlobs == null ? List.of() : List.copyOf(includeGlobs);
        excludeGlobs = excludeGlobs == null ? List.of() : List.copyOf(excludeGlobs);
        scopeGlobs = scopeGlobs == null ? List.of() : List.copyOf(scopeGlobs);
        maxResults = maxResults <= 0 ? DEFAULT_MAX_RESULTS : maxResults;
        maxFileSizeBytes = maxFileSizeBytes <= 0 ? DEFAULT_MAX_FILE_SIZE_BYTES : maxFileSizeBytes;
    }

    public GlobalSearchQuery(
            String term,
            boolean caseSensitive,
            boolean wholeWord,
            boolean regex,
            String fileMask,
            Path projectPath,
            List<String> includeGlobs,
            List<String> excludeGlobs,
            int maxResults,
            long maxFileSizeBytes,
            boolean useIndex,
            boolean includeFileNames,
            boolean includeContent
    ) {
        this(term, caseSensitive, wholeWord, regex, fileMask, projectPath,
                includeGlobs, excludeGlobs, maxResults, maxFileSizeBytes,
                useIndex, includeFileNames, includeContent, false, List.of());
    }

    public GlobalSearchQuery(
            String term,
            boolean caseSensitive,
            boolean wholeWord,
            boolean regex,
            String fileMask,
            Path projectPath
    ) {
        this(term, caseSensitive, wholeWord, regex, fileMask, projectPath,
                List.of(), List.of(), DEFAULT_MAX_RESULTS, DEFAULT_MAX_FILE_SIZE_BYTES,
                true, true, true, false, List.of());
    }

    public boolean hasTerm() {
        return term != null && !term.isBlank();
    }

    public boolean hasScope() {
        return scopeGlobs != null && !scopeGlobs.isEmpty();
    }

    public boolean hasFileMask() {
        return fileMask != null && !fileMask.isBlank() && !"*".equals(fileMask.trim());
    }

    public String text() {
        return term;
    }

    public Path projectRoot() {
        return projectPath;
    }
}
