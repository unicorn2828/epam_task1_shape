package test.kononov.shape.action;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kononov.shape.action.impl.TriangleActionImpl;
import by.kononov.shape.entity.Dot;
import by.kononov.shape.entity.Triangle;

public class ShapeActionTest{
	private Triangle isoscelesTriangle;
	private Triangle equilateralTriangle;
	private Triangle rectangularTriangle;
	private Triangle acuteTriangle;
	private Triangle obtuseTriangle;
	private TriangleActionImpl action;

	@BeforeClass
	public void setUp() {
		isoscelesTriangle = new Triangle(1, new Dot("dotA", 1, 1), new Dot("dotB", 4, 1), new Dot("dotC", 1, 4));
		equilateralTriangle =
				new Triangle(2, new Dot("dotA", 2.7, 10), new Dot("dotB", 0, 0), new Dot("dotC", 10, 2.7));
		rectangularTriangle = new Triangle(3, new Dot("dotA", 1, 1), new Dot("dotB", 4, 1), new Dot("dotC", 1, 3));
		acuteTriangle = new Triangle(4, new Dot("dotA", 1, 1), new Dot("dotB", 3, 1), new Dot("dotC", 1.5, 2.5));
		obtuseTriangle = new Triangle(5, new Dot("dotA", 1, 1), new Dot("dotB", 4, 0), new Dot("dotC", 1, 4));
		action = new TriangleActionImpl();
	}

	@AfterClass
	public void tierDown() {
		isoscelesTriangle = null;
		equilateralTriangle = null;
		rectangularTriangle = null;
		acuteTriangle = null;
		obtuseTriangle = null;
		action = null;
	}

	@Test(description = "is correct isosceles triangle") // равнобедренный
	public void isIsoscelesTrianglePositive() {
		boolean condition = action.isIsoscelesTriangle(isoscelesTriangle);
		assertTrue(condition);
	}

	@Test(description = "is incorrect isosceles triangle")
	public void isIsoscelesTriangleNegative() {
		boolean condition = action.isIsoscelesTriangle(obtuseTriangle);
		assertFalse(condition);
	}

	@Test(description = "is correct equilateral triangle") // равносторонний
	public void isEquilateralTrianglePositive() {
		boolean condition = action.isEquilateralTriangle(equilateralTriangle);
		assertTrue(condition);
	}

	@Test(description = "is incorrect equilateral triangle")
	public void isEquilateralTriangleNegative() {
		boolean condition = action.isEquilateralTriangle(obtuseTriangle);
		assertFalse(condition);
	}

	@Test(description = "is correct rectangular triangle") // прямоугольный
	public void isRectangularTrianglePositive() {
		boolean condition = action.isRectangularTriangle(rectangularTriangle);
		assertTrue(condition);
	}

	@Test(description = "is incorrect rectangular triangle")
	public void isRectangularTriangleNegative() {
		boolean condition = action.isRectangularTriangle(obtuseTriangle);
		assertFalse(condition);
	}

	@Test(description = "is a correct acute triangle") // остроуголный
	public void isAcuteTrianglePositive() {
		boolean condition = action.isAcuteTriangle(acuteTriangle);
		assertTrue(condition);
	}

	@Test(description = "is incorrect acute triangle")
	public void isAcuteTriangleNegative() {
		boolean condition = action.isAcuteTriangle(obtuseTriangle);
		assertFalse(condition);
	}

	@Test(description = "is correct obtuse triangle") // тупоугольный
	public void isObtuseTrianglePositive() {
		boolean condition = action.isObtuseTriangle(obtuseTriangle);
		assertTrue(condition);
	}

	@Test(description = "is incorrect obtuse triangle")
	public void isObtusTriangleNegative() {
		boolean condition = action.isObtuseTriangle(acuteTriangle);
		assertFalse(condition);
	}
}