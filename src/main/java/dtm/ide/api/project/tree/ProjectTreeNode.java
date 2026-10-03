package dtm.ide.api.project.tree;

import lombok.Getter;

import javax.swing.Icon;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ProjectTreeNode {

    @Getter
    private final Path path;
    @Getter
    private String label;
    @Getter
    private Icon icon;
    private final boolean virtual;
    private List<ProjectTreeNode> children;

    public ProjectTreeNode(Path path) {
        this(path, null, false);
    }

    public ProjectTreeNode(Path path, boolean virtual) {
        this(path, null, virtual);
    }

    public ProjectTreeNode(Path path, String label) {
        this(path, label, false);
    }

    public ProjectTreeNode(Path path, String label, boolean virtual) {
        this.path = Objects.requireNonNull(path, "path").toAbsolutePath().normalize();
        this.label = label;
        this.virtual = virtual;
    }

    public static ProjectTreeNode of(Path path) {
        return new ProjectTreeNode(path);
    }

    public static ProjectTreeNode of(Path path, boolean virtual) {
        return new ProjectTreeNode(path, virtual);
    }

    public static ProjectTreeNode of(Path path, String label) {
        return new ProjectTreeNode(path, label);
    }

    public static ProjectTreeNode of(Path path, String label, boolean virtual) {
        return new ProjectTreeNode(path, label, virtual);
    }

    public boolean isVirtual() {
        return virtual;
    }

    public ProjectTreeNode label(String label) {
        this.label = label;
        return this;
    }

    public ProjectTreeNode icon(Icon icon) {
        this.icon = icon;
        return this;
    }

    public ProjectTreeNode children(List<ProjectTreeNode> children) {
        this.children = children != null ? new ArrayList<>(children) : null;
        return this;
    }

    public ProjectTreeNode addChild(ProjectTreeNode child) {
        Objects.requireNonNull(child, "child");

        if (children == null) {
            children = new ArrayList<>();
        }

        children.add(child);
        return this;
    }

    public boolean hasCustomChildren() {
        return children != null;
    }

    public List<ProjectTreeNode> getChildren() {
        return children != null ? Collections.unmodifiableList(children) : List.of();
    }

    public boolean removeIf(Predicate<ProjectTreeNode> predicate) {
        return removeIf(predicate, true);
    }

    public boolean removeIf(Predicate<ProjectTreeNode> predicate, boolean deep) {
        Objects.requireNonNull(predicate, "predicate");

        if (children == null || children.isEmpty()) {
            return false;
        }

        boolean removed = false;

        for (int i = children.size() - 1; i >= 0; i--) {
            ProjectTreeNode child = children.get(i);

            if (child == null || predicate.test(child)) {
                children.remove(i);
                removed = true;
                continue;
            }

            if (deep) {
                removed |= child.removeIf(predicate, true);
            }
        }

        if (children.isEmpty()) {
            children = null;
        }

        return removed;
    }


    public int updateIf(Predicate<ProjectTreeNode> predicate, Consumer<ProjectTreeNode> updater) {
        return updateIf(predicate, updater, true);
    }

    public int updateIf(Predicate<ProjectTreeNode> predicate, Consumer<ProjectTreeNode> updater, boolean deep) {
        Objects.requireNonNull(predicate, "predicate");
        Objects.requireNonNull(updater, "updater");

        int updated = 0;

        if (predicate.test(this)) {
            updater.accept(this);
            updated++;
        }

        if (!deep || children == null || children.isEmpty()) {
            return updated;
        }

        for (ProjectTreeNode child : children) {
            if (child != null) {
                updated += child.updateIf(predicate, updater, true);
            }
        }

        return updated;
    }


}
