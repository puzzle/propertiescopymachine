package ch.puzzle.beanutils.propertiescopymachine.machine;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.lang.annotation.AnnotationFormatError;

import org.junit.Before;
import org.junit.Test;

import ch.puzzle.beanutils.propertiescopymachine.exceptions.PropertiesCopyMachineException;
import ch.puzzle.beanutils.propertiescopymachine.modes.DefaultMode;
import ch.puzzle.beanutils.propertiescopymachine.testmodels.PseudoModel;
import ch.puzzle.beanutils.propertiescopymachine.testmodels.UnannotatedSubPseudoModel;

/**
 * @author $Author: thomas.rawyler $
 * @version $Revision: 1.2 $ $Date: 2009/06/16 05:47:34 $
 */
public class PropertiesCopyMachineTest {
	private PseudoModel pseudoModelLeft;
	private PseudoModel pseudoModelRight;

	@Before
	public void setUp() {
		this.pseudoModelLeft = new PseudoModel();
		this.pseudoModelLeft.setName("left");
		this.pseudoModelLeft.setPrename("left");
		this.pseudoModelRight = new PseudoModel();
		this.pseudoModelRight.setName("right");
		this.pseudoModelRight.setPrename("right");
	}

	/**
	 * 
	 */
	@Test
	public void testWithSimpleModel() {

		PropertiesCopyMachineImpl propertiesCopyMachine = new PropertiesCopyMachineImpl();

		try {
			propertiesCopyMachine.setProperties(this.pseudoModelLeft,
					this.pseudoModelRight, DefaultMode.class);
		} catch (PropertiesCopyMachineException e) {
			fail(e.getMessage());
		}

		assertThat(this.pseudoModelLeft.getName(), is(this.pseudoModelRight
				.getName()));

		assertThat(this.pseudoModelLeft.getPrename(),
				is(not(this.pseudoModelRight.getPrename())));
	}

	/**
	 * 
	 */
	@Test
	public void testWithSimpleModelDefault() {

		PropertiesCopyMachineImpl propertiesCopyMachine = new PropertiesCopyMachineImpl();

		try {
			propertiesCopyMachine.setProperties(this.pseudoModelLeft,
					this.pseudoModelRight);
		} catch (PropertiesCopyMachineException e) {
			fail(e.getMessage());
		}

		assertThat(this.pseudoModelLeft.getName(), is(this.pseudoModelRight
				.getName()));

		assertThat(this.pseudoModelLeft.getPrename(),
				is(not(this.pseudoModelRight.getPrename())));
	}

	/**
	 * 
	 */
	@Test(expected = AnnotationFormatError.class)
	public void testWithSimpleModelExceptions() {

		PropertiesCopyMachineImpl propertiesCopyMachine = new PropertiesCopyMachineImpl();

		try {
			propertiesCopyMachine.setProperties(
					new UnannotatedSubPseudoModel(),
					new UnannotatedSubPseudoModel());
		} catch (PropertiesCopyMachineException e) {
			// do nothing
		}

	}

}
