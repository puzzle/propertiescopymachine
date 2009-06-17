package ch.puzzle.beanutils.propertiescopymachine.exceptions;

/**
 * @author Thomas Rawyler (rawyler@puzzle.ch)
 */
public class PropertiesCopyMachineException extends Exception {

	private static final long serialVersionUID = 5943367554687239124L;

	/**
	 * 
	 */
	public PropertiesCopyMachineException() {
		super();
	}

	/**
	 * @param message
	 */
	public PropertiesCopyMachineException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PropertiesCopyMachineException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PropertiesCopyMachineException(String message, Throwable cause) {
		super(message, cause);
	}

}
