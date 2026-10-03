package dtm.ide.api.annotations;

import dtm.ide.api.plugin.PluginScope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PluginReference {
    String id();
    String name() default "";
    String description() default "";
    String version() default "";
    String website() default "";
    int priority() default 0;
    boolean singleton() default false;
    PluginScope scope() default PluginScope.APPLICATION;
    String[] dependsOn() default {};
}
