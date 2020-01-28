package com.anz.model;

public class FxCalculator {
	
	public static final String CONJUNCTION = "in";
	
	private CurrencyCode ccy1;
	private CurrencyCode ccy2;
	private double amount1;
	private double amount2;
	
	public CurrencyCode getCcy1() {
		return ccy1;
	}

	public void setCcy1(CurrencyCode ccy1) {
		this.ccy1 = ccy1;
	}

	public CurrencyCode getCcy2() {
		return ccy2;
	}

	public void setCcy2(CurrencyCode ccy2) {
		this.ccy2 = ccy2;
	}

	public double getAmount1() {
		return amount1;
	}

	public void setAmount1(Double amount1) {
		this.amount1 = amount1;
	}
	
	public double getAmount2() {
		return amount2;
	}

	public void setAmount2(Double amount2) {
		this.amount2 = amount2;
	}
	
	@Override
	public String toString() {
		return "FxCalculator [ccy1=" + ccy1 + ", ccy2=" + ccy2 + ", amount1=" + amount1 + ", amount2=" + amount2 + "]";
	}

	/**
	 * Check validation of input format
	 * @param args - the input string
	 */
	public void inputValidate(String[] args) {
		int i = 0;
		ccy1 = CurrencyCode.toCurrencyCodeOrNull(args[i].toUpperCase());
		amount1 = Double.valueOf(args[++i]);
		if(!args[++i].equals(CONJUNCTION)) {
			throw new IllegalArgumentException ("The string '" + args[i] + "' is not expected conjunction 'in'.");
		}
		ccy2 = CurrencyCode.toCurrencyCodeOrNull(args[++i].toUpperCase());
	}

}
