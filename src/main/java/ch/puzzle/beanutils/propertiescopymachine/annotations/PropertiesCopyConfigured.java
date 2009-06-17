package ch.puzzle.beanutils.propertiescopymachine.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * You have set everything you want to be included for the given
 * {@link PropertiesCopyMode}s and you understand its meaning. If you try to
 * copy properties with the {@link PropertiesCopyMachineImpl} of an unannotated
 * class, an error will be thrown because the machine wasn't sure of your
 * understanding.
 * 
 * @author Thomas Rawyler (rawyler@puzzle.ch)
 */
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertiesCopyConfigured {

}
