package com.anz.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.anz.util.Arguments;

/**
 * Represents the model for CurrencyCode
 * 
 * @version
 * @author Aparna
 *
 */
public final class CurrencyCode {
	
	public static final int MAX_CURRENCY_CODE_LENGTH = 3;
	private static Set<String> currencyCodes = createCurrencyCodeList();
	private static Map<String, Integer> precisionList = createPrecisionList();
	
	private final String id;
	
	/**
	 * To check validation for currency code
	 * @param currencyCode - the currencyCode string (e.g. "USD"); Must not be null; the 
	 * length must be MAX_CURRENCY_CODE_LENGTH
	 * @param fieldName - the field name being validated
	 * 
	 * @throws IllegalArgumentException - if the input string is not a valid currency code value.
	 */
	public static void validCurrencyCode(String currencyCode, String fieldName) {
		Arguments.notNullOrEmpty(currencyCode, fieldName);
		boolean validCurrency = currencyCodes.contains(currencyCode.trim().toUpperCase());
		if(!validCurrency) {
			throw new IllegalArgumentException("The " + fieldName + " ["+ currencyCode + "] was not found");
		}
	}
	
	/**
	 * To get the currency code from the string value
	 * @param currencyCode - the currencyCode string (e.g. "USD"); 
	 * @return the currencyCode or else null
	 * 
	 * @throws IllegalArgumentException - if the input string is not a valid currency code value.
	 */
	public static CurrencyCode toCurrencyCodeOrNull(String currencyCode) {
		if(currencyCode == null) {
			return null;
		}
		return new CurrencyCode(currencyCode);
	}
	
	/**
	 * to get the string value for currencyCode
	 * @param currencyCode - the currencyCode (e.g. "USD"); 
	 * @return the currencyCode or else null
	 * 
	 * @throws IllegalArgumentException - if the input string is not a valid currency code value.
	 */
	public static String toCodeStringOrNull(CurrencyCode currencyCode) {
		return currencyCode == null ? null : currencyCode.getCode();
	}
	
	/**
	 * get the precision value for the currency code
	 * @param currencyCode - the currencyCode string (e.g. "USD"); 
	 * @return the precision digits from the list for the currencyCode
	 */
	public static int getPrecision(String currencyCode) {
		return precisionList.get(currencyCode);
	}
	
	/**
	 * Constructor for Currency Code model
	 * @param currencyCode - the currencyCode string (e.g. "USD"); Must not be null; the 
	 * length must be MAX_CURRENCY_CODE_LENGTH 
	 * 
	 * @throws IllegalArgumentException - if the input string is not a valid currency code value.
	 */
	public CurrencyCode(String currencyCode) {
		Arguments.notNullOrEmpty(currencyCode, "currencyCode");
		String trimmedCurrencyCode = currencyCode.trim();
		Arguments.checkMaximumLength(currencyCode, "currencyCode", MAX_CURRENCY_CODE_LENGTH);
		validCurrencyCode(currencyCode, "currencyCode");
		this.id = trimmedCurrencyCode;
	}
	
	@Override
	public String toString() {
		return "CurrencyCode [id=" + id + "]";
	}

	/**
	 * @return the id value as a string
	 */
	public String getCode() {
		return id;
	}
	
	/**
	 * Creation of list of currency codes
	 * @return the list of currency code
	 */
	private static Set<String> createCurrencyCodeList() {
		
		Set<String> currencyCodes = new HashSet<String>();
		currencyCodes.add("AUD");
		currencyCodes.add("CAD");
		currencyCodes.add("CNY");
		currencyCodes.add("CZK");
		currencyCodes.add("DKK");
		currencyCodes.add("EUR");
		currencyCodes.add("GBP");
		currencyCodes.add("JPY");
		currencyCodes.add("NOK");
		currencyCodes.add("NZD");
		currencyCodes.add("USD");
		
		return currencyCodes;
	}
	
	/**
	 * Creation of precision list for currency code
	 * @return the key value pair for currency code and precision list
	 */
	private static Map<String, Integer> createPrecisionList() {
		
		Map<String, Integer> precisionList = new HashMap<>();
		precisionList.put("AUD", 2);
		precisionList.put("CAD", 2);
		precisionList.put("CNY", 2);
		precisionList.put("CZK", 2);
		precisionList.put("DKK", 2);
		precisionList.put("EUR", 2);
		precisionList.put("GBP", 2);
		precisionList.put("JPY", 0);
		precisionList.put("NOK", 2);
		precisionList.put("NZD", 2);
		precisionList.put("USD", 2);
		
		return precisionList;
	}
}
