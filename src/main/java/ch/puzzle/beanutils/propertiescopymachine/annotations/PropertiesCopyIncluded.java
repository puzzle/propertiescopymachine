package ch.puzzle.beanutils.propertiescopymachine.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ch.puzzle.beanutils.propertiescopymachine.machine.PropertiesCopyMachine;
import ch.puzzle.beanutils.propertiescopymachine.modes.DefaultMode;
import ch.puzzle.beanutils.propertiescopymachine.modes.PropertiesCopyMode;

/**
 * Include the property in the provided {@link PropertiesCopyMode}s. If you pass
 * no parameters, the default mode is used instead. If you just want to start
 * copying some properties of a bean, don't specify a mode and use the simple
 * method of {@link PropertiesCopyMachine} to copy them. Use the array notation
 * to include multiple {@link PropertiesCopyMode}. If you need custom modes,
 * like for instance NewVersion, create an interface and extend
 * {@link PropertiesCopyMode}.
 * 
 * @author Thomas Rawyler (rawyler@puzzle.ch)
 */
@Target( { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertiesCopyIncluded {

	/**
	 * @return the propertiescopymodes
	 */
	Class<? extends PropertiesCopyMode>[] value() default DefaultMode.class;
}
