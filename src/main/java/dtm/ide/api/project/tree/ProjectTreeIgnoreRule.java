package dtm.ide.api.project.tree;

public record ProjectTreeIgnoreRule(
        String name,
        ProjectTreeIgnoreMatchType matchType
) {

    public ProjectTreeIgnoreRule {
        name = name != null ? name.trim() : "";
        matchType = matchType != null ? matchType : ProjectTreeIgnoreMatchType.ANY;
    }

    public static ProjectTreeIgnoreRule any(String name) {
        return new ProjectTreeIgnoreRule(name, ProjectTreeIgnoreMatchType.ANY);
    }

    public static ProjectTreeIgnoreRule specific(String name) {
        return new ProjectTreeIgnoreRule(name, ProjectTreeIgnoreMatchType.SPECIFIC);
    }

    public boolean isAny() {
        return matchType == ProjectTreeIgnoreMatchType.ANY;
    }

    public boolean isSpecific() {
        return matchType == ProjectTreeIgnoreMatchType.SPECIFIC;
    }
}
