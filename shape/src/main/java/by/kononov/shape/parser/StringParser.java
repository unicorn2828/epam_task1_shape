package by.kononov.shape.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import by.kononov.shape.entity.Dot;
import by.kononov.shape.validator.StringValidator;

public class StringParser{
	private static final String TRIANGLE_ID = "triangleId";
	private static final String DOT_A_NAME = "dotA";
	private static final String DOT_B_NAME = "dotB";
	private static final String DOT_C_NAME = "dotC";

	public List<String> checkString(List<String> listDataLines) {
		StringValidator stringValidator = new StringValidator();
		List<String> shapesDataList = new ArrayList<>();
		listDataLines.forEach(dataLine -> {
			if (stringValidator.isCorrectString(dataLine)) {
				shapesDataList.add(dataLine);
			}
		});
		return shapesDataList;
	}

	public Map<String, Object> parseString(String shapesDataString) {
		Map<String, Object> values = new HashMap<>();
		double coordinateX;
		double coordinateY;
		Dot dot;
		try (Scanner scanner = new Scanner(shapesDataString)) {
			long triangleId = scanner.nextInt();
			values.put(TRIANGLE_ID, triangleId);
			coordinateX = scanner.nextDouble();
			coordinateY = scanner.nextDouble();
			dot = new Dot(DOT_A_NAME, coordinateX, coordinateY);
			values.put(DOT_A_NAME, dot);
			coordinateX = scanner.nextDouble();
			coordinateY = scanner.nextDouble();
			dot = new Dot(DOT_B_NAME, coordinateX, coordinateY);
			values.put(DOT_B_NAME, dot);
			coordinateX = scanner.nextDouble();
			coordinateY = scanner.nextDouble();
			dot = new Dot(DOT_C_NAME, coordinateX, coordinateY);
			values.put(DOT_C_NAME, dot);
		}
		return values;
	}
}