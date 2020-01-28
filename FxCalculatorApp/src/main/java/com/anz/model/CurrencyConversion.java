package com.anz.model;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConversion {
	
	public static Map<String, Double> currencyRates = createCurrencyPairRates();
	
	public static Map<String, String> crossMatrix = createCrossMatrix();
	
	/**
	 * Creation of currency rates
	 * @return the key value pair for currency code and currency rate
	 */
	private static Map<String, Double> createCurrencyPairRates() {
		
		Map<String, Double> currencyRates = new HashMap<>();
		currencyRates.put("AUDUSD", 0.8371);
		currencyRates.put("CADUSD", 0.8711);
		currencyRates.put("CNYUSD", 6.1715);
		currencyRates.put("EURUSD", 1.2315);
		currencyRates.put("GBPUSD", 1.5683);
		currencyRates.put("NZDUSD", 0.7750);
		currencyRates.put("USDJPY", 119.95);
		currencyRates.put("EURCZK", 27.6028);
		currencyRates.put("EURDKK", 7.4405);
		currencyRates.put("EURNOK", 8.6651);
		
		return currencyRates;
		
	}

	/**
	 * Creation of cross matrix
	 * @return the key value pair for cross via matrix for conversion
	 */
	private static Map<String, String> createCrossMatrix() {
		Map<String, String> crossMatrix = new HashMap<>();
		
		crossMatrix.put("AUDAUD", "1:1");
		crossMatrix.put("AUDCAD", "USD");
		crossMatrix.put("AUDCNY", "USD");
		crossMatrix.put("AUDCZK", "USD");
		crossMatrix.put("AUDDKK", "USD");
		crossMatrix.put("AUDEUR", "USD");
		crossMatrix.put("AUDGBP", "USD");
		crossMatrix.put("AUDJPY", "USD");
		crossMatrix.put("AUDNOK", "USD");
		crossMatrix.put("AUDNZD", "USD");
		crossMatrix.put("AUDUSD", "D");
		
		crossMatrix.put("CADAUD", "USD");
		crossMatrix.put("CADCAD", "1:1");
		crossMatrix.put("CADCNY", "USD");
		crossMatrix.put("CADCZK", "USD");
		crossMatrix.put("CADDKK", "USD");
		crossMatrix.put("CADEUR", "USD");
		crossMatrix.put("CADGBP", "USD");
		crossMatrix.put("CADJPY", "USD");
		crossMatrix.put("CADNOK", "USD");
		crossMatrix.put("CADNZD", "USD");
		crossMatrix.put("CADUSD", "D");
		
		crossMatrix.put("CNYAUD", "USD");
		crossMatrix.put("CNYCAD", "USD");
		crossMatrix.put("CNYCNY", "1:1");
		crossMatrix.put("CNYCZK", "USD");
		crossMatrix.put("CNYDKK", "USD");
		crossMatrix.put("CNYEUR", "USD");
		crossMatrix.put("CNYGBP", "USD");
		crossMatrix.put("CNYJPY", "USD");
		crossMatrix.put("CNYNOK", "USD");
		crossMatrix.put("CNYNZD", "USD");
		crossMatrix.put("CNYUSD", "D");
		
		crossMatrix.put("CZKAUD", "USD");
		crossMatrix.put("CZKCAD", "USD");
		crossMatrix.put("CZKCNY", "USD");
		crossMatrix.put("CZKCZK", "1:1");
		crossMatrix.put("CZKDKK", "EUR");
		crossMatrix.put("CZKEUR", "Inv");
		crossMatrix.put("CZKGBP", "USD");
		crossMatrix.put("CZKJPY", "USD");
		crossMatrix.put("CZKNOK", "EUR");
		crossMatrix.put("CZKNZD", "USD");
		crossMatrix.put("CZKUSD", "EUR");
		
		crossMatrix.put("DKKAUD", "USD");
		crossMatrix.put("DKKCAD", "USD");
		crossMatrix.put("DKKCNY", "USD");
		crossMatrix.put("DKKCZK", "EUR");
		crossMatrix.put("DKKDKK", "1:1");
		crossMatrix.put("DKKEUR", "Inv");
		crossMatrix.put("DKKGBP", "USD");
		crossMatrix.put("DKKJPY", "USD");
		crossMatrix.put("DKKNOK", "EUR");
		crossMatrix.put("DKKNZD", "USD");
		crossMatrix.put("DKKUSD", "EUR");
		
		crossMatrix.put("EURAUD", "USD");
		crossMatrix.put("EURCAD", "USD");
		crossMatrix.put("EURCNY", "USD");
		crossMatrix.put("EURCZK", "D");
		crossMatrix.put("EURDKK", "D");
		crossMatrix.put("EUREUR", "1:1");
		crossMatrix.put("EURGBP", "USD");
		crossMatrix.put("EURJPY", "USD");
		crossMatrix.put("EURNOK", "D");
		crossMatrix.put("EURNZD", "USD");
		crossMatrix.put("EURUSD", "D");
		
		crossMatrix.put("GBPAUD", "USD");
		crossMatrix.put("GBPCAD", "USD");
		crossMatrix.put("GBPCNY", "USD");
		crossMatrix.put("GBPCZK", "USD");
		crossMatrix.put("GBPDKK", "USD");
		crossMatrix.put("GBPEUR", "USD");
		crossMatrix.put("GBPGBP", "1:1");
		crossMatrix.put("GBPJPY", "USD");
		crossMatrix.put("GBPNOK", "USD");
		crossMatrix.put("GBPNZD", "USD");
		crossMatrix.put("GBPUSD", "D");
		
		crossMatrix.put("JPYAUD", "USD");
		crossMatrix.put("JPYCAD", "USD");
		crossMatrix.put("JPYCNY", "USD");
		crossMatrix.put("JPYCZK", "USD");
		crossMatrix.put("JPYDKK", "USD");
		crossMatrix.put("JPYEUR", "USD");
		crossMatrix.put("JPYGBP", "USD");
		crossMatrix.put("JPYJPY", "1:1");
		crossMatrix.put("JPYNOK", "USD");
		crossMatrix.put("JPYNZD", "USD");
		crossMatrix.put("JPYUSD", "Inv");
		
		crossMatrix.put("NOKAUD", "USD");
		crossMatrix.put("NOKCAD", "USD");
		crossMatrix.put("NOKCNY", "USD");
		crossMatrix.put("NOKCZK", "EUR");
		crossMatrix.put("NOKDKK", "EUR");
		crossMatrix.put("NOKEUR", "Inv");
		crossMatrix.put("NOKGBP", "USD");
		crossMatrix.put("NOKJPY", "USD");
		crossMatrix.put("NOKNOK", "1:1");
		crossMatrix.put("NOKNZD", "USD");
		crossMatrix.put("NOKUSD", "EUR");
		
		crossMatrix.put("NZDAUD", "USD");
		crossMatrix.put("NZDCAD", "USD");
		crossMatrix.put("NZDCNY", "USD");
		crossMatrix.put("NZDCZK", "USD");
		crossMatrix.put("NZDDKK", "USD");
		crossMatrix.put("NZDEUR", "USD");
		crossMatrix.put("NZDGBP", "1:1");
		crossMatrix.put("NZDJPY", "USD");
		crossMatrix.put("NZDNOK", "USD");
		crossMatrix.put("NZDNZD", "1:1");
		crossMatrix.put("NZDUSD", "D");
		
		crossMatrix.put("USDAUD", "Inv");
		crossMatrix.put("USDCAD", "Inv");
		crossMatrix.put("USDCNY", "Inv");
		crossMatrix.put("USDCZK", "EUR");
		crossMatrix.put("USDDKK", "EUR");
		crossMatrix.put("USDEUR", "Inv");
		crossMatrix.put("USDGBP", "Inv");
		crossMatrix.put("USDJPY", "D");
		crossMatrix.put("USDNOK", "EUR");
		crossMatrix.put("USDNZD", "Inv");
		crossMatrix.put("USDUSD", "1:1");
		
		return crossMatrix;
	}

}
