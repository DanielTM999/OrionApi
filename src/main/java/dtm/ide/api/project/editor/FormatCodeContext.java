package dtm.ide.api.project.editor;

import java.nio.file.Path;

public record FormatCodeContext(
    String fullText,
    String text,
    String extension,
    Path file,
    IdeFormatScope formatScope,
    int startOffset,
    int endOffset,
    int tabSize,
    boolean useSpacesForTab,
    String chainedText
) {

    public FormatCodeContext withChainedText(String chainedText) {
        return new FormatCodeContext(
                fullText,
                text,
                extension,
                file,
                formatScope,
                startOffset,
                endOffset,
                tabSize,
                useSpacesForTab,
                chainedText
        );
    }
}
