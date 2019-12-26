package test.kononov.shape.validation;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kononov.shape.validator.FileValidator;

public class FileValidatorTest{
	private FileValidator validator;
	private final String FILE_NAME = "data/shapesData.txt";
	private final String FAKE_FILE_NAME = ".../wrong/path/data.txt";

	@BeforeClass
	public void setUp() {
		validator = new FileValidator();
	}

	@AfterClass
	public void tierDown() {
		validator = null;
	}

	@Test(description = "check correct file")
	public void isFilePositive() {
		boolean condition = validator.isFile(FILE_NAME);
		assertTrue(condition);
	}

	@Test(description = "check incorrect file")
	public void isFileNegative() {
		boolean condition = validator.isFile(FAKE_FILE_NAME);
		assertFalse(condition);
	}
}