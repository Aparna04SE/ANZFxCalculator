package com.anz.model;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import org.junit.Test;

import com.anz.util.TestUtil;

public class FxCalculatorTest {

	private static final CurrencyCode CCY1 = new CurrencyCode("USD");
	private static final CurrencyCode CCY2 = new CurrencyCode("USD");
	private static final double AMOUNT1 = 23.0;
	private static final double AMOUNT2 = 23.0;
	private static final FxCalculator fxCalculator = buildFxCalculator();

	@Test
	public void testFxCalculator_Getters() {
		assertEquals(fxCalculator.getCcy1(), CCY1);
		assertEquals(fxCalculator.getCcy2(), CCY2);
	}

	@Test
	public void testToString() {
		FxCalculator fx = buildFxCalculator();
		assertEquals(fx.toString(), "FxCalculator [ccy1=" + CCY1.toString() + ", ccy2=" + CCY2.toString() + ", amount1="
				+ AMOUNT1 + ", amount2=" + AMOUNT2 + "]");
	}

	@Test
	public void testInputValidate() {
		FxCalculator fx = new FxCalculator();
		String[] input = { "USD", String.valueOf(AMOUNT1), "in", "JPY" };
		fx.inputValidate(input);
		TestUtil.assertNoErrors();
	}

	@Test
	public void testInvalidInput() {
		FxCalculator fx = new FxCalculator();
		String[] input = { "USD", String.valueOf(AMOUNT1), "in", "JPYD" };
		Function<String, Object> valid = (a) -> {
			fx.inputValidate(input);
			return a;
		};
		TestUtil.shouldFailWithMessageContaining(IllegalArgumentException.class.getName(), "currencyCode", valid);

	}

	private static FxCalculator buildFxCalculator() {
		FxCalculator fx = new FxCalculator();
		fx.setCcy1(CCY1);
		fx.setCcy2(CCY2);
		fx.setAmount1(AMOUNT1);
		fx.setAmount2(AMOUNT2);
		return fx;
	}

}
