package com.anz.service.FxCalculatorApp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.anz.model.CurrencyCodeTest;
import com.anz.model.FxCalculatorTest;

@RunWith(Suite.class)
@SuiteClasses({CurrencyCodeTest.class, FxCalculatorTest.class})
public class AppTestSuite {
	
}
