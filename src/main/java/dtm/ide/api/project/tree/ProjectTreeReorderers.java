package dtm.ide.api.project.tree;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public final class ProjectTreeReorderers {

    private ProjectTreeReorderers() {
    }

    public static ProjectTreeReorderer directoriesFirstByName() {
        return (context, children) -> children.stream()
                .sorted(directoriesFirstComparator())
                .toList();
    }

    public static Comparator<Path> directoriesFirstComparator() {
        return Comparator
                .comparing((Path path) -> !Files.isDirectory(path))
                .thenComparing(ProjectTreeReorderers::fileName, String.CASE_INSENSITIVE_ORDER);
    }

    private static String fileName(Path path) {
        Path fileName = path.getFileName();
        return fileName == null ? path.toString() : fileName.toString();
    }
}
