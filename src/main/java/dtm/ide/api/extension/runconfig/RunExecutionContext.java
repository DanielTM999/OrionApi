package dtm.ide.api.extension.runconfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RunExecutionContext {

    private Path projectPath;

    @Builder.Default
    private List<RunBreakpointData> breakpoints = new ArrayList<>();

    private boolean debug;
}
