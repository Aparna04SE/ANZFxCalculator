package com.anz.util;

public class Arguments {
	
	/**
	 * Check the maximum length of the string value
	 * @param value - the string to be checked for maximum length
	 * @param argName - the field name
	 * @param maxLength - the maximum length 
	 */
	public static void checkMaximumLength(String value, String argName, int maxLength) {
		notNullOrEmpty(value, argName);
		if(value.length() > maxLength) {
			throw new IllegalArgumentException ("The string '" + argName + "' exceeds the maximum length of '" + maxLength + "'");
		}
	}
	
	/**
	 * Check the minimum length of the string value
	 * @param value - the string to be checked for minimum length
	 * @param argName - the field name
	 * @param maxLength - the minimum length 
	 */
	public static void checkMinimumLength(String[] value, String argName, int minLength) {
		//Arguments.notNullOrEmpty(value, argName);
		if(value.length < minLength) {
			throw new IllegalArgumentException ("The string '" + argName + "' does not have minimum length of '" + minLength + "'");
		}
	}

	/**
	 * Check whether the value is null or empty
	 * @param value - the string to be checked for null or empty
	 * @param argName - the field name
	 */
	public static void notNullOrEmpty(String value, String argName) {
		if( argName == null) {
			throw new IllegalArgumentException ("The argName of the received 'value' parameter cannot be null.");
		}
		
		if( argName.trim().length() == 0) {
			throw new IllegalArgumentException ("The argName of the received 'value' parameter cannot be empty.");
		}
		
		if( value == null) {
			throw new IllegalArgumentException ("The string '" + argName + "' is null.");
		}
		
		if( value.trim().length() == 0) {
			throw new IllegalArgumentException ("The string '" + argName + "' is empty.");
		}
	}
	
	private Arguments() {
		
	}

}
