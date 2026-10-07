package dtm.ide.api.project.editor.view;

public enum IdeEditorViewPlacement {
    REPLACE,
    SPLIT_RIGHT,
    SPLIT_BOTTOM;

    public boolean isSplit() {
        return this == SPLIT_RIGHT || this == SPLIT_BOTTOM;
    }
}
