package dtm.ide.api.project.editor;

import dtm.stools.component.panels.editor.code.api.Range;

import java.util.Set;








public record SemanticToken(Range range, String type, Set<String> modifiers) {

    public SemanticToken(Range range, String type) {
        this(range, type, Set.of());
    }

    public boolean hasModifier(String modifier) {
        return modifiers != null && modifier != null && modifiers.contains(modifier);
    }
}
