package dtm.ide.api.project.editor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BreakpointOptionsTest {

    @Test
    void aLegacyConditionStaysACondition() {
        BreakpointOptions options = BreakpointOptions.decode("user.getId() == 42");

        assertEquals("user.getId() == 42", options.condition());
        assertNull(options.hitCondition());
        assertNull(options.logMessage());
    }

    @Test
    void aConditionAloneIsStoredInTheLegacyFormat() {
        assertEquals("i == 5", BreakpointOptions.ofCondition(" i == 5 ").encode());
    }

    @Test
    void everyOptionRoundTrips() {
        BreakpointOptions options = new BreakpointOptions("a == b && c != d",
                "3", "valor = {a} & total={b + c}");

        assertEquals(options, BreakpointOptions.decode(options.encode()));
    }

    @Test
    void hitAndLogWithoutConditionRoundTrip() {
        BreakpointOptions hit = new BreakpointOptions(null, "10", null);
        BreakpointOptions log = new BreakpointOptions(null, null, "passou por aqui");

        assertEquals(hit, BreakpointOptions.decode(hit.encode()));
        assertEquals(log, BreakpointOptions.decode(log.encode()));
        assertTrue(log.isLogPoint());
        assertFalse(log.hasCondition());
    }

    @Test
    void blankValuesAreEmpty() {
        BreakpointOptions options = new BreakpointOptions(" ", "", null);

        assertTrue(options.isEmpty());
        assertNull(options.encode());
        assertTrue(BreakpointOptions.decode(null).isEmpty());
        assertTrue(BreakpointOptions.decode("  ").isEmpty());
    }

    @Test
    void aConditionThatLooksEncodedIsStillPreserved() {
        BreakpointOptions options = BreakpointOptions.ofCondition("orion-bp:v1?c=x");

        assertEquals(options, BreakpointOptions.decode(options.encode()));
    }

    @Test
    void breakpointsExposeTheirOptions() {
        BreakpointIde breakpoint = BreakpointIde.of(4, false,
                new BreakpointOptions("x > 1", "2", "msg"));

        assertEquals(4, breakpoint.line());
        assertFalse(breakpoint.active());
        assertTrue(breakpoint.hasCondition());
        assertTrue(breakpoint.hasHitCondition());
        assertTrue(breakpoint.isLogPoint());
        assertEquals(new BreakpointOptions("x > 1", "2", "msg"), breakpoint.options());
        assertEquals(new BreakpointIde(1, true, "c", null, null), new BreakpointIde(1, true, "c"));
    }
}
