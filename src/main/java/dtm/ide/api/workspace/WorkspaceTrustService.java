package dtm.ide.api.workspace;

import java.nio.file.Path;
import java.util.Optional;

public interface WorkspaceTrustService {

    Optional<TrustDecision> findDecision(Path path);

    TrustDecision decide(Path path);

    void remember(Path path, TrustDecision decision);

    boolean isTrusted(Path path);

    void forget(Path path);
}
