package dtm.ide.api.extension.menu;

import dtm.stools.component.menu.bar.tree.MenuNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuContribution {

    private String parentMenuId;

    private Integer index;

    @Singular
    private List<MenuNode> items;
}
