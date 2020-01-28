package com.anz.util;

import java.util.function.Function;

public class TestUtil {

	private static String msg;

	public static Throwable shouldFailWithMessageContaining(String expectedExceptionClass, String expectedtext,
			Function<String, Object> code) {
		Throwable e = shouldFail(expectedExceptionClass, code);
		msg = e.getMessage();
		assert msg.contains(expectedtext) : "Message " + msg + " does not contain " + expectedtext;
		return e;
	}

	static Throwable shouldFail(String expectedExceptionClass, Function<String, Object> code) {
		Throwable actualException = null;
		try {
			code.apply(msg);
		} catch (Throwable thrown) {
			actualException = thrown;
		}
		assert actualException != null : "No exception thrown. ExceptedException " + expectedExceptionClass;
		return actualException;
	}

	public static void assertNoErrors() {

	}

}
