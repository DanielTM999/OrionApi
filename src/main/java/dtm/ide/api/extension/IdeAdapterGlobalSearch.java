package dtm.ide.api.extension;

import dtm.ide.api.search.GlobalSearchQuery;
import dtm.ide.api.search.GlobalSearchResult;

import java.util.Collection;
import java.util.List;

public interface IdeAdapterGlobalSearch {

    default Collection<String> getIgnoredSearchExtensions(Collection<String> baseIgnoredExtensions) {
        return baseIgnoredExtensions;
    }

    default Collection<String> getAdditionalSearchableExtensions() {
        return null;
    }

    default GlobalSearchResult search(GlobalSearchQuery query, GlobalSearchResult defaultResult) {
        return defaultResult;
    }
}
