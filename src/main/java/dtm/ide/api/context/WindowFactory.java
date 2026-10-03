package dtm.ide.api.context;

import dtm.stools.context.IWindow;

import java.lang.ref.Reference;
import java.util.concurrent.atomic.AtomicReference;

public interface WindowFactory {
    <T extends IWindow> T newWindow(Class<T> ref);
    <T extends IWindow> T newWindow(Class<T> ref, Object... args);
    <T extends IWindow> T newWindow(Class<T> ref, boolean orGetIfExist);
    <T extends IWindow> T newWindow(Class<T> ref, boolean orGetIfExist, Object... args);

    <T extends IWindow> T newWindow(AtomicReference<Class<T>> ref);
    <T extends IWindow> T newWindow(AtomicReference<Class<T>> ref, Object... args);
    <T extends IWindow> T newWindow(AtomicReference<Class<T>> ref, boolean orGetIfExist);
    <T extends IWindow> T newWindow(AtomicReference<Class<T>> ref, boolean orGetIfExist, Object... args);

    <T extends IWindow> T newWindow(Reference<Class<T>> ref);
    <T extends IWindow> T newWindow(Reference<Class<T>> ref, Object... args);
    <T extends IWindow> T newWindow(Reference<Class<T>> ref, boolean orGetIfExist);
    <T extends IWindow> T newWindow(Reference<Class<T>> ref, boolean orGetIfExist, Object... args);
}
