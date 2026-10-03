package dtm.ide.api.extension;

import dtm.ide.api.project.editor.IdeWorkspaceEdit;
import dtm.ide.api.project.tree.PathRenameDecision;
import dtm.ide.api.project.tree.PathTransferDecision;
import dtm.ide.api.project.tree.PathTransferRequest;
import dtm.ide.api.project.tree.TreeOperationType;

import java.nio.file.Path;
import java.util.List;

public interface IdeAdapterFileCallbacks {

    default boolean canOpenFile(Path filePath) { return true; }
    default boolean canDeletePaths(List<Path> paths) { return true; }
    default boolean canRenamePath(Path path) { return true; }
    default boolean canMovePath(Path source, Path targetDirectory) { return true; }
    default PathRenameDecision beforePathRename(Path path) { return PathRenameDecision.useDefault(); }
    default void onPathDeleted(Path oldPath) {}
    default void onPathRenamed(Path oldPath, Path newPath) {}
    default PathTransferDecision beforePathTransfer(PathTransferRequest request) { return PathTransferDecision.proceed(); }
    default IdeWorkspaceEdit afterPathTransfer(PathTransferRequest request) { return IdeWorkspaceEdit.empty(); }
    default boolean canUndo(TreeOperationType operation, Path path) { return true; }
    default void onUndo(TreeOperationType operation, Path path) {}
    default boolean supportsCustomFileOpen(Path filePath) { return false; }
    default String readCustomFileContent(Path filePath) { return null; }
    default boolean canSaveFile(Path filePath) { return true; }
    default String onBeforeFileSave(Path filePath, String content) { return content; }
    default void onAfterFileSave(Path filePath, String content) {}
}
