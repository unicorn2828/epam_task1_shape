package by.kononov.shape.specification.impl;

import static by.kononov.shape.data.impl.TriangleDataImpl.SQUARE;

import by.kononov.shape.entity.Triangle;
import by.kononov.shape.specification.TriangleSpecification;

public class SelectBySquare implements TriangleSpecification{
	private double minValue;
	private double maxValue;

	public SelectBySquare(double minValue, double maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	@Override
	public boolean service(Triangle triangle) {
		return SQUARE.service(triangle) >= minValue && SQUARE.service(triangle) <= maxValue;
	}

}
