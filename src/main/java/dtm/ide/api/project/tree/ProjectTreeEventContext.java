package dtm.ide.api.project.tree;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public record ProjectTreeEventContext(
        Path projectPath,
        Path nodePath,
        List<Path> selectedPaths,
        ProjectTreeEventType eventType
) {

    public ProjectTreeEventContext {
        Objects.requireNonNull(projectPath, "projectPath");
        Objects.requireNonNull(eventType, "eventType");

        projectPath = projectPath.toAbsolutePath().normalize();
        nodePath = nodePath != null ? nodePath.toAbsolutePath().normalize() : null;
        selectedPaths = selectedPaths == null
                ? List.of()
                : selectedPaths.stream()
                        .filter(Objects::nonNull)
                        .map(p -> p.toAbsolutePath().normalize())
                        .toList();
    }
}
