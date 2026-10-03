package dtm.ide.api.project.editor;

import dtm.stools.component.panels.editor.code.diagnostics.Diagnostic;
import lombok.Getter;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Getter
public class IdeDiagnosticsContext {

    private final String text;
    private final Path filePath;
    private final String previousText;
    private final int changeOffset;
    private final int removedLength;
    private final String insertedText;
    private final List<Diagnostic> previousDiagnostics;

    public IdeDiagnosticsContext(String text, Path filePath) {
        this(text, filePath, null, 0, 0, null, null);
    }

    public IdeDiagnosticsContext(
            String text,
            Path filePath,
            String previousText,
            int changeOffset,
            int removedLength,
            String insertedText,
            List<Diagnostic> previousDiagnostics
    ) {
        this.text = text;
        this.filePath = filePath;
        this.previousText = previousText;
        this.changeOffset = changeOffset;
        this.removedLength = removedLength;
        this.insertedText = insertedText;
        this.previousDiagnostics = previousDiagnostics == null ? Collections.emptyList() : List.copyOf(previousDiagnostics);
    }
}
