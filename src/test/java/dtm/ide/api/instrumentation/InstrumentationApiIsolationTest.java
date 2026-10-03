package dtm.ide.api.instrumentation;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InstrumentationApiIsolationTest {

    @Test
    void wrapperEntitiesDoNotExposeInternalPluginClassesOrClassLoaders() {
        assertTrue(Arrays.stream(PluginInstrumentation.class.getMethods())
                .anyMatch(method -> method.getName().equals("getPluginClassName")
                        && method.getReturnType() == String.class));

        Stream.of(
                        PluginInstrumentation.class,
                        PluginCollectionInstrumentation.class,
                        PluginCollectionMetainfoInstrumentation.class,
                        PluginCollectionSlotInstrumentation.class
                )
                .flatMap(type -> Arrays.stream(type.getMethods()))
                .forEach(this::assertSafeSignature);
    }

    private void assertSafeSignature(Method method) {
        assertFalse(ClassLoader.class.isAssignableFrom(method.getReturnType()), method::toString);
        assertFalse(method.getReturnType().getName().startsWith("dtm.ide.core."), method::toString);
        assertFalse(Arrays.stream(method.getParameterTypes())
                .anyMatch(type -> type.getName().startsWith("dtm.ide.core.")), method::toString);
    }
}
