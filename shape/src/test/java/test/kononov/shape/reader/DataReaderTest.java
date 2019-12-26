package test.kononov.shape.reader;

import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kononov.shape.exception.CustomException;
import by.kononov.shape.reader.DataReader;

public class DataReaderTest{
	private final static String FILE_NAME = "data/shapesData.txt";
	private final static String FAKE_FILE_NAME = "wrong/path/daata.txt";
	private final static String BAD_FILE_NAME = "data/badData.txt";
	private DataReader dataReader;

	@BeforeClass
	public void setUp() {
		dataReader = new DataReader();
	}

	@AfterClass
	public void tierDown() {
		dataReader = null;
	}

	@Test(description = "check if the file can be read")
	public void readFileTestPositive() throws CustomException {
		List<String> actual = dataReader.readFile(FILE_NAME);
		assertNotNull(actual);
	}

	@Test(timeOut = 500, description = "check for exception if the file can't be read longer then specified time")
	public void readFileTestTime() throws CustomException {
		dataReader.readFile(FILE_NAME);
	}

	@Test(expectedExceptions = CustomException.class, description = "check for exception if the file can't be read")
	public void readFileExceptionTest() throws CustomException {
		dataReader.readFile(FAKE_FILE_NAME);
	}

	@Test(expectedExceptions = CustomException.class, description = "check incorrect file for exception")
	public void readFileTestNegative() throws CustomException {
		dataReader.readFile(BAD_FILE_NAME);
	}
}