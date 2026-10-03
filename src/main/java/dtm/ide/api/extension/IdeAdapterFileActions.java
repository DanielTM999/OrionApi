package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;
import dtm.ide.api.project.IdeProjectFileWatcher;
import dtm.ide.api.project.editor.FileTypeAliasInfo;

import java.nio.file.Path;

public interface IdeAdapterFileActions {

    @Delegated
    default IdeProjectFileWatcher getProjectFileWatcher() { return null; }

    @Delegated
    default void requestOpenFile(Path filePath) {
    }

    @Delegated
    default FileTypeAliasInfo resolveFileTypeAlias(Path filePath) {
        return FileTypeAliasInfo.notAliased(filePath);
    }

    @Delegated
    default Path resolveRealPath(Path filePath) {
        return resolveFileTypeAlias(filePath).realPath();
    }
}
