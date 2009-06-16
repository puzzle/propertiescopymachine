package ch.puzzle.beanutils.propertiescopymachine.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ch.puzzle.beanutils.propertiescopymachine.modes.DefaultMode;
import ch.puzzle.beanutils.propertiescopymachine.modes.PropertiesCopyMode;

/**
 * Include the property in the provided {@link PropertiesCopyMode}s. Use the
 * array notation to include multiple {@link PropertiesCopyMode}.
 * 
 * @author $Author: thomas.rawyler $
 * @version $Revision: 1.2 $ $Date: 2009/06/16 05:47:35 $
 */
@Target( { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertiesCopyIncluded {

	/**
	 * @return the propertiescopymodes
	 */
	Class<? extends PropertiesCopyMode>[] value() default DefaultMode.class;
}
