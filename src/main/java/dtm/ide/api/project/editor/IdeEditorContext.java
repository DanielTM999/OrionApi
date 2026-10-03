package dtm.ide.api.project.editor;

import dtm.stools.component.panels.editor.code.api.CommandHandler;
import dtm.stools.component.panels.editor.code.api.TextEdit;
import dtm.stools.component.panels.editor.code.ghost.GhostTextActivationMode;
import dtm.stools.component.panels.editor.code.gutter.layer.GutterLayer;
import dtm.stools.component.panels.editor.code.provider.CodeEditorProvider;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

public interface IdeEditorContext {

    Path filePath();

    String getText();

    default long getDocumentVersion() {
        return -1;
    }

    default boolean addProvider(CodeEditorProvider provider) {
        return false;
    }

    default void setAutoCompleteOnTyping(boolean enabled) {}

    default boolean isAutoCompleteVisible() {
        return false;
    }

    default void hideAutoCompletePopup() {
    }

    default void setGhostTextEnabled(boolean enabled) {
    }

    default void setGhostTextActivationMode(GhostTextActivationMode mode) {
    }

    default void setGhostTextCaretIdleDelay(int delayMillis) {
    }

    default boolean clearGhostText() {
        return false;
    }

    default boolean setCommandHandler(CommandHandler handler) {
        return false;
    }

    default boolean registerShortcut(String actionId, String keyStroke, Runnable action) {
        return registerShortcut(actionId, keyStroke, EditorShortcutScope.EDITOR, () -> {
            action.run();
            return true;
        });
    }

    default boolean registerShortcut(String actionId, String keyStroke,
                                     EditorShortcutScope scope, EditorShortcut action) {
        return false;
    }

    default boolean unregisterShortcut(String actionId) {
        return false;
    }

    default Rectangle getEditorBoundsOnScreen() {
        return null;
    }

    default Object addEditorOverlay(JComponent overlay, Rectangle screenBounds) {
        return null;
    }

    default void removeEditorOverlay(Object handle) {
    }

    default Object openEditorDialog(String title, JComponent content, boolean modal,
                                    Runnable onClosed) {
        return null;
    }

    default Object openEditorPopup(JComponent content, Point screenLocation,
                                   boolean closeOnFocusLoss, Runnable onClosed) {
        return null;
    }

    default void moveEditorWindow(Object handle, Point screenLocation) {
    }

    default void closeEditorWindow(Object handle) {
    }

    boolean addGutterLayer(GutterLayer gutterLayer);

    default boolean removeGutterLayer(GutterLayer gutterLayer) {
        return false;
    }

    default void repaintGutter() {
    }

    <T extends GutterLayer> T getGutterLayer(Class<T> gutterLayerClass);

    void setText(String text);

    default boolean applyEdits(List<TextEdit> edits) {
        return false;
    }

    boolean isReadOnly();

    void setReadOnly(boolean readOnly);

    int getTabSize();

    void setTabSize(int tabSize);

    boolean isUseSpacesForTab();

    void setUseSpacesForTab(boolean useSpacesForTab);

    int getCaretLine();

    int getCaretCol();

    int getCaretOffset();

    default int getSelectionStart() {
        return getSelectionStartOffset();
    }

    default int getSelectionEnd() {
        return getSelectionEndOffset();
    }

    default void select(int start, int end) {
        String text = getText();
        if (start < 0 || end < start || end > text.length()) {
            throw new IndexOutOfBoundsException("Invalid selection [" + start + ", " + end + ")");
        }
        int startLine = 0;
        int startColumn = 0;
        int endLine = 0;
        int endColumn = 0;
        for (int offset = 0; offset < end; offset++) {
            if (text.charAt(offset) == '\n') {
                endLine++;
                endColumn = 0;
            } else {
                endColumn++;
            }
            if (offset + 1 == start) {
                startLine = endLine;
                startColumn = endColumn;
            }
        }
        setSelection(startLine, startColumn, endLine, endColumn);
    }

    void setCaretPosition(int line, int col);

    void setLineColor(int line, Color color);

    void setLineColor(int line, Color background, Color foreground);

    default void setPriorityLineColor(int line, Color color) {
        setPriorityLineColor(line, color, null);
    }

    default void setPriorityLineColor(int line, Color background, Color foreground) {
        setLineColor(line, background, foreground);
    }

    void clearLineColors();

    void removeLineColor(int line);

    boolean isSelectionActive();

    int getSelectionStartOffset();

    int getSelectionEndOffset();

    String getSelectedTextOrEmpty();

    void setSelection(int startLine, int startCol, int endLine, int endCol);

    void enableBreakpoint(boolean enabled);

    void addBreakpoint(int line);

    void removeBreakpoint(int line);

    void toggleBreakpoint(int line);

    void clearBreakpoints();

    Set<Integer> getBreakpointLines();

    Set<BreakpointIde> getBreakpoints();

    void enableBookmark(boolean enabled);

    void addBookmark(int line);

    void removeBookmark(int line);

    void toggleBookmark(int line);

    void clearBookmarks();

    SortedSet<Integer> getBookmarks();

    void setFoldingEnabled(boolean enabled);

    void foldAll();

    void unfoldAll();

    void setSearchEnabled(boolean enabled);

    void hideSearchPanel();

    void setSyntaxHighlightEnabled(boolean enabled);

    void applySyntaxHighlight();

    void setDiagnosticsAutoRunEnabled(boolean enabled);

    void refreshDiagnostics();

    void setCodeLensesEnabled(boolean enabled);

    void refreshCodeLenses();

    void refreshInlayHints();

    void formatDocument();

    void formatSelection();

    void setKeyboardBreakpointEnabled(boolean enabled);
}
