package dtm.ide.api.extension;

import dtm.ide.api.extension.event.BreakpointChangedEvent;
import dtm.ide.api.extension.menu.IdeMenuBuilder;
import dtm.ide.api.hierarchy.CallHierarchyCall;
import dtm.ide.api.hierarchy.CallHierarchyItem;
import dtm.ide.api.hierarchy.TypeHierarchyItem;
import dtm.ide.api.project.editor.*;
import dtm.ide.api.theme.EditorTheme;
import dtm.stools.component.panels.editor.code.CodeEditor;
import dtm.stools.component.panels.editor.code.api.CodeAction;
import dtm.stools.component.panels.editor.code.api.DocumentSymbol;
import dtm.stools.component.panels.editor.code.api.Location;
import dtm.stools.component.panels.editor.code.api.Range;
import dtm.stools.component.panels.editor.code.api.TextEdit;
import dtm.stools.component.panels.editor.code.autocomplete.AutoCompleteItem;
import dtm.stools.component.panels.editor.code.codelens.CodeLens;
import dtm.stools.component.panels.editor.code.diagnostics.Diagnostic;
import dtm.stools.component.panels.editor.code.documenthighlight.DocumentHighlight;
import dtm.stools.component.panels.editor.code.ghost.GhostTextSuggestion;
import dtm.stools.component.panels.editor.code.hover.HoverInfo;
import dtm.stools.component.panels.editor.code.inlay.InlayHint;
import dtm.stools.component.panels.editor.code.prototype.Token;
import dtm.stools.component.panels.editor.code.prototype.folding.FoldRule;
import dtm.stools.component.panels.editor.code.prototype.folding.FoldRange;
import dtm.stools.component.panels.editor.code.prototype.styles.TextStyle;
import dtm.stools.component.panels.editor.code.provider.TokenizerCodeEditorProvider;
import dtm.stools.component.panels.editor.code.signature.SignatureHelp;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface IdeAdapterEditorCallbacks {

    default boolean isBreakPointEnabled(Path fileOpen) { return true; }
    default boolean isConditionalBreakpointEnabled(Path fileOpen) { return false; }
    default void configureConditionalBreakpointEditor(IdeEditorContext editorContext, ConditionalBreakpointContext context) {}
    default CodeEditor createConditionalBreakpointEditor(ConditionalBreakpointContext context) { return null; }
    default void configureConditionalBreakpointDialog(ConditionalBreakpointDialogView dialogView) {}
    default void onBreakpointChanged(BreakpointChangedEvent event) {}
    default EditorTheme getEditorTheme() { return null; }
    default void configureEditor(IdeEditorContext editorContext) {}
    default boolean delegatesCodeEditorPaths(Path filePath) { return true; }
    default Collection<FileAssociated> getFileAssociations() { return List.of(); }
    default Collection<FileTypeAssociated> getFileTypeAssociations() { return List.of(); }
    default Collection<String> getSupportedFileExtensions() { return List.of(); }
    default boolean acceptsAliasedPaths() { return true; }
    default String getLineCommentPrefix(Path filePath) { return null; }
    default TokenizerCodeEditorProvider resolveSyntaxHighlightTokenizer(Path filePath) { return null; }
    default TextStyle resolveSyntaxHighlightTextStyle(Path filePath, Token token) { return null; }
    default Collection<FoldRule> resolveFoldRules(Path filePath) { return null; }
    default CompletableFuture<List<FoldRange>> resolveFoldRanges(Path filePath, String text, long documentVersion) {
        return CompletableFuture.completedFuture(null);
    }
    default boolean supportsIncrementalDiagnostics() { return true; }
    default Collection<Diagnostic> getDiagnostics(IdeDiagnosticsContext context, boolean incremental, Collection<Diagnostic> diagnostics) { return null; }
    default List<AutoCompleteItem> getCompletionSuggestions(IdeCompletionContext context) { return null; }
    default CompletableFuture<List<AutoCompleteItem>> getCompletionSuggestionsAsync(IdeCompletionContext context) {
        return CompletableFuture.completedFuture(getCompletionSuggestions(context));
    }
    default boolean shouldAutoTriggerCompletion(IdeCompletionContext context) { return false; }
    default boolean isAutoCompletionOnTypingEnabled() { return false; }
    default Set<Character> getCompletionTriggerCharacters() { return Set.of(); }
    default Set<Character> getCompletionTriggerCharacters(Path filePath) {
        return getCompletionTriggerCharacters();
    }
    default CompletableFuture<AutoCompleteItem> resolveCompletionItem(AutoCompleteItem item) {
        return CompletableFuture.completedFuture(item);
    }
    default String getGhostText(IdeGhostTextContext context) { return null; }
    default GhostTextSuggestion getGhostSuggestion(IdeGhostTextContext context) { return GhostTextSuggestion.of(getGhostText(context)); }
    default List<Location> findDefinitions(IdeDefinitionContext context) { return null; }
    default List<Location> findReferences(IdeDefinitionContext context) { return null; }
    default List<DocumentSymbol> getDocumentSymbols(IdeDocumentSymbolContext context) { return null; }
    default List<TextEdit> computeRenameEdits(IdeRenameContext context) { return null; }
    default IdeWorkspaceEdit computeRenameWorkspaceEdit(IdeRenameContext context) { return null; }
    default boolean isRenameEnabled(Path filePath) { return false; }
    default IdeRenamePolicy getRenamePolicy(Path filePath) { return IdeRenamePolicy.undeclared(); }
    default IdeRenamePreparation prepareRename(IdeRenamePrepareContext context) { return null; }
    default String validateRenameName(IdeRenamePrepareContext context, String newName) { return null; }
    default List<CodeAction> getCodeActions(IdeCodeActionContext context) { return null; }
    default List<Range> getSelectionRanges(IdeSelectionRangeContext context) { return null; }
    default CompletableFuture<List<int[]>> getSelectionRanges(SelectionRangeContext context) {
        return CompletableFuture.completedFuture(List.of());
    }
    default HoverInfo getHover(IdeHoverContext context) { return null; }
    default CompletableFuture<HoverInfo> getHoverAsync(IdeHoverContext context) {
        return CompletableFuture.completedFuture(getHover(context));
    }
    default IdeDiagnosticHoverPolicy getDiagnosticHoverPolicy(Path filePath) { return IdeDiagnosticHoverPolicy.disabled(); }
    default void onHover(IdeHoverContext context) {}
    default List<InlayHint> getInlayHints(IdeInlayHintContext context) { return null; }
    default CompletableFuture<List<InlayHint>> getInlayHintsAsync(IdeInlayHintContext context) {
        return CompletableFuture.completedFuture(getInlayHints(context));
    }
    default List<CodeLens> getCodeLenses(IdeCodeLensContext context) { return null; }
    default List<DocumentHighlight> getDocumentHighlights(IdeDocumentHighlightContext context) { return null; }
    default boolean isSemanticTokensEnabled() { return false; }
    default List<SemanticToken> getSemanticTokens(IdeSemanticTokensContext context) { return null; }
    default CompletableFuture<List<SemanticToken>> getSemanticTokensAsync(IdeSemanticTokensContext context) {
        return CompletableFuture.completedFuture(getSemanticTokens(context));
    }
    default boolean isCallHierarchyEnabled() { return false; }
    default List<CallHierarchyItem> prepareCallHierarchy(IdeCallHierarchyContext context) { return null; }
    default List<CallHierarchyCall> getIncomingCalls(CallHierarchyItem item) { return null; }
    default List<CallHierarchyCall> getOutgoingCalls(CallHierarchyItem item) { return null; }
    default boolean isTypeHierarchyEnabled() { return false; }
    default List<TypeHierarchyItem> prepareTypeHierarchy(IdeCallHierarchyContext context) { return List.of(); }
    default List<TypeHierarchyItem> getSupertypes(TypeHierarchyItem item) { return List.of(); }
    default List<TypeHierarchyItem> getSubtypes(TypeHierarchyItem item) { return List.of(); }
    default SignatureHelp provideSignatureHelp(IdeSignatureHelpContext context) { return null; }
    default CompletableFuture<SignatureHelp> provideSignatureHelpAsync(IdeSignatureHelpContext context) {
        return CompletableFuture.completedFuture(provideSignatureHelp(context));
    }
    default Set<Character> getSignatureTriggerCharacters() { return Set.of(); }
    default Set<Character> getSignatureRetriggerCharacters() { return Set.of(); }
    default void onWordClick(IdeWordClickContext context) {}
    default void onWordCaretChange(IdeWordCaretContext context) {}
    default boolean isGoToDeclarationEnabled() { return false; }
    default boolean isGoToImplementationEnabled() { return false; }
    default boolean isFindUsagesEnabled() { return false; }
    default void onGoToDeclaration(IdeEditorContext context) {}
    default void onGoToImplementation(IdeEditorContext context) {}
    default void onFindUsages(IdeEditorContext context) {}
    default void contributeEditorMenu(IdeMenuBuilder menu, IdeEditorContext editorContext) {}
    default void contributeTabMenu(IdeMenuBuilder menu, IdeTabMenuContext context) {}
    default String formatCode(FormatCodeContext formatCodeContext) { return null; }
    default void onEditorOpen(IdeEditorContext editorContext) {}
    default void onEditorSelected(IdeEditorContext editorContext) {}
    default void onEditorClose(Path filePath) {}
    default void onCodeEditorInsertText(IdeEditorContext editorContext, int offset, String inserted) {}
    default void onCodeEditorDeleteText(IdeEditorContext editorContext, int offset, String removed) {}
    default void onCodeEditorTextChanged(IdeEditorContext editorContext) {}
    default void onCodeEditorTextChanged(IdeEditorContext editorContext, TextChange change) {
        onCodeEditorTextChanged(editorContext);
    }
}
