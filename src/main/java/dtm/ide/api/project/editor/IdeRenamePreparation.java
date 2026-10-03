package dtm.ide.api.project.editor;

import dtm.stools.component.panels.editor.code.api.Range;
import dtm.stools.component.panels.editor.code.api.SymbolKind;

import java.util.List;

public record IdeRenamePreparation(
        Range range,
        String placeholder,
        List<Range> occurrences,
        String rejection,
        SymbolKind kind
) {

    public IdeRenamePreparation {
        occurrences = occurrences == null ? List.of() : List.copyOf(occurrences.stream().filter(r -> r != null).toList());
    }

    public IdeRenamePreparation(Range range, String placeholder, List<Range> occurrences, String rejection) {
        this(range, placeholder, occurrences, rejection, null);
    }

    public static IdeRenamePreparation of(Range range, String placeholder) {
        return new IdeRenamePreparation(range, placeholder, List.of(), null, null);
    }

    public static IdeRenamePreparation rejected(String message) {
        return new IdeRenamePreparation(null, null, List.of(), message == null ? "" : message, null);
    }

    public IdeRenamePreparation withOccurrences(List<Range> newOccurrences) {
        return new IdeRenamePreparation(range, placeholder, newOccurrences, rejection, kind);
    }

    public IdeRenamePreparation withKind(SymbolKind newKind) {
        return new IdeRenamePreparation(range, placeholder, occurrences, rejection, newKind);
    }

    public boolean isRejected() {
        return rejection != null;
    }
}
