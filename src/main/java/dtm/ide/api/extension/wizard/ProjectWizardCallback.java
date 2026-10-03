package dtm.ide.api.extension.wizard;

import java.nio.file.Path;

public interface ProjectWizardCallback {

    void notifyProjectCreated(Path projectPath);

    void cancel();
}
