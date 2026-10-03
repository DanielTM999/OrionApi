package dtm.ide.api.project.tree;

import dtm.ide.api.context.ProjectContext;

import java.nio.file.Path;
import java.util.Objects;

public record ProjectTreeReorderContext(
        ProjectContext projectContext,
        Path projectPath,
        Path parentPath
) {

    public ProjectTreeReorderContext {
        Objects.requireNonNull(projectContext, "projectContext");
        Objects.requireNonNull(projectPath, "projectPath");
        Objects.requireNonNull(parentPath, "parentPath");

        projectPath = projectPath.toAbsolutePath().normalize();
        parentPath = parentPath.toAbsolutePath().normalize();
    }
}
