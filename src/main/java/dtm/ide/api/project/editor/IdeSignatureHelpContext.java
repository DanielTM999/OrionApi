package dtm.ide.api.project.editor;

import dtm.stools.component.panels.editor.code.signature.SignatureHelp;

import java.nio.file.Path;

public record IdeSignatureHelpContext(String text, Path filePath, int caretOffset, int caretLine, int caretCol, String currentLine, IdeSignatureHelpTriggerKind triggerKind, char triggerCharacter, boolean retrigger, SignatureHelp activeSignatureHelp, long documentVersion) {
    public IdeSignatureHelpContext(String text, Path filePath, int caretOffset, int caretLine,
                                   int caretCol, String currentLine, IdeSignatureHelpTriggerKind triggerKind,
                                   char triggerCharacter, boolean retrigger, SignatureHelp activeSignatureHelp) {
        this(text, filePath, caretOffset, caretLine, caretCol, currentLine, triggerKind,
                triggerCharacter, retrigger, activeSignatureHelp, -1);
    }
}
