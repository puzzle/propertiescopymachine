package ch.puzzle.beanutils.propertiescopymachine.machine;

import ch.puzzle.beanutils.propertiescopymachine.annotations.PropertiesCopyConfigured;
import ch.puzzle.beanutils.propertiescopymachine.annotations.PropertiesCopyIncluded;
import ch.puzzle.beanutils.propertiescopymachine.exceptions.PropertiesCopyMachineException;
import ch.puzzle.beanutils.propertiescopymachine.modes.PropertiesCopyMode;

/**
 * The {@link PropertiesCopyMachineImpl} copies properties accessed by getter
 * methods of an object with all its inherited properties from source to
 * destination. The {@link PropertiesCopyMachineImpl} will only copy the
 * properties (getter methods) annotated with {@link PropertiesCopyIncluded}. In
 * addition you have to annotate the class of the passed object with
 * {@link PropertiesCopyConfigured}. That is to ensure you have thought through
 * your problem.
 * 
 * @author Thomas Rawyler (rawyler@puzzle.ch)
 */
public interface PropertiesCopyMachine {
	/**
	 * Use this method to copy the annotated properties (getter methods) in your
	 * class. Note: your class has to be annotated as well. You have to annotate
	 * it because this method has to be sure that the caller understands the
	 * problem of copying properties.
	 * 
	 * @param <D>
	 * @param <S>
	 * @param destination
	 * @param source
	 * @throws PropertiesCopyMachineException
	 */
	public <S, D extends S> void setProperties(D destination, S source)
			throws PropertiesCopyMachineException;

	/**
	 * Use this method to copy the annotated properties (getter methods) in your
	 * class. Note: your class has to be annotated as well. You have to annotate
	 * it because this method has to be sure that the caller understands the
	 * problem of copying properties.
	 * 
	 * @param <D>
	 * @param <S>
	 * @param <M>
	 * @param destination
	 * @param source
	 * @param propertiesCopyMode
	 * @throws PropertiesCopyMachineException
	 */
	public <S, D extends S, M extends PropertiesCopyMode> void setProperties(D destination,
			S source, Class<M> propertiesCopyMode)
			throws PropertiesCopyMachineException;
}
