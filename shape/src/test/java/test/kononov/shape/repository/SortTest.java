package test.kononov.shape.repository;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kononov.shape.entity.Dot;
import by.kononov.shape.entity.Triangle;
import by.kononov.shape.repository.TriangleRepository;
import by.kononov.shape.sort.TriangleComparator;

public class SortTest{
	List<Triangle> expected;
	Triangle triangle1;
	Triangle triangle2;
	Triangle triangle3;
	TriangleComparator comparator;
	TriangleRepository repository = TriangleRepository.getInstance();

	@BeforeClass
	public void setUp() {
		triangle1 = new Triangle(20, new Dot("dotA", 1, 1), new Dot("dotB", 4, 1), new Dot("dotC", 1, 4));
		triangle2 = new Triangle(1, new Dot("dotA", 2.7, 15), new Dot("dotB", 0, 0), new Dot("dotC", 15, 2.7));
		triangle3 = new Triangle(7, new Dot("dotA", 3.0, 10), new Dot("dotB", 0, 0), new Dot("dotC", 10, 3.0));
		repository.addTriangle(triangle1);
		repository.addTriangle(triangle2);
		repository.addTriangle(triangle3);
		expected = new ArrayList<Triangle>();
	}

	@AfterClass
	public void tierDown() {
		repository.removeAll();
		triangle1 = null;
		triangle2 = null;
		triangle3 = null;
		expected = null;
	}

	@AfterMethod
	public void afterMethod() {
		expected.clear();
	}

	@Test(description = "sort elements of repository by id")
	public void sortById() {
		List<Triangle> expected = new ArrayList<>();
		expected.add(triangle2);
		expected.add(triangle3);
		expected.add(triangle1);
		comparator = TriangleComparator.BY_ID;
		repository.sort(comparator);
		List<Triangle> actual = repository.receiveAll();
		assertEquals(actual, expected);
	}

	@Test(description = "sort elements of repository by perimeter")
	public void sortByPerimeter() {
		List<Triangle> expected = new ArrayList<>();
		expected.add(triangle1);
		expected.add(triangle3);
		expected.add(triangle2);
		comparator = TriangleComparator.BY_PERIMETER;
		repository.sort(comparator);
		List<Triangle> actual = repository.receiveAll();
		assertEquals(actual, expected);
	}

	@Test(description = "sort elements of repository by square")
	public void sortBySquare() {
		List<Triangle> expected = new ArrayList<>();
		expected.add(triangle1);
		expected.add(triangle3);
		expected.add(triangle2);
		comparator = TriangleComparator.BY_SQUARE;
		repository.sort(comparator);
		List<Triangle> actual = repository.receiveAll();
		assertEquals(actual, expected);
	}

	@Test(description = "sort elements of repository by side AB")
	public void sortBySideAB() {
		List<Triangle> expected = new ArrayList<>();
		expected.add(triangle1);
		expected.add(triangle3);
		expected.add(triangle2);
		comparator = TriangleComparator.BY_SIDE_AB;
		repository.sort(comparator);
		List<Triangle> actual = repository.receiveAll();
		assertEquals(actual, expected);
	}
}
