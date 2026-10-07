package dtm.ide.api.project.editor.view;

public interface IdeEditorViewModesBuilder {

    IdeEditorViewModesBuilder add(IdeEditorViewMode mode);

    IdeEditorViewModesBuilder defaultMode(String modeId);
}
