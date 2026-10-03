package dtm.ide.api.extension.runconfig;

import dtm.ide.api.project.editor.BreakpointIde;
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
public class RunBreakpointData {

    private Path file;

    @Builder.Default
    private List<Integer> lines = new ArrayList<>();

    @Builder.Default
    private List<BreakpointIde> breakpoints = new ArrayList<>();
}
