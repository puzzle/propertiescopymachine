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
import ch.puzzle.beanutils.propertiescopymachine.testmodels.TestModel;
import ch.puzzle.beanutils.propertiescopymachine.testmodels.UnannotatedSubTestModel;

/**
 * @author $Author: thomas.rawyler $
 * @version $Revision: 1.2 $ $Date: 2009/06/16 05:47:34 $
 */
public class PropertiesCopyMachineTest {
	private TestModel testModelLeft;
	private TestModel testModelRight;

	@Before
	public void setUp() {
		this.testModelLeft = new TestModel();
		this.testModelLeft.setName("left");
		this.testModelLeft.setPrename("left");
		this.testModelRight = new TestModel();
		this.testModelRight.setName("right");
		this.testModelRight.setPrename("right");
	}

	/**
	 * 
	 */
	@Test
	public void testWithSimpleModel() {

		PropertiesCopyMachineImpl propertiesCopyMachine = new PropertiesCopyMachineImpl();

		try {
			propertiesCopyMachine.setProperties(this.testModelLeft,
					this.testModelRight, DefaultMode.class);
		} catch (PropertiesCopyMachineException e) {
			fail(e.getMessage());
		}

		assertThat(this.testModelLeft.getName(), is(this.testModelRight
				.getName()));

		assertThat(this.testModelLeft.getPrename(), is(not(this.testModelRight
				.getPrename())));
	}

	/**
	 * 
	 */
	@Test
	public void testWithSimpleModelDefault() {

		PropertiesCopyMachineImpl propertiesCopyMachine = new PropertiesCopyMachineImpl();

		try {
			propertiesCopyMachine.setProperties(this.testModelLeft,
					this.testModelRight);
		} catch (PropertiesCopyMachineException e) {
			fail(e.getMessage());
		}

		assertThat(this.testModelLeft.getName(), is(this.testModelRight
				.getName()));

		assertThat(this.testModelLeft.getPrename(), is(not(this.testModelRight
				.getPrename())));
	}

	/**
	 * 
	 */
	@Test(expected = AnnotationFormatError.class)
	public void testWithSimpleModelExceptions() {

		PropertiesCopyMachineImpl propertiesCopyMachine = new PropertiesCopyMachineImpl();

		try {
			propertiesCopyMachine.setProperties(new UnannotatedSubTestModel(),
					new UnannotatedSubTestModel());
		} catch (PropertiesCopyMachineException e) {
			// do nothing
		}

	}

}
