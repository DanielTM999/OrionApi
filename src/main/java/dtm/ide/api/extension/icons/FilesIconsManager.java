package dtm.ide.api.extension.icons;

import dtm.ide.api.extension.PluginContext;

import javax.swing.Icon;

public abstract class FilesIconsManager extends PluginContext {

    public abstract FolderIcons iconFolder(FileNodeContext context);

    public abstract Icon icon(FileNodeContext context);
}
