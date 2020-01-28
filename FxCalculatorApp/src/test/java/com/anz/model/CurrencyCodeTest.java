package com.anz.model;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import org.junit.Test;

import com.anz.util.TestUtil;

public class CurrencyCodeTest {
	
	@Test
	public void testGetCode() {
		CurrencyCode currencyCode = new CurrencyCode("USD");
		assertEquals(currencyCode.getCode(), "USD");
	}
	
	@Test
	public void testConstructor() {
		CurrencyCode currencyCode = new CurrencyCode("USD");
		assertEquals(currencyCode.toString(), "CurrencyCode [id=USD]");
	}
	
	@Test
	public void testToString() {
		CurrencyCode currencyCode = new CurrencyCode("USD");
		assertEquals(currencyCode.toString(), "CurrencyCode [id=USD]");
	}
	
	@Test
	public void testToCodeStringOrNull() {
		assertEquals(CurrencyCode.toCodeStringOrNull(new CurrencyCode("USD")), "USD");
	}
	
	@Test
	public void testValidateCurrencyCode() {
		CurrencyCode.validCurrencyCode("USD", "currencyCode");
		TestUtil.assertNoErrors();
	}
	
	@Test
	public void testValidateCurrencyCode_WitInvalidCurrencyCode_ThrowsException() {
		Function<String, Object> valid = (a) -> {
			a = "IST";
			CurrencyCode.validCurrencyCode(a, "currencyCode");
			return a;};
		TestUtil.shouldFailWithMessageContaining(IllegalArgumentException.class.getName(), "currencyCode", valid);
	}
	
	@Test
	public void testToCurrencyCodeOrNull_TooLongCurrencyCode_ThrowsException() {
		Function<String, Object> valid = (a) -> {
			a = "USDkcjj";
			CurrencyCode.toCurrencyCodeOrNull(a);
			return a;};
		TestUtil.shouldFailWithMessageContaining(IllegalArgumentException.class.getName(), "currencyCode", valid);
	}
	
}
