package dtm.ide.api.project.tree;

import java.nio.file.Path;

public record PathTransfer(Path source, Path target) {

    public PathTransfer {
        source = normalize(source);
        target = normalize(target);
    }

    public PathTransfer withTarget(Path newTarget) {
        return new PathTransfer(source, newTarget);
    }

    private static Path normalize(Path path) {
        return path != null ? path.toAbsolutePath().normalize() : null;
    }
}
