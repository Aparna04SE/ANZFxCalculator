package com.anz.service.FxCalculatorApp;

import java.text.DecimalFormat;

import com.anz.model.CurrencyCode;
import com.anz.model.CurrencyConversion;
import com.anz.model.FxCalculator;
import com.anz.util.Arguments;

public class FxCalculatorApp {

	public static final int MIN_ARGUMENT_LENGTH = 4;
	
	public static final String SAME_CURRENCY = "1:1"; 
	public static final String DIRECT = "D"; 
	public static final String INVERT = "Inv";
	public static String precisionPattern = "0.";

	private double amount2;
	private String pattern="0";
	
	/**
	 * Conversion of know currency to equivalent another currency
	 * @param ccy1 - the currency code provided
	 * @param ccy2 - the currency code to be converted
	 * @param amount1 - the amount to be converted
	 * 
	 * @return amount2 - the equivalent amount converted
	 */
	public double calculate(CurrencyCode ccy1, CurrencyCode ccy2, Double amount1) {
		String result = CurrencyConversion.crossMatrix.get(ccy1.getCode()+ccy2.getCode());
		if(result.equals(SAME_CURRENCY)) 
		{
			this.amount2 = amount1;
		}
		else if(result.equals(DIRECT)) {
			amount2 = amount1 * CurrencyConversion.currencyRates.get(ccy1.getCode()+ccy2.getCode());
		}
		else if(result.equals(INVERT)) {
			amount2 =  amount1 * CurrencyConversion.currencyRates.get(ccy2.getCode()+ccy1.getCode());
		}
		else {
			String subResult1;
			String subResult2;
			if(CurrencyConversion.crossMatrix.get(ccy1.getCode()+result).equals(DIRECT)) {
				subResult1 = ccy1.getCode()+result;
			}
			else {
				subResult1 = result+ccy1.getCode();
			}
			if(CurrencyConversion.crossMatrix.get(ccy2.getCode()+result).equals(DIRECT)) {
				subResult2 = ccy2.getCode()+result;
			}
			else {
				subResult2 = result+ccy2.getCode();
			}
			Double subAmount = amount1 * CurrencyConversion.currencyRates.get(subResult1);
			amount2 = subAmount * CurrencyConversion.currencyRates.get(subResult2);
		}
		for(int i=0; i<CurrencyCode.getPrecision(ccy2.getCode()); i++) {
			precisionPattern.concat(pattern);
		}
		DecimalFormat df = new DecimalFormat(precisionPattern);
		return Double.valueOf(df.format(amount2));
		
	}

	public static void main(String args[]) {

		Arguments.checkMinimumLength(args, "input", MIN_ARGUMENT_LENGTH);
		FxCalculator fx = new FxCalculator();
		fx.inputValidate(args);
		FxCalculatorApp app = new FxCalculatorApp();
		
		fx.setAmount2(app.calculate(fx.getCcy1(), fx.getCcy2(), fx.getAmount1()));
		
		System.out.println( CurrencyCode.toCodeStringOrNull(fx.getCcy1()) + " " + fx.getAmount1() + " = " + CurrencyCode.toCodeStringOrNull(fx.getCcy2()) + 
				" " + fx.getAmount2());

	}

}
