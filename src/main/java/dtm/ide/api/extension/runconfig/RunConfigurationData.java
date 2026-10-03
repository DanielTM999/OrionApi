package dtm.ide.api.extension.runconfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RunConfigurationData {

    private String id;
    private String type;
    private String title;
    private String iconResource;

    private Class<?> iconResourceOwner;

    @Builder.Default
    private boolean tintIcon = true;

    @Builder.Default
    private Map<String, Object> properties = new LinkedHashMap<>();
}
