package by.kononov.shape.specification.impl;

import by.kononov.shape.entity.Triangle;
import by.kononov.shape.specification.TriangleSpecification;

public class SelectByCoordinateDotA implements TriangleSpecification{
	private double minValue;
	private double maxValue;

	public SelectByCoordinateDotA(double minValue, double maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	@Override
	public boolean service(Triangle triangle) {
		return triangle.getDotA().getCoordinateX() >= minValue && triangle.getDotA().getCoordinateX() <= maxValue
				&& triangle.getDotA().getCoordinateY() >= minValue && triangle.getDotA().getCoordinateY() <= maxValue;
	}
}