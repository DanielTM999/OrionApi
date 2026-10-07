package dtm.ide.api.project.editor.view;

import dtm.ide.api.extension.screen.ToolIconType;

import javax.swing.Icon;
import java.util.Objects;
import java.util.function.Function;

public final class IdeEditorViewMode {

    public static final String CODE_MODE_ID = "orion.code";

    private final String id;
    private final String text;
    private final String tooltip;
    private final Icon icon;
    private final ToolIconType iconType;
    private final IdeEditorViewPlacement placement;
    private final String viewKey;
    private final int order;
    private final Function<IdeEditorViewContext, IdeEditorView> viewFactory;

    private IdeEditorViewMode(Builder builder) {
        this.id = builder.id;
        this.text = builder.text;
        this.tooltip = builder.tooltip;
        this.icon = builder.icon;
        this.iconType = builder.iconType;
        this.placement = builder.placement;
        this.viewKey = builder.viewKey == null ? builder.id : builder.viewKey;
        this.order = builder.order;
        this.viewFactory = builder.viewFactory;
    }

    public static Builder builder(String id) {
        return new Builder(id);
    }

    public String id() {
        return id;
    }

    public String text() {
        return text;
    }

    public String tooltip() {
        return tooltip != null ? tooltip : text;
    }

    public Icon icon() {
        return icon;
    }

    public ToolIconType iconType() {
        return iconType;
    }

    public boolean hasIcon() {
        return icon != null || iconType != null;
    }

    public boolean hasText() {
        return text != null && !text.isBlank();
    }

    public IdeEditorViewPlacement placement() {
        return placement;
    }

    public String viewKey() {
        return viewKey;
    }

    public int order() {
        return order;
    }

    public IdeEditorView createView(IdeEditorViewContext context) {
        return viewFactory.apply(context);
    }

    @Override
    public String toString() {
        return "IdeEditorViewMode[" + id + ", " + placement + ", viewKey=" + viewKey + "]";
    }

    public static final class Builder {

        private final String id;
        private String text;
        private String tooltip;
        private Icon icon;
        private ToolIconType iconType;
        private IdeEditorViewPlacement placement = IdeEditorViewPlacement.REPLACE;
        private String viewKey;
        private int order;
        private Function<IdeEditorViewContext, IdeEditorView> viewFactory;

        private Builder(String id) {
            this.id = id;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder tooltip(String tooltip) {
            this.tooltip = tooltip;
            return this;
        }

        public Builder icon(Icon icon) {
            this.icon = icon;
            this.iconType = null;
            return this;
        }

        public Builder icon(ToolIconType iconType) {
            this.iconType = iconType;
            this.icon = null;
            return this;
        }

        public Builder placement(IdeEditorViewPlacement placement) {
            this.placement = Objects.requireNonNull(placement, "placement");
            return this;
        }

        public Builder viewKey(String viewKey) {
            this.viewKey = viewKey;
            return this;
        }

        public Builder order(int order) {
            this.order = order;
            return this;
        }

        public Builder view(Function<IdeEditorViewContext, IdeEditorView> viewFactory) {
            this.viewFactory = viewFactory;
            return this;
        }

        public IdeEditorViewMode build() {
            if (id == null || id.isBlank()) {
                throw new IllegalArgumentException("Editor view mode id must not be blank");
            }
            if (CODE_MODE_ID.equals(id)) {
                throw new IllegalArgumentException("Editor view mode id '" + CODE_MODE_ID + "' is reserved by the IDE");
            }
            if (icon == null && iconType == null && (text == null || text.isBlank())) {
                throw new IllegalArgumentException("Editor view mode '" + id + "' needs an icon, a text or both");
            }
            if (viewFactory == null) {
                throw new IllegalArgumentException("Editor view mode '" + id + "' needs a view factory");
            }
            if (viewKey != null && viewKey.isBlank()) {
                throw new IllegalArgumentException("Editor view mode '" + id + "' has a blank viewKey");
            }
            return new IdeEditorViewMode(this);
        }
    }
}
