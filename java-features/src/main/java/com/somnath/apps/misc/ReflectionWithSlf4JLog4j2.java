package com.somnath.apps.misc;

//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class ReflectionWithSlf4JLog4j2 {

	//if you were to directly use Log4j2 library
	//private static final Logger LOGGER = LogManager.getLogger(ReflectionWithSlf4JLog4j2.class);

	//we are using slf4j facade
	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionWithSlf4JLog4j2.class);

	public static void main(String[] args) {
		LOGGER.info("start...");
		try {

			Class classRef1 = TestInnerClass.class;

			//Class classRef2 = new TestInnerClass().getClass(); // cannot be accessed from a static context

			Class classRef3 = Class.forName("com.somnath.apps.misc.ReflectionWithSlf4JLog4j2");

			Object objectRef = classRef1.newInstance();

			Method[] allMethods = objectRef.getClass().getMethods();
			LOGGER.info("All Methods: {}", allMethods);


		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
			LOGGER.error("Error occurred:", ex);

		}
		LOGGER.info("end...");
	}

	public final class TestInnerClass {
		private int x = 0;

		private int addTwoInt(final int a, final int b) {
			return a + b;
		}

		int multiplyTwoInt(final int a, final int b) {
			return a * b;
		}

		protected int subtractAFromB(final int a, final int b) {
			return b - a;
		}

		public int divideAbyB(final int a, final int b) {
			return a / b;
		}
	}

}
