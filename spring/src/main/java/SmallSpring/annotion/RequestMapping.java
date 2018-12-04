package SmallSpring.annotion;

import java.lang.annotation.*;

/**
 * @Author yuchunwei
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {
    String value() default "";
}   
