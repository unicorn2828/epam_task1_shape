package by.kononov.shape.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.kononov.shape.exception.CustomException;
import by.kononov.shape.validator.FileValidator;

public class DataReader{
	final static Logger logger = LogManager.getLogger();

	public List<String> readFile(String filePath) throws CustomException {
		FileValidator validator = new FileValidator();
		if (!validator.isFile(filePath)) {
			throw new CustomException("bad or doesn't exist: " + filePath);
		}
		List<String> linesList = new ArrayList<>();
		try {
			linesList = Files.readAllLines(Paths.get(filePath));
		} catch (IOException e) {
			logger.error("can't be read data: " + filePath, e);
			throw new CustomException("can't be read data: " + filePath, e);
		}
		return linesList;
	}
}