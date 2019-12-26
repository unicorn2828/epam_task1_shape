package test.kononov.shape.repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kononov.shape.entity.Dot;
import by.kononov.shape.entity.Triangle;
import by.kononov.shape.repository.TriangleRepository;

public class TriangleRepositoryTest{
	TriangleRepository repository = TriangleRepository.getInstance();
	Triangle triangle1;
	Triangle triangle2;
	Triangle triangle3;
	List<Triangle> expected;

	@BeforeClass
	public void setUp() {
		triangle1 = new Triangle(1, new Dot("dotA", 1, 1), new Dot("dotB", 3.0, 1), new Dot("dotC", 1, 3.0));
		triangle2 = new Triangle(7, new Dot("dotA", 2.7, 10), new Dot("dotB", 0, 0), new Dot("dotC", 10, 2.7));
		triangle3 = new Triangle(20, new Dot("dotA", 2.7, 10), new Dot("dotB", 1, 1), new Dot("dotC", 10, 2.7));
		repository.addTriangle(triangle1);
		repository.addTriangle(triangle2);
		repository.addTriangle(triangle3);
		expected = new ArrayList<>();
		expected.add(triangle1);
		expected.add(triangle2);
		expected.add(triangle3);

	}

	@AfterClass
	public void tierDown() {
		repository.removeAll();
		triangle1 = null;
		triangle2 = null;
		triangle3 = null;
		expected = null;
	}

	@Test(description = "check 'null' scenario of receiving objects from repository")
	public void receiveAllTestNotNull() {
		List<Triangle> actual = repository.receiveAll();
		assertNotNull(actual);
	}

	@Test(description = "check the positive scenario of receiving objects from repository")
	public void receiveAllTest() {
		List<Triangle> actual = repository.receiveAll();
		assertEquals(actual, expected);
	}

	@Test(description = "check the positive scenario of updating object in repository")
	public void updateTestPositive() {
		triangle2.setDotC(new Dot("dotC", 8.8, 8.8));
		boolean condition = repository.update(triangle2);
		assertTrue(condition);
	}

	@Test(description = "check the positive scenario of updating object in repository")
	public void updateTestNegative() {
		boolean condition = repository
				.update(new Triangle(122, new Dot("dotA", 1, 1), new Dot("dotB", 3.0, 1), new Dot("dotC", 1, 3.0)));
		assertFalse(condition);
	}
}
