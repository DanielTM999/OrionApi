package dtm.ide.api.project.diagnostics;

import javax.swing.Icon;

public interface ProblemsActionHandle {

    String getId();

    default ProblemsActionHandle setEnabled(boolean enabled) {
        return this;
    }

    default ProblemsActionHandle setLabel(String label) {
        return this;
    }

    default ProblemsActionHandle setTooltip(String tooltip) {
        return this;
    }

    default ProblemsActionHandle setIcon(Icon icon) {
        return this;
    }

    default void unregister() {
    }
}
