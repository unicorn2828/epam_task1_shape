package test.kononov.shape.validation;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.kononov.shape.validator.StringValidator;

public class StringValidatorTest{
	private StringValidator validator;

	@BeforeClass
	public void setUp() {
		validator = new StringValidator();
	}

	@AfterClass
	public void tierDown() {
		validator = null;
	}

	@DataProvider
	public Object[][] correctStrings() {
		return new Object[][] {
				{ "111 1.0 1.0 1.0 2.0 2.0 1.0" },
				{ "112 1.1 1.2 1.3 2.4 2.5 1.6" },
				{ "114 10.0 10.0 10.0 20.0 20.0 10.0" },
				{ "115 1.11 1.12 1.13 2.14 2.15 2.16" },
				{ "(7^5|1&2<<(2|5>>2&71))|1200", "1202" }, };
	}

	@Test(dataProvider = "correctStrings", description = "check correct strings")
	public void isCorrectStringPositive(String correctString) {
		boolean condition = validator.isCorrectString(correctString);
		assertTrue(condition);
	}

	@DataProvider
	public Object[][] incorrectStrings() {
		return new Object[][] {
				{ "1z11 1.0 1.0 1.0 2.0 2.0 1.0" },
				{ "111 1z.0 1.0 1.0 2.0 2.0 1.0" },
				{ "111 -1.0 1.0 1.0 2.0 2.0 1.0" },
				{ "111 1.0 1.0 1.0 2.0 2.0" },
				{ "111 1.0 1.0 1.0 2.0 2.0 1.0 1.1" },
				{ "1.11 1.0 1.0 1.0 2.0 2.0 2.0" },
				{ "-111 1.0 1.0 1.0 2.0 2.0 1.0" },
				{ "116 this is some str*/$nge string" },
				{ " " }, };
	}

	@Test(dataProvider = "incorrectStrings", description = "check incorrect strings")
	public void isCorrectStringNegative(String incorrectString) {
		boolean condition = validator.isCorrectString(incorrectString);
		assertFalse(condition);
	}
}