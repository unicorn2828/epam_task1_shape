package by.kononov.shape.validator;

import java.io.File;

public class FileValidator{

	public boolean isFile(String filePath) {
		File file = new File(filePath);
		return !file.isDirectory() && file.exists() && file.length() != 0;
	}
}
