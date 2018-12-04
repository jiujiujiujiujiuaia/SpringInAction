package SmallSpring.annotion;

import java.lang.annotation.*;

/**
 * @Author yuchunwei
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service {
    String value() default "";
}   
