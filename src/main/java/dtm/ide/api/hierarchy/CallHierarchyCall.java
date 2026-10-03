package dtm.ide.api.hierarchy;

import dtm.stools.component.panels.editor.code.api.Range;

import java.util.List;





public record CallHierarchyCall(
        CallHierarchyItem item,
        List<Range> fromRanges
) {

    public CallHierarchyCall(CallHierarchyItem item) {
        this(item, List.of());
    }
}
