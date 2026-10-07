package dtm.ide.api.project.editor.view;

import dtm.ide.api.project.editor.IdeEditorContext;

import java.nio.file.Path;

public interface IdeEditorViewContext {

    Path filePath();

    IdeEditorContext editor();

    String getText();

    String activeModeId();

    void switchTo(String modeId);

    default void switchToCode() {
        switchTo(IdeEditorViewMode.CODE_MODE_ID);
    }

    void scrollEditorToRatio(double ratio);
}
