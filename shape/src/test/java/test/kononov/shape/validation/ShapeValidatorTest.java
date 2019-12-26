package test.kononov.shape.validation;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import by.kononov.shape.entity.Dot;
import by.kononov.shape.validator.ShapeValidator;

public class ShapeValidatorTest{
	private ShapeValidator validator = new ShapeValidator();

	@Test(description = "check correct shape")
	public void isCorrectStringPositive() {
		boolean condition = validator.isTriangle(new Dot("dotA", 1, 1), new Dot("dotB", 3, 1), new Dot("dotC", 0, 4));
		assertTrue(condition);
	}

	@Test(description = "check incorrect shape")
	public void isCorrectStringNegative() {
		boolean condition = validator.isTriangle(new Dot("dotA", 0, 0), new Dot("dotB", 0, 0), new Dot("dotC", 0, 0));
		assertFalse(condition);
	}

	@Test(description = "check incorrect shape: the points are located on one straight line")
	public void isCorrectStringNegativeOneLine() {
		boolean condition = validator.isTriangle(new Dot("dotA", 3, 1), new Dot("dotB", 2, 2), new Dot("dotC", 1, 3));
		assertFalse(condition);
	}
}