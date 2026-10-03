package dtm.ide.api.context;

import dtm.di.exceptions.NewInstanceException;

public interface InstanceFactory {
    <T> T newInstance(Class<T> clazz) throws NewInstanceException;

    <T> T newInstance(Class<T> clazz, Object... args) throws NewInstanceException;

    <T> T newInstanceWithAspect(Class<T> clazz) throws NewInstanceException;

    <T> T newInstanceWithAspect(Class<T> clazz, Object... args) throws NewInstanceException;

    <T> T newInstanceWithoutAspect(Class<T> clazz) throws NewInstanceException;

    <T> T newInstanceWithoutAspect(Class<T> clazz, Object... args) throws NewInstanceException;
}
