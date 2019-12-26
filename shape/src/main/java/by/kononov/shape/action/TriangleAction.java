package by.kononov.shape.action;

import by.kononov.shape.entity.Triangle;

public interface TriangleAction{
	boolean isIsoscelesTriangle(Triangle triangle);

	boolean isEquilateralTriangle(Triangle triangle);

	boolean isRectangularTriangle(Triangle triangle);

	boolean isAcuteTriangle(Triangle triangle);

	boolean isObtuseTriangle(Triangle triangle);
}
