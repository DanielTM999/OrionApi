package dtm.ide.api.extension.screen;

import org.junit.jupiter.api.Test;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ManagedCenterTabRequestTest {

    @Test
    void rejectsBlankKey() {
        assertThrows(IllegalArgumentException.class,
                () -> new ManagedCenterTabRequest(" ", "Nota", new JPanel(), true, null, null));
    }

    @Test
    void rejectsMissingComponent() {
        assertThrows(NullPointerException.class,
                () -> new ManagedCenterTabRequest("note", "Nota", null, true, null, null));
    }

    @Test
    void suppliesTitleAndListenerDefaults() {
        ManagedCenterTabRequest request = ManagedCenterTabRequest.of("note", " ", new JPanel());

        assertEquals("note", request.title());
        assertNotNull(request.listener());
    }
}
