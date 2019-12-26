package by.kononov.shape.specification.impl;

import static by.kononov.shape.data.impl.TriangleDataImpl.PERIMETER;

import by.kononov.shape.entity.Triangle;
import by.kononov.shape.specification.TriangleSpecification;

public class SelectByPerimeter implements TriangleSpecification{
	private double minValue;
	private double maxValue;

	public SelectByPerimeter(double minValue, double maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	@Override
	public boolean service(Triangle triangle) {
		return PERIMETER.service(triangle) >= minValue && PERIMETER.service(triangle) <= maxValue;
	}
}
