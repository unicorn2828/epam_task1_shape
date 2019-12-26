package by.kononov.shape.data;

import by.kononov.shape.entity.Triangle;

@FunctionalInterface
public interface TriangleData{
	double service(Triangle triangle);
}
