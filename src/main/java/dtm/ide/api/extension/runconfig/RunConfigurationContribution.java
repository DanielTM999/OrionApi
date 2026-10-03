package dtm.ide.api.extension.runconfig;

import javax.swing.Icon;

public interface RunConfigurationContribution {

    String getType();

    String getDisplayName();

    default Icon getIcon() {
        return null;
    }

    RunConfigurationForm createForm();
}
