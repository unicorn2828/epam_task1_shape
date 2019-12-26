package by.kononov.shape.listener.impl;

import static by.kononov.shape.data.impl.TriangleDataImpl.ANGLE_A;
import static by.kononov.shape.data.impl.TriangleDataImpl.ANGLE_B;
import static by.kononov.shape.data.impl.TriangleDataImpl.ANGLE_C;
import static by.kononov.shape.data.impl.TriangleDataImpl.PERIMETER;
import static by.kononov.shape.data.impl.TriangleDataImpl.SQUARE;

import java.util.EnumMap;

import by.kononov.shape.data.impl.TriangleDataImpl;
import by.kononov.shape.entity.Triangle;
import by.kononov.shape.listener.TriangleListener;
import by.kononov.shape.warehouse.Warehouse;

public class TriangleListenerImpl implements TriangleListener{

	@Override
	public void update(Triangle triangle) {
		Warehouse warehouse = Warehouse.getInstance();
		EnumMap<TriangleDataImpl, Double> parameters = new EnumMap<>(TriangleDataImpl.class);
		parameters.put(SQUARE, SQUARE.service(triangle));
		parameters.put(PERIMETER, PERIMETER.service(triangle));
		parameters.put(ANGLE_A, ANGLE_A.service(triangle));
		parameters.put(ANGLE_B, ANGLE_B.service(triangle));
		parameters.put(ANGLE_C, ANGLE_C.service(triangle));
		warehouse.receiveParametersList().put(triangle.getId(), parameters);
	}
}
