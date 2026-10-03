package dtm.ide.api.hierarchy;

import dtm.stools.component.panels.editor.code.api.Range;
import dtm.stools.component.panels.editor.code.api.SymbolKind;

import java.nio.file.Path;
import java.util.Map;






public record CallHierarchyItem(
        String name,
        String detail,
        SymbolKind kind,
        Path filePath,
        Range range,
        Range selectionRange,
        Map<String, Object> data
) {

    public CallHierarchyItem(String name, String detail, SymbolKind kind, Path filePath, Range range, Range selectionRange) {
        this(name, detail, kind, filePath, range, selectionRange, Map.of());
    }
}
