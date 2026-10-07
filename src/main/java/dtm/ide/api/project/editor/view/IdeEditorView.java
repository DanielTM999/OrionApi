package dtm.ide.api.project.editor.view;

import javax.swing.JComponent;

public interface IdeEditorView {

    JComponent getComponent();

    default void onActivated(IdeEditorViewPlacement placement) {
    }

    default void onDeactivated() {
    }

    default void onTextChanged(String text) {
    }

    default void onEditorScrolled(double ratio) {
    }

    default void dispose() {
    }
}
