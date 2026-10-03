package dtm.ide.api.extension.icons;

public record FileNodeContext(
        String path,
        String name,
        String extension,
        boolean directory,
        boolean virtual
) {
}
