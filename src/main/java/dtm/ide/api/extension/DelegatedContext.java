package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;

import java.util.List;

public interface DelegatedContext {
    @Delegated
    default Resource getResource() {return null;}

    @Delegated
    default List<String> getApplicationArgs() {
        return List.of();
    }
}
