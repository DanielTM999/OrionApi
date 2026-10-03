package dtm.ide.api.settings;

import java.util.List;
import java.util.Locale;

public final class OrionSettings {

    public static final String APP_AREA = "app";
    public static final String EDITOR_SETTINGS = "editor:settings";
    public static final String EDITOR_COLOR_THEME = "settings:editor:colorTheme";
    public static final String SETTINGS_SCHEMA_VERSION = "settings:schemaVersion";
    public static final String APP_FONT_FAMILY = "settings:appearance:font:family";
    public static final String APP_FONT_SIZE = "settings:appearance:font:size";
    public static final String APP_LANGUAGE = "settings:appearance:language";
    public static final String APPEARANCE_THEME = "settings:appearance:theme";
    public static final String APPEARANCE_SEPARATOR_STYLE = "settings:appearance:separatorStyle";
    public static final String FILES_ICONS_PROVIDER_ID = "settings:appearance:filesIconsProvider";
    public static final String EDITOR_SYNTAX_HIGHLIGHT_DEBOUNCE_MS_KEY = "settings:appearance:editor:syntaxHighlightDebounceMs";
    public static final String ADAPTER_SELECTION_ALWAYS_ASK = "settings:adapter:alwaysAsk";
    public static final String WEB_BROWSER_HOME_HTML_PATH = "settings:webBrowser:homeHtmlPath";
    public static final String WEB_BROWSER_SEARCH_ENGINE = "settings:webBrowser:searchEngine";
    public static final String WEB_BROWSER_SEARCH_CUSTOM_URL = "settings:webBrowser:searchCustomUrl";
    public static final String WEB_BROWSER_LINK_OPEN_TARGET = "settings:webBrowser:linkOpenTarget";
    public static final String WEB_BROWSER_RENDERING_MODE = "settings:webBrowser:renderingMode";
    public static final String WEB_BROWSER_OFFER_SAVE_PASSWORDS = "settings:webBrowser:offerToSavePasswords";
    public static final String PROJECT_TREE_POSITION = "settings:projectTree:position";
    public static final String PROJECT_TREE_LEVEL_INDENT_KEY = "settings:projectTree:levelIndent";
    public static final String PROJECT_TREE_AUTO_EXPAND_SINGLE_FOLDERS = "settings:projectTree:autoExpandSingleFolders";
    public static final String PROCESS_MONITOR_SETTINGS = "settings:processMonitor";
    public static final String TOOL_PANEL_LAYOUT = "settings:toolPanels:layout";
    public static final String CLOSED_TAB_RESTORE_LIMIT = "settings:tabs:closedRestoreLimit";
    public static final String CLOSED_TAB_RESTORE_RETENTION_MINUTES = "settings:tabs:closedRestoreRetentionMinutes";
    public static final String INSTRUMENTATION_ENABLED_KEY = "instrumentation:enabled";
    public static final String OPENED_PROJECTS = "session:openedProjects";
    public static final String OPENED_RECENTS_PROJECTS = "session:openedRecentsProjects";
    public static final String PROJECT_ADAPTERS = "session:projectAdapters";
    public static final String WORKSPACE_TRUST_DECISIONS = "workspaceTrust:decisions";
    public static final String WORKSPACE_TRUST_DEFAULT_DECISION = "workspaceTrust:defaultDecision";
    public static final String WORKSPACE_TRUSTED_RUNTIME_PROPERTY = "workspace:trusted";
    public static final String IDE_LOG_BUFFER_LIMIT = "diagnostics:log:bufferLimit";
    public static final String PROCESS_OUTPUT_ENCODING_KEY = "settings:system:processOutputEncoding";
    public static final String KEYMAP_ACTIVE_PROFILE = "keymap:activeProfile";
    public static final String KEYMAP_PROFILES = "keymap:profiles";

    public static final SettingKey<Integer> SCHEMA_VERSION = SettingKey.<Integer>builder()
            .id(SETTINGS_SCHEMA_VERSION)
            .type(Integer.class)
            .defaultValue(1)
            .validator(value -> value != null && value >= 1)
            .label("Settings schema version")
            .category("system")
            .build();

