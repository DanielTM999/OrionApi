package dtm.ide.api.project.tree;

import java.nio.file.Path;
import java.util.List;

public record ProjectTreeDragContext(
        Path projectPath,
        List<Path> sourcePaths,
        Path targetPath,
        int targetIndex,
        ProjectTreeDragOrigin origin
) {

    public ProjectTreeDragContext {
        projectPath = normalize(projectPath);
        sourcePaths = sourcePaths == null
                ? List.of()
                : sourcePaths.stream()
                .map(ProjectTreeDragContext::normalize)
                .toList();
        targetPath = normalize(targetPath);
        origin = origin != null ? origin : ProjectTreeDragOrigin.INTERNAL;
    }

    private static Path normalize(Path path) {
        return path != null ? path.toAbsolutePath().normalize() : null;
    }
}
