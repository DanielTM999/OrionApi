package dtm.ide.api.project.tree;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public sealed interface PathTransferDecision {

    static PathTransferDecision proceed() {
        return Proceed.INSTANCE;
    }

    static PathTransferDecision cancel() {
        return Cancel.INSTANCE;
    }

    static PathTransferDecision retarget(Map<Path, Path> newTargets) {
        if (newTargets == null || newTargets.isEmpty()) {
            return proceed();
        }
        Map<Path, Path> normalized = new LinkedHashMap<>();
        newTargets.forEach((source, target) -> {
            if (source != null && target != null) {
                normalized.put(source.toAbsolutePath().normalize(), target.toAbsolutePath().normalize());
            }
        });
        return new Retarget(Map.copyOf(normalized));
    }

    default boolean cancelled() {
        return this instanceof Cancel;
    }

    final class Proceed implements PathTransferDecision {
        private static final Proceed INSTANCE = new Proceed();

        private Proceed() {
        }
    }

    final class Cancel implements PathTransferDecision {
        private static final Cancel INSTANCE = new Cancel();

        private Cancel() {
        }
    }

    record Retarget(Map<Path, Path> newTargets) implements PathTransferDecision {
    }
}