    public static final SettingKey<String> LANGUAGE = SettingKey.<String>builder()
            .id(APP_LANGUAGE)
            .type(String.class)
            .defaultValue(Locale.getDefault().toLanguageTag())
            .validator(value -> value != null && !value.isBlank())
            .label("Language")
            .category("appearance")
            .build();

    public static final SettingKey<String> FONT_FAMILY = SettingKey.<String>builder()
            .id(APP_FONT_FAMILY)
            .type(String.class)
            .defaultValue("Inter")
            .validator(value -> value != null && !value.isBlank())
            .label("Interface font")
            .category("appearance")
            .build();

    public static final SettingKey<Integer> FONT_SIZE = SettingKey.<Integer>builder()
            .id(APP_FONT_SIZE)
            .type(Integer.class)
            .defaultValue(13)
            .validator(value -> value != null && value >= 8 && value <= 48)
            .label("Interface font size")
            .category("appearance")
            .build();

    public static final SettingKey<String> THEME = SettingKey.<String>builder()
            .id(APPEARANCE_THEME)
            .type(String.class)
            .defaultValue("github_dark")
            .validator(value -> value != null && !value.isBlank())
            .label("Theme")
            .category("appearance")
            .build();

    public static final SettingKey<String> SEPARATOR_STYLE = SettingKey.<String>builder()
            .id(APPEARANCE_SEPARATOR_STYLE)
            .type(String.class)
            .defaultValue("thin")
            .validator(value -> value != null && switch (value) {
                case "original", "thin", "thin_dark", "thin_light", "none" -> true;
                default -> false;
            })
            .label("Workbench separators")
            .category("appearance")
            .build();

    public static final SettingKey<String> FILES_ICONS_PROVIDER = SettingKey.<String>builder()
            .id(FILES_ICONS_PROVIDER_ID)
            .type(String.class)
            .defaultValue("")
            .validator(value -> value != null)
            .label("Files icons provider")
            .category("appearance")
            .build();

    public static final SettingKey<String> EDITOR_THEME = SettingKey.<String>builder()
            .id(EDITOR_COLOR_THEME)
            .type(String.class)
            .defaultValue("")
            .validator(value -> value != null)
            .label("Editor color theme")
            .category("editor")
            .build();

    public static final SettingKey<Boolean> ADAPTER_ALWAYS_ASK = SettingKey.<Boolean>builder()
            .id(ADAPTER_SELECTION_ALWAYS_ASK)
            .type(Boolean.class)
            .defaultValue(Boolean.TRUE)
            .validator(value -> value != null)
            .label("Adapter selection")
            .category("system")
            .build();

    public static final SettingKey<Boolean> PROJECT_TREE_AUTO_EXPAND_SINGLE_FOLDERS_ENABLED = SettingKey.<Boolean>builder()
            .id(PROJECT_TREE_AUTO_EXPAND_SINGLE_FOLDERS)
            .type(Boolean.class)
            .defaultValue(Boolean.TRUE)
            .validator(value -> value != null)
            .label("Auto expand single folders")
            .category("appearance")
            .build();

    public static final SettingKey<Integer> EDITOR_SYNTAX_HIGHLIGHT_DEBOUNCE_MS =
            SettingKey.<Integer>builder()
                    .id(EDITOR_SYNTAX_HIGHLIGHT_DEBOUNCE_MS_KEY)
                    .type(Integer.class)
                    .defaultValue(75)
                    .validator(value -> value != null && value >= 0 && value <= 2000)
                    .label("Syntax highlight delay")
                    .category("appearance")
                    .build();

    public static final SettingKey<Integer> PROJECT_TREE_LEVEL_INDENT = SettingKey.<Integer>builder()
            .id(PROJECT_TREE_LEVEL_INDENT_KEY)
            .type(Integer.class)
            .defaultValue(-1)
            .validator(value -> value != null && value >= -1 && value <= 64)
            .label("Project tree level indent")
            .category("appearance")
            .build();

    public static final SettingKey<String> BROWSER_HOME_HTML_PATH = SettingKey.<String>builder()
            .id(WEB_BROWSER_HOME_HTML_PATH)
            .type(String.class)
            .defaultValue("")
            .validator(value -> value != null)
            .label("Home page")
            .category("browser")
            .build();

