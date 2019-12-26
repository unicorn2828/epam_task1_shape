package by.kononov.shape.warehouse;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import by.kononov.shape.data.impl.TriangleDataImpl;

public class Warehouse{
	private final static Warehouse instance = new Warehouse();

	private Map<Long, EnumMap<TriangleDataImpl, Double>> parameterList = new HashMap<>();

	private Warehouse() {
	}

	public static Warehouse getInstance() {
		return instance;
	}

	public Map<Long, EnumMap<TriangleDataImpl, Double>> receiveParametersList() {
		return parameterList;
	}

	public double receiveSquare(long id) {
		return parameterList.get(id).get(TriangleDataImpl.SQUARE);
	}

	public double receivePerimeter(long id) {
		return parameterList.get(id).get(TriangleDataImpl.PERIMETER);
	}

	public boolean removeShapeParam(long id) {
		parameterList.remove(id);
		return parameterList.get(id) == null;
	}
}
