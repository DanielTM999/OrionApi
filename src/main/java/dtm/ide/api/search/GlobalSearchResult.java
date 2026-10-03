package dtm.ide.api.search;

import java.util.ArrayList;
import java.util.List;

public record GlobalSearchResult(List<GlobalSearchMatch> matches) {

    public GlobalSearchResult {
        matches = matches == null ? List.of() : List.copyOf(matches);
    }

    public static GlobalSearchResult empty() {
        return new GlobalSearchResult(List.of());
    }

    public static GlobalSearchResult of(List<GlobalSearchMatch> matches) {
        return new GlobalSearchResult(matches);
    }

    public boolean isEmpty() {
        return matches.isEmpty();
    }

    public GlobalSearchResult merge(GlobalSearchResult other) {
        if (other == null || other.isEmpty()) {
            return this;
        }
        List<GlobalSearchMatch> merged = new ArrayList<>(matches);
        merged.addAll(other.matches());
        return new GlobalSearchResult(merged);
    }
}
