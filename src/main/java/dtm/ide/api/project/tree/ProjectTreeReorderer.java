package dtm.ide.api.project.tree;

import java.nio.file.Path;
import java.util.List;

@FunctionalInterface
public interface ProjectTreeReorderer {

    String EXTENSION_POINT_ID = "workbench.projectTree.reorderer";

    List<Path> reorder(ProjectTreeReorderContext context, List<Path> children);

    default boolean supports(ProjectTreeReorderContext context) {
        return true;
    }

    default int priority() {
        return 0;
    }
}
