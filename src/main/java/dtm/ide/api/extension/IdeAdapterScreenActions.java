package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;
import dtm.ide.api.extension.event.KeyboardEvent;
import dtm.ide.api.extension.screen.ManagedCenterTabHandle;
import dtm.ide.api.extension.screen.ManagedCenterTabRequest;
import dtm.ide.api.extension.screen.ToolIconType;
import dtm.stools.component.panels.dock.DockRegion;
import dtm.stools.component.popup.ModernComponentDialog;
import dtm.stools.component.popup.ModernDialog;
import dtm.stools.component.popup.ModernInputDialog;
import lombok.NonNull;

import javax.swing.Icon;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.nio.file.Path;
import java.util.Optional;

public interface IdeAdapterScreenActions {

    String TOOL_PANEL_OWN_CLOSE_BUTTON_PROPERTY = "orion.toolPanel.ownCloseButton";

    @Delegated
    default String registerToolPanel(DockRegion region, String title, ToolIconType iconType, JComponent panel) {
        return null;
    }

    @Delegated
    default String registerToolPanel(DockRegion region, String title, Icon icon, JComponent panel) {
        return null;
    }

    @Delegated
    default String registerToolPanel(DockRegion region, String title, ToolIconType iconType, JComponent panel, Dimension preferredSize) {
        return null;
    }

    @Delegated
    default String registerToolPanel(DockRegion region, String title, Icon icon, JComponent panel, Dimension preferredSize) {
        return null;
    }

    @Delegated
    default void unregisterToolPanel(String panelId) {}

    @Delegated
    default String registerToolAction(DockRegion region, String title, ToolIconType iconType, Runnable action) {
        return null;
    }

    @Delegated
    default String registerToolAction(DockRegion region, String title, Icon icon, Runnable action) {
        return null;
    }

    @Delegated
    default void requestOpenToolPanel(String key) {}

    @Delegated
    default void setToolPanelPreferredSize(String key, Dimension preferredSize) {}

    @Delegated
    default String openCenterTab(String key, String title, JComponent panel) {
        return openCenterTab(key, title, panel, true);
    }

    @Delegated
    default String openCenterTab(String key, String title, JComponent panel, boolean closable) {
        return null;
    }

    @Delegated
    default String openCenterTab(String key, String title, JComponent panel, Icon icon) {
        return openCenterTab(key, title, panel, true, icon);
    }

    @Delegated
    default String openCenterTab(String key, String title, JComponent panel, boolean closable, Icon icon) {
        return null;
    }

    @Delegated
    default ManagedCenterTabHandle openManagedCenterTab(ManagedCenterTabRequest request) {
        return null;
    }

    @Delegated
    default boolean closeCenterTab(String key) {
        return false;
    }

    @Delegated
    default String openWebBrowser(String url) {
        return null;
    }

    @Delegated
    default String openWebBrowser(Path path) {
        return null;
    }

    @Delegated
    default void switchToCenterTab(String key) {}

    @Delegated
    default void requestSetRunButtonEnabled(boolean enabled) {}

    @Delegated
    default void requestSetRunButtonLoading(boolean loading) {}

    @Delegated
    default void requestSetRunButtonRunning(boolean running) {}

    @Delegated
    default void requestSetDebugButtonEnabled(boolean enabled) {}

    @Delegated
    default void requestSetHotReloadButtonEnabled(boolean enabled) {}

    @Delegated
    default void requestSetHotReloadButtonVisible(boolean visible) {}

    @Delegated
    default void requestSetCoverageButtonEnabled(boolean enabled) {}

    @Delegated
    default void requestSetCoverageButtonVisible(boolean visible) {}

    @Delegated
    default void createNotification(NotificationContext notificationContext){}

    @Delegated
    default void onKeyboardEvent(KeyboardEvent keyboardEvent){}

    @Delegated
    default Optional<Path> requestPathOnCurrentOpenTab(){return Optional.empty();}

    @Delegated
    default <T> ModernComponentDialog.ModernComponentDialogBuilder<T> createModernComponentDialogBuilder(){
        return null;
    }

    @Delegated
    default <T> ModernComponentDialog.ModernComponentDialogBuilder<T> createModernComponentDialogBuilder(Class<T> clazz){
        return null;
    }

    @Delegated
    default ModernDialog.ModernDialogBuilder createModernDialogBuilder(){
        return null;
    }

    @Delegated
    default ModernInputDialog.ModernInputDialogBuilder createModernInputDialogBuilder(){
        return null;
    }

    @Delegated
    default void showPopup(@NonNull PlatformPopupBuilder popup) {}
}
