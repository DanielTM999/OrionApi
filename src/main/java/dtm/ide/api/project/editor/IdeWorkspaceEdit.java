package dtm.ide.api.project.editor;

import dtm.stools.component.panels.editor.code.api.TextEdit;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public record IdeWorkspaceEdit(List<Operation> operations) {

    public sealed interface Operation permits TextEdits, RenameFile {
    }

    public record TextEdits(Path file, List<TextEdit> edits) implements Operation {

        public TextEdits {
            edits = edits == null ? List.of() : List.copyOf(edits.stream().filter(e -> e != null).toList());
        }
    }

    public record RenameFile(Path oldPath, Path newPath) implements Operation {
    }

    public IdeWorkspaceEdit {
        operations = operations == null ? List.of() : List.copyOf(operations.stream().filter(o -> o != null).toList());
    }

    public static IdeWorkspaceEdit empty() {
        return new IdeWorkspaceEdit(List.of());
    }

    public boolean isEmpty() {
        for (Operation operation : operations) {
            if (operation instanceof RenameFile) return false;
            if (operation instanceof TextEdits textEdits && !textEdits.edits().isEmpty()) return false;
        }
        return true;
    }

    public List<TextEdit> editsFor(Path file) {
        if (file == null) return List.of();
        Path normalized = file.toAbsolutePath().normalize();
        List<TextEdit> result = new ArrayList<>();
        for (Operation operation : operations) {
            if (operation instanceof TextEdits textEdits && textEdits.file() != null
                    && normalized.equals(textEdits.file().toAbsolutePath().normalize())) {
                result.addAll(textEdits.edits());
            }
        }
        return result;
    }
}
