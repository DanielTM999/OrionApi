package dtm.ide.api.extension;

import dtm.ide.api.extension.menu.IdeMenuBuilder;
import dtm.ide.api.project.tree.ProjectTreeDragContext;
import dtm.ide.api.project.tree.ProjectTreeEventContext;
import dtm.ide.api.project.tree.ProjectTreeIgnoreRule;
import dtm.ide.api.project.tree.ProjectTreeNode;
import dtm.ide.api.project.tree.ProjectTreeNodeUpdate;
import dtm.ide.api.project.tree.ProjectTreeRefreshContext;

import javax.swing.Icon;
import java.nio.file.Path;
import java.util.List;

public interface IdeAdapterProjectTreeCallbacks {

    default boolean canDragProjectTree(ProjectTreeDragContext context) { return true; }
    default void onProjectTreeDragCompleted(ProjectTreeDragContext context) {}
    default void contributeProjectTreeMenu(IdeMenuBuilder menu, List<Path> selectedPaths) {}
    default ProjectTreeNode resolveProjectTreeRefreshPath(Path projectPath) { return null; }
    default ProjectTreeNode resolveProjectTreeReorganization(ProjectTreeNode currentRoot) { return null; }
    default ProjectTreeNode resolveProjectTreePartialRefreshPath(ProjectTreeRefreshContext context, ProjectTreeNode currentRoot) { return null; }
    default ProjectTreeNode resolveProjectTreePartialReorganization(ProjectTreeNode partialNode, ProjectTreeNode currentRoot) { return null; }
    default ProjectTreeNodeUpdate onProjectTreeNodeEvent(ProjectTreeEventContext context) { return null; }
    default Icon resolveProjectTreeNodeIcon(Path path, boolean directory, int iconSize) { return null; }
    default List<ProjectTreeIgnoreRule> resolveProjectTreeIgnoredFolders(Path projectPath) { return List.of(); }
    default boolean canExcludeProjectFolder(Path folderPath) { return true; }
    default boolean canIncludeProjectFolder(Path folderPath) { return true; }
    default void onProjectFolderIncluded(Path folderPath) {}
}
