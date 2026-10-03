package dtm.ide.api.extension.editor;

import dtm.stools.component.panels.editor.code.CodeEditor;
import lombok.NonNull;

@FunctionalInterface
public interface CodeEditorFactory<E extends CodeEditor> {
    @NonNull
    E create();
}
