package by.kononov.shape.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator{
	private final static Pattern TRIANGLE_REGEX = Pattern.compile("([\\d+]{1})+([\\s]{1}+[\\d+]+[\\.]{1}[\\d+]+){6}");

	public boolean isCorrectString(String string) {
		Matcher matcher = TRIANGLE_REGEX.matcher(string);
		return matcher.matches();
	}
}