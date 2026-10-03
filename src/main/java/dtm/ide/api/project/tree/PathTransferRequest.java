package dtm.ide.api.project.tree;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public record PathTransferRequest(
        Path projectPath,
        PathTransferKind kind,
        Path targetDirectory,
        List<PathTransfer> transfers,
        ProjectTreeDragOrigin origin
) {

    public PathTransferRequest {
        projectPath = normalize(projectPath);
        kind = kind != null ? kind : PathTransferKind.MOVE;
        targetDirectory = normalize(targetDirectory);
        transfers = transfers == null ? List.of() : List.copyOf(transfers);
        origin = origin != null ? origin : ProjectTreeDragOrigin.INTERNAL;
    }

    public List<Path> sources() {
        return transfers.stream().map(PathTransfer::source).toList();
    }

    public PathTransferRequest withTransfers(List<PathTransfer> newTransfers) {
        return new PathTransferRequest(projectPath, kind, targetDirectory, newTransfers, origin);
    }

    public PathTransferRequest retarget(Map<Path, Path> newTargets) {
        if (newTargets == null || newTargets.isEmpty()) {
            return this;
        }
        return withTransfers(transfers.stream()
                .map(transfer -> {
                    Path replacement = newTargets.get(transfer.source());
                    return replacement != null ? transfer.withTarget(replacement) : transfer;
                })
                .toList());
    }

    private static Path normalize(Path path) {
        return path != null ? path.toAbsolutePath().normalize() : null;
    }
}
