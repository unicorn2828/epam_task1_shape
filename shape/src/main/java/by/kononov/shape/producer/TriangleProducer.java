package by.kononov.shape.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import by.kononov.shape.entity.Dot;
import by.kononov.shape.entity.Triangle;
import by.kononov.shape.listener.TriangleListener;
import by.kononov.shape.listener.impl.TriangleListenerImpl;
import by.kononov.shape.parser.StringParser;
import by.kononov.shape.repository.TriangleRepository;
import by.kononov.shape.validator.ShapeValidator;

public class TriangleProducer{
	private final static TriangleProducer INSTANCE = new TriangleProducer();
	private static final String TRIANGLE_ID = "triangleId";
	private static final String DOT_A_NAME = "dotA";
	private static final String DOT_B_NAME = "dotB";
	private static final String DOT_C_NAME = "dotC";

	private TriangleProducer() {
	}

	public static TriangleProducer getInstance() {
		return INSTANCE;
	}

	public List<Triangle> createTriangleList(List<String> shapesDataList) {
		List<Triangle> triangleList = new ArrayList<>();
		TriangleRepository triangleRepository = TriangleRepository.getInstance();
		StringParser parser = new StringParser();
		Map<String, Object> values;
		for (String dataLine : shapesDataList) {
			values = parser.parseString(dataLine);
			Optional<Triangle> optional = createTriangle((long) values.get(TRIANGLE_ID), (Dot) values.get(DOT_A_NAME),
					(Dot) values.get(DOT_B_NAME), (Dot) values.get(DOT_C_NAME));
			if (optional.isPresent()) {
				triangleRepository.addTriangle(optional.get());
				putParametersIntoWarehouse(optional.get());
				triangleList.add(optional.get());
			}
		}
		return triangleList;
	}

	public Optional<Triangle> createTriangle(long triangleId, Dot dotA, Dot dotB, Dot dotC) {
		ShapeValidator shapeValidator = new ShapeValidator();
		if (!shapeValidator.isTriangle(dotA, dotB, dotC)) {
			return Optional.empty();
		}
		return Optional.of(new Triangle(triangleId, dotA, dotB, dotC));
	}

	private void putParametersIntoWarehouse(Triangle triangle) {
		TriangleListener listener = new TriangleListenerImpl();
		listener.update(triangle);
	}
}