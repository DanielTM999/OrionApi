package dtm.ide.api.project.editor;

public record TextChange(int offset, int removedLength, String insertedText, long version) {
}
