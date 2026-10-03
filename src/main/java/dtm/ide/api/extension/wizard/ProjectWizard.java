package dtm.ide.api.extension.wizard;

import javax.swing.Icon;
import javax.swing.JPanel;

public interface ProjectWizard {

    String getId();

    String getName();

    String getLanguage();

    Icon getIcon();

    JPanel getView(ProjectWizardCallback callback);
}
