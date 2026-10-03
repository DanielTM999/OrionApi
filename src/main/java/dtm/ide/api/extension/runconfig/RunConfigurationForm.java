package dtm.ide.api.extension.runconfig;

import javax.swing.JComponent;
import java.io.IOException;

public interface RunConfigurationForm {

    JComponent getComponent();

    RunConfigurationData getData();

    void setData(RunConfigurationData data);

    default void applyProjectChanges() throws IOException {
    }
}
