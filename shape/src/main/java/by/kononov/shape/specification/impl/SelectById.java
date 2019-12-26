package by.kononov.shape.specification.impl;

import by.kononov.shape.entity.Triangle;
import by.kononov.shape.specification.TriangleSpecification;

public class SelectById implements TriangleSpecification{
	private long minValue;
	private long maxValue;

	public SelectById(long minValue, long maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	@Override
	public boolean service(Triangle triangle) {
		return triangle.getId() >= minValue && triangle.getId() <= maxValue;
	}
}