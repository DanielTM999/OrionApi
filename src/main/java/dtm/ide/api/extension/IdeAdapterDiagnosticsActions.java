package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;
import dtm.ide.api.project.diagnostics.IdeProblem;
import dtm.ide.api.project.diagnostics.ProblemsActionHandle;

import javax.swing.Icon;
import java.util.Collection;

public interface IdeAdapterDiagnosticsActions {

    @Delegated
    default void publishProblems(String ownerId, Collection<IdeProblem> problems) {}

    @Delegated
    default void clearProblems(String ownerId) {}

    @Delegated
    default void requestOpenProblemsPanel() {}

    @Delegated
    default ProblemsActionHandle registerProblemsAction(String ownerId, String label, Icon icon, Runnable action) {
        return null;
    }

    @Delegated
    default ProblemsActionHandle registerProblemsAction(String ownerId, String label, String tooltip, Icon icon, Runnable action) {
        return null;
    }

    @Delegated
    default void unregisterProblemsAction(String actionId) {}
}
