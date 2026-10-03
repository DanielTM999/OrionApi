package dtm.ide.api.project.tree;

import dtm.ide.api.project.editor.IdeWorkspaceEdit;

public sealed interface PathRenameDecision {

    static PathRenameDecision useDefault() {
        return UseDefault.INSTANCE;
    }

    static PathRenameDecision cancel() {
        return Cancel.INSTANCE;
    }

    static PathRenameDecision apply(String label, IdeWorkspaceEdit edit) {
        if (edit == null || edit.isEmpty()) {
            return cancel();
        }
        return new Apply(label, edit);
    }

    default boolean usesDefault() {
        return this instanceof UseDefault;
    }

    final class UseDefault implements PathRenameDecision {
        private static final UseDefault INSTANCE = new UseDefault();

        private UseDefault() {
        }
    }

    final class Cancel implements PathRenameDecision {
        private static final Cancel INSTANCE = new Cancel();

        private Cancel() {
        }
    }

    record Apply(String label, IdeWorkspaceEdit edit) implements PathRenameDecision {
    }
}
