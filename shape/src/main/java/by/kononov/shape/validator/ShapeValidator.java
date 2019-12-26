package by.kononov.shape.validator;

import by.kononov.shape.entity.Dot;

public class ShapeValidator{

	public boolean isTriangle(Dot dotA, Dot dotB, Dot dotC) {
		return dotA.getCoordinateX() * (dotB.getCoordinateY() - (dotC.getCoordinateY()))
				+ (dotB.getCoordinateX() * (dotC.getCoordinateY() - dotA.getCoordinateY()))
				+ (dotC.getCoordinateX() * (dotA.getCoordinateY() - dotB.getCoordinateY())) != 0;
	}
}