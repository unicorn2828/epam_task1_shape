package by.kononov.shape.specification.impl;

import by.kononov.shape.entity.Triangle;
import by.kononov.shape.specification.TriangleSpecification;

public class SelectByCoordinateDotB implements TriangleSpecification{
	private double minValue;
	private double maxValue;

	public SelectByCoordinateDotB(double minValue, double maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	@Override
	public boolean service(Triangle triangle) {
		return triangle.getDotB().getCoordinateX() >= minValue && triangle.getDotB().getCoordinateX() <= maxValue
				&& triangle.getDotB().getCoordinateY() >= minValue && triangle.getDotB().getCoordinateY() <= maxValue;
	}
}
