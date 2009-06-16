package ch.puzzle.beanutils.propertiescopymachine.machine;

import ch.puzzle.beanutils.propertiescopymachine.exceptions.PropertiesCopyMachineException;
import ch.puzzle.beanutils.propertiescopymachine.modes.PropertiesCopyMode;

/**
 * @author $Author: thomas.rawyler $
 * @version $Revision: 1.3 $ $Date: 2009/06/16 05:47:35 $
 */
public interface PropertiesCopyMachine {
	/**
	 * Use this method to copy the annotated properties (getter methods) in your
	 * class. Note: your class has to be annotated as well. You have to annotate
	 * it because this method has to be sure that the caller understands the
	 * problem of copying properties.
	 * 
	 * @param <T>
	 * @param destination
	 * @param source
	 * @throws PropertiesCopyMachineException
	 */
	public <T> void setProperties(T destination, T source)
			throws PropertiesCopyMachineException;

	/**
	 * Use this method to copy the annotated properties (getter methods) in your
	 * class. Note: your class has to be annotated as well. You have to annotate
	 * it because this method has to be sure that the caller understands the
	 * problem of copying properties.
	 * 
	 * @param <T>
	 * @param <M>
	 * @param destination
	 * @param source
	 * @param propertiesCopyMode
	 * @throws PropertiesCopyMachineException
	 */
	public <T, M extends PropertiesCopyMode> void setProperties(T destination,
			T source, Class<M> propertiesCopyMode)
			throws PropertiesCopyMachineException;
}
