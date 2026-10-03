package dtm.ide.api.project.tree;

import lombok.Getter;

import javax.swing.Icon;
import java.nio.file.Path;

public class ProjectTreeNodeUpdate {

    @Getter
    private Path path;
    @Getter
    private String label;
    @Getter
    private Icon icon;
    private boolean applyChanges;

    public ProjectTreeNodeUpdate() {
    }

    public ProjectTreeNodeUpdate(boolean applyChanges) {
        this.applyChanges = applyChanges;
    }

    public static ProjectTreeNodeUpdate apply() {
        return new ProjectTreeNodeUpdate(true);
    }

    public static ProjectTreeNodeUpdate skip() {
        return new ProjectTreeNodeUpdate(false);
    }

    public ProjectTreeNodeUpdate path(Path path) {
        this.path = path != null && !path.toString().isEmpty()
                ? path.toAbsolutePath().normalize()
                : null;
        return this;
    }

    public ProjectTreeNodeUpdate label(String label) {
        this.label = label;
        return this;
    }

    public ProjectTreeNodeUpdate icon(Icon icon) {
        this.icon = icon;
        return this;
    }

    public ProjectTreeNodeUpdate applyChanges(boolean applyChanges) {
        this.applyChanges = applyChanges;
        return this;
    }

    public boolean hasLabel() {
        return label != null && !label.isEmpty();
    }

    public boolean shouldApplyChanges() {
        return applyChanges;
    }
}
