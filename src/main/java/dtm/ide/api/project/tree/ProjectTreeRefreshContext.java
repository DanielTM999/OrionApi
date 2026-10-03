package dtm.ide.api.project.tree;

import java.nio.file.Path;
import java.util.Objects;

public record ProjectTreeRefreshContext(
        Path projectPath,
        Path refreshRoot,
        Path changedPath,
        ProjectTreeChangeType changeType
) {

    public ProjectTreeRefreshContext {
        Objects.requireNonNull(projectPath, "projectPath");
        Objects.requireNonNull(refreshRoot, "refreshRoot");
        Objects.requireNonNull(changedPath, "changedPath");
        Objects.requireNonNull(changeType, "changeType");

        projectPath = projectPath.toAbsolutePath().normalize();
        refreshRoot = refreshRoot.toAbsolutePath().normalize();
        changedPath = changedPath.toAbsolutePath().normalize();
    }
}
