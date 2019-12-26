package by.kononov.shape.specification.impl;

import by.kononov.shape.entity.Triangle;
import by.kononov.shape.specification.TriangleSpecification;

public class SelectByZeroCoordinate implements TriangleSpecification{
	private double coordinateX;
	private double coordinateY;

	public SelectByZeroCoordinate(double coordinateX, double coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	@Override
	public boolean service(Triangle triangle) {
		return triangle.getDotA().getCoordinateX() <= coordinateX && triangle.getDotA().getCoordinateY() <= coordinateY
				&& triangle.getDotB().getCoordinateX() <= coordinateX
				&& triangle.getDotB().getCoordinateY() <= coordinateY
				&& triangle.getDotC().getCoordinateX() <= coordinateX
				&& triangle.getDotC().getCoordinateY() <= coordinateY;
	}
}