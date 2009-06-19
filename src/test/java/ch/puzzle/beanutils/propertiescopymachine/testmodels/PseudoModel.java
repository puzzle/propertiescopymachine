package ch.puzzle.beanutils.propertiescopymachine.testmodels;

import ch.puzzle.beanutils.propertiescopymachine.annotations.PropertiesCopyConfigured;
import ch.puzzle.beanutils.propertiescopymachine.annotations.PropertiesCopyIncluded;

/**
 * @author Thomas Rawyler (rawyler@puzzle.ch)
 */
@PropertiesCopyConfigured
public class PseudoModel {
	private String name;

	private String prename;

	/**
	 * @return the name
	 */
	@PropertiesCopyIncluded
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the prename
	 */
	public String getPrename() {
		return this.prename;
	}

	/**
	 * @param prename
	 *            the prename to set
	 */
	public void setPrename(String prename) {
		this.prename = prename;
	}

}