    public static final SettingKey<String> BROWSER_SEARCH_ENGINE = SettingKey.<String>builder()
            .id(WEB_BROWSER_SEARCH_ENGINE)
            .type(String.class)
            .defaultValue("duckduckgo")
            .validator(value -> value != null && !value.isBlank())
            .label("Primary search engine")
            .category("browser")
            .options(List.of("duckduckgo", "google", "bing", "brave", "yahoo", "custom"))
            .build();

    public static final SettingKey<String> BROWSER_SEARCH_CUSTOM_URL = SettingKey.<String>builder()
            .id(WEB_BROWSER_SEARCH_CUSTOM_URL)
            .type(String.class)
            .defaultValue("")
            .validator(value -> value != null)
            .label("Custom search URL")
            .category("browser")
            .build();

    public static final SettingKey<String> BROWSER_LINK_OPEN_TARGET = SettingKey.<String>builder()
            .id(WEB_BROWSER_LINK_OPEN_TARGET)
            .type(String.class)
            .defaultValue("system")
            .validator(value -> value != null && !value.isBlank())
            .label("Open links in")
            .category("browser")
            .options(List.of("system", "integrated"))
            .build();

    public static final SettingKey<String> BROWSER_RENDERING_MODE = SettingKey.<String>builder()
            .id(WEB_BROWSER_RENDERING_MODE)
            .type(String.class)
            .defaultValue("offscreen")
            .validator(value -> value != null && !value.isBlank())
            .label("Rendering mode")
            .category("browser")
            .options(List.of("offscreen", "windowed"))
            .build();

    public static final SettingKey<Boolean> BROWSER_OFFER_SAVE_PASSWORDS = SettingKey.<Boolean>builder()
            .id(WEB_BROWSER_OFFER_SAVE_PASSWORDS)
            .type(Boolean.class)
            .defaultValue(Boolean.TRUE)
            .validator(value -> value != null)
            .label("Offer to save passwords")
            .category("browser")
            .build();

    public static final SettingKey<Integer> LOG_BUFFER_LIMIT = SettingKey.<Integer>builder()
            .id(IDE_LOG_BUFFER_LIMIT)
            .type(Integer.class)
            .defaultValue(1000)
            .validator(value -> value != null && value >= 100 && value <= 10000)
            .label("IDE log buffer limit")
            .category("diagnostics")
            .build();

    public static final SettingKey<String> PROCESS_OUTPUT_ENCODING = SettingKey.<String>builder()
            .id(PROCESS_OUTPUT_ENCODING_KEY)
            .type(String.class)
            .defaultValue("UTF-8")
            .validator(value -> value != null && List.of("UTF-8", "CP850", "windows-1252").contains(value))
            .label("Terminal and run output encoding")
            .category("system")
            .options(List.of("UTF-8", "CP850", "windows-1252"))
            .build();

    public static final SettingKey<Integer> CLOSED_TAB_LIMIT = SettingKey.<Integer>builder()
            .id(CLOSED_TAB_RESTORE_LIMIT)
            .type(Integer.class)
            .defaultValue(5)
            .validator(value -> value != null && value >= 0)
            .label("Closed tab restore limit")
            .category("system")
            .build();

    public static final SettingKey<Integer> CLOSED_TAB_RETENTION_MINUTES = SettingKey.<Integer>builder()
            .id(CLOSED_TAB_RESTORE_RETENTION_MINUTES)
            .type(Integer.class)
            .defaultValue(0)
            .validator(value -> value != null && value >= 0)
            .label("Closed tab restore retention")
            .category("system")
            .build();

    public static final SettingKey<Boolean> INSTRUMENTATION_ENABLED = SettingKey.<Boolean>builder()
            .id(INSTRUMENTATION_ENABLED_KEY)
            .type(Boolean.class)
            .defaultValue(Boolean.FALSE)
            .validator(value -> value != null)
            .label("Internal instrumentation")
            .category("system")
            .build();

    public static final SettingKey<String> KEYMAP_PROFILE = SettingKey.<String>builder()
            .id(KEYMAP_ACTIVE_PROFILE)
            .type(String.class)
            .defaultValue("Default")
            .validator(value -> value != null && !value.isBlank())
            .label("Active keymap profile")
            .category("keymap")
            .build();

    private OrionSettings() {
    }
}
