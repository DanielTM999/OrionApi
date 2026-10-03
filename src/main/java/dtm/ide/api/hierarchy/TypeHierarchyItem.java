package dtm.ide.api.hierarchy;

import dtm.stools.component.panels.editor.code.api.Range;

import java.nio.file.Path;

public record TypeHierarchyItem(String name, String detail, int kind, Path file, Range range, Range selectionRange, Object data) {
}
