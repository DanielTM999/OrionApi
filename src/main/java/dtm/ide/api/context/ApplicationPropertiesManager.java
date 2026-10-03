package dtm.ide.api.context;

import java.util.List;

public interface ApplicationPropertiesManager {

    ApplicationProperties getProperties(String area);

    List<Boolean> commitAllChanges();
}
