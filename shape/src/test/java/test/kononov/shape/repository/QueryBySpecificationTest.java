package test.kononov.shape.repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kononov.shape.entity.Dot;
import by.kononov.shape.entity.Triangle;
import by.kononov.shape.repository.TriangleRepository;
import by.kononov.shape.specification.TriangleSpecification;
import by.kononov.shape.specification.impl.SelectById;
import by.kononov.shape.specification.impl.SelectBySquare;

public class QueryBySpecificationTest{
	Triangle triangle1;
	Triangle triangle2;
	Triangle triangle3;
	List<Triangle> triangleList;
	Optional<List<Triangle>> expected;
	TriangleRepository repository = TriangleRepository.getInstance();

	@BeforeClass
	public void setUp() {
		triangleList = new ArrayList<Triangle>();
		triangle1 = new Triangle(1, new Dot("dotA", 1, 1), new Dot("dotB", 4, 1), new Dot("dotC", 1, 4));
		triangle2 = new Triangle(7, new Dot("dotA", 2.7, 5), new Dot("dotB", 0, 0), new Dot("dotC", 5, 2.7));
		triangle3 = new Triangle(20, new Dot("dotA", Math.PI, 10), new Dot("dotB", 0, 0), new Dot("dotC", 10, Math.PI));
		repository.addTriangle(triangle1);
		repository.addTriangle(triangle2);
		repository.addTriangle(triangle3);
	}

	@AfterClass
	public void tierDown() {
		repository.removeAll();
		triangleList = null;
		expected = null;
		triangle1 = null;
		triangle2 = null;
		triangle3 = null;
	}

	@AfterMethod
	public void afterMethod() {
		triangleList.clear();
	}

	@Test(description = "check searching by cpecification in repository")
	public void queryByIdPositive() {
		TriangleSpecification specification = new SelectById(2, 15);
		Optional<List<Triangle>> actual = repository.query(specification);
		triangleList.add(triangle2);
		expected = Optional.of(triangleList);
		assertEquals(actual, expected);
	}

	@Test(description = "check searching by specification in repository")
	public void queryByIdNegative() {
		TriangleSpecification specification = new SelectById(2, 15);
		Optional<List<Triangle>> actual = repository.query(specification);
		triangleList.add(triangle1);
		expected = Optional.of(triangleList);
		assertNotEquals(actual, expected);
	}

	@Test(description = "check searching by cpecification in repository")
	public void queryBySquarePositive() {
		TriangleSpecification specification = new SelectBySquare(5, 15);
		Optional<List<Triangle>> actual = repository.query(specification);
		triangleList.add(triangle2);
		expected = Optional.of(triangleList);
		assertEquals(actual, expected);
	}

	@Test(description = "check searching by cpecification in repository")
	public void queryByPerimeterPositive() {
		TriangleSpecification specification = new SelectBySquare(5, 15);
		Optional<List<Triangle>> actual = repository.query(specification);
		triangleList.add(triangle2);
		expected = Optional.of(triangleList);
		assertEquals(actual, expected);
	}
}
