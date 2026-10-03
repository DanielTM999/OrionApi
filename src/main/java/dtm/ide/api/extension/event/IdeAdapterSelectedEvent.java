package dtm.ide.api.extension.event;

import dtm.ide.api.context.ProjectContext;
import dtm.ide.api.extension.IdeAdapter;

public record IdeAdapterSelectedEvent(ProjectContext projectContext, IdeAdapter ideAdapter) {
}
