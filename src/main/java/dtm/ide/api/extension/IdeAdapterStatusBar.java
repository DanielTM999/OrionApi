package dtm.ide.api.extension;

import dtm.ide.api.annotations.Delegated;

public interface IdeAdapterStatusBar {

    @Delegated
    default void setStatusBarText(String message) {}

    @Delegated
    default void clearStatusBarText() {}

    @Delegated
    default void showProgress(String taskId, String taskName) {}

    @Delegated
    default void showProgress(String taskId, String taskName, boolean cancelable, Runnable onCancel) {}

    @Delegated
    default void updateProgress(String taskId, String taskName, int percent) {}

    @Delegated
    default void updateProgress(String taskId, String taskName, int percent, boolean cancelable, Runnable onCancel) {}

    @Delegated
    default void hideProgress(String taskId) {}

    @Delegated
    default void clearAllProgress() {}

}
