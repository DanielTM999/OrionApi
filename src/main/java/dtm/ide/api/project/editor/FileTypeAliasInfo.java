package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record FileTypeAliasInfo(boolean aliased, Path realPath) {

    public static FileTypeAliasInfo notAliased(Path path) {
        return new FileTypeAliasInfo(false, path);
    }

    public static FileTypeAliasInfo aliasOf(Path realPath) {
        return new FileTypeAliasInfo(true, realPath);
    }
}
