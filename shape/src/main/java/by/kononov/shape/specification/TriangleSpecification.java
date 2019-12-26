package by.kononov.shape.specification;

import by.kononov.shape.entity.Triangle;

@FunctionalInterface
public interface TriangleSpecification{
	boolean service(Triangle triangle);
}
