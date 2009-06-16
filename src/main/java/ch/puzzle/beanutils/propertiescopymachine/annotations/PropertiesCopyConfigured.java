package ch.puzzle.beanutils.propertiescopymachine.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * You have set everything you want to be included for the given {@link PropertiesCopyMode}s and you
 * understand its meaning. If you try to copy properties with the {@link PropertiesCopyMachineImpl} of
 * an unannotated class, an error will be thrown because the machine wasn't sure of your
 * understanding.
 * 
 * @author $Author: thomas.rawyler $
 * @version $Revision: 1.2 $ $Date: 2009/06/16 05:47:35 $
 */
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertiesCopyConfigured {

}
