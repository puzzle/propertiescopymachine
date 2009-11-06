package ch.puzzle.beanutils.propertiescopymachine.machine;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.AnnotationFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import ch.puzzle.beanutils.propertiescopymachine.annotations.PropertiesCopyConfigured;
import ch.puzzle.beanutils.propertiescopymachine.annotations.PropertiesCopyIncluded;
import ch.puzzle.beanutils.propertiescopymachine.exceptions.PropertiesCopyMachineException;
import ch.puzzle.beanutils.propertiescopymachine.modes.DefaultMode;
import ch.puzzle.beanutils.propertiescopymachine.modes.PropertiesCopyMode;

/**
 * @author Thomas Rawyler (rawyler@puzzle.ch)
 * 
 */
public class PropertiesCopyMachineImpl implements PropertiesCopyMachine {

	/**
	 * @param <D>
	 * @param <S>
	 * @param destination
	 * @param source
	 * @param includes
	 *            getter method names to exclude
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	protected synchronized <S, D extends S> void setProperties(D destination, S source,
			List<PropertyDescriptor> includes) throws IntrospectionException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {

		// copy the remaining properties
		for (PropertyDescriptor pd : includes) {
			String propertyName = pd.getName();
			Object propertyValue = PropertyUtils.getProperty(source,
					propertyName);
			PropertyUtils.setProperty(destination, propertyName, propertyValue);
		}
	}

	/**
	 * @see najs.util.PropertiesCopyMachine#setProperties(java.lang.Object,
	 *      java.lang.Object, java.lang.Class)
	 */
	public <S, D extends S, M extends PropertiesCopyMode> void setProperties(D destination,
			S source, Class<M> propertiesCopyMode)
			throws PropertiesCopyMachineException {
		// check if the class has been set up correctly
		this.checkIfPropertiesCopyIsConfigured(source);

		// get the properties that will be copied
		List<PropertyDescriptor> includes;
		try {
			includes = this.getIncludedProperties(source, propertiesCopyMode);

			this.setProperties(destination, source, includes);
		} catch (Exception e) {
			throw new PropertiesCopyMachineException(e.getMessage(), e
					.getCause());
		}
	}

	/**
	 * @see najs.util.PropertiesCopyMachine#setProperties(java.lang.Object,
	 *      java.lang.Object)
	 */
	public <S, D extends S> void setProperties(D destination, S source)
			throws PropertiesCopyMachineException {
		this.setProperties(destination, source, DefaultMode.class);
	}

	/**
	 * @param <T>
	 * @param source
	 * @param propertiesCopyMode
	 * @return a list of the properties that have to be copied
	 * @throws IntrospectionException
	 */
	protected <T, M extends PropertiesCopyMode> List<PropertyDescriptor> getIncludedProperties(
			T source, Class<M> propertiesCopyMode)
			throws IntrospectionException {
		List<PropertyDescriptor> includes = new ArrayList<PropertyDescriptor>();

		// descriptor
		BeanInfo beanInfo = Introspector.getBeanInfo(source.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();

		// for each getter of the class
		// note: inherited getters are included with the BeanUtil Introspector
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			Method readMethod = propertyDescriptor.getReadMethod();

			PropertiesCopyIncluded annotation = readMethod
					.getAnnotation(PropertiesCopyIncluded.class);

			// if it was annotated with the included property
			if (annotation != null) {
				Class<? extends PropertiesCopyMode>[] value = annotation
						.value();
				List<Class<? extends PropertiesCopyMode>> declaredModes = Arrays
						.asList(value);

				if (declaredModes.contains(propertiesCopyMode)) {
					includes.add(propertyDescriptor);
				}
			}

		}

		return includes;
	}

	/**
	 * check if the class is really configured for the copy mechanism
	 * 
	 * @param <T>
	 * @param source
	 */
	protected <T> void checkIfPropertiesCopyIsConfigured(T source) {
		Class<?> clazz = source.getClass();
		PropertiesCopyConfigured annotation = clazz
				.getAnnotation(PropertiesCopyConfigured.class);

		if (annotation == null) {
			throw new AnnotationFormatError(
					"Your class is not annotated to be set up for the properties copy mechanism. "
							+ clazz.getName());
		}
	}
}
