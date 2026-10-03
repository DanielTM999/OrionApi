package dtm.ide.api.project.editor;

import dtm.stools.component.panels.editor.code.rename.RenameOption;
import dtm.stools.component.panels.editor.code.rename.RenamePresenter;
import dtm.stools.component.panels.editor.code.rename.RenameStyle;

import java.util.Arrays;
import java.util.List;

public record IdeRenamePolicy(
        boolean declared,
        RenameStyle style,
        List<RenameOption> options,
        RenamePresenter customPresenter,
        Boolean popupEnabled
) {

    public IdeRenamePolicy {
        style = style == null ? RenameStyle.INLINE : style;
        options = options == null ? List.of() : List.copyOf(options.stream().filter(o -> o != null).toList());
    }

    public IdeRenamePolicy(boolean declared, RenameStyle style, List<RenameOption> options, RenamePresenter customPresenter) {
        this(declared, style, options, customPresenter, null);
    }

    public static IdeRenamePolicy undeclared() {
        return new IdeRenamePolicy(false, RenameStyle.INLINE, List.of(), null);
    }

    public static IdeRenamePolicy of(RenameStyle style) {
        return new IdeRenamePolicy(true, style, List.of(), null);
    }

    public static IdeRenamePolicy inline() {
        return of(RenameStyle.INLINE);
    }

    public static IdeRenamePolicy modernDialog() {
        return of(RenameStyle.MODERN_DIALOG);
    }

    public static IdeRenamePolicy simpleDialog() {
        return of(RenameStyle.SIMPLE_DIALOG);
    }

    public static IdeRenamePolicy custom(RenamePresenter presenter) {
        return new IdeRenamePolicy(presenter != null, RenameStyle.INLINE, List.of(), presenter);
    }

    public IdeRenamePolicy withOptions(RenameOption... newOptions) {
        return withOptions(newOptions == null ? List.of() : Arrays.asList(newOptions));
    }

    public IdeRenamePolicy withOptions(List<RenameOption> newOptions) {
        return new IdeRenamePolicy(declared, style, newOptions, customPresenter, popupEnabled);
    }

    public IdeRenamePolicy withPopupEnabled(boolean enabled) {
        return new IdeRenamePolicy(declared, style, options, customPresenter, enabled);
    }

    public IdeRenamePolicy withoutPopup() {
        return withPopupEnabled(false);
    }

    public RenamePresenter resolvePresenter() {
        if (!declared) return null;
        return customPresenter != null ? customPresenter : style.createPresenter();
    }
}
