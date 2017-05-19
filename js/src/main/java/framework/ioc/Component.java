package framework.ioc;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(value={java.lang.annotation.ElementType.TYPE})
@Retention(value=java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

	String id() default "";
	
	String scope() default "singleton";
	
}
