package test.kononov.shape.warehouse;

import static by.kononov.shape.data.impl.TriangleDataImpl.PERIMETER;
import static by.kononov.shape.data.impl.TriangleDataImpl.SQUARE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kononov.shape.data.impl.TriangleDataImpl;
import by.kononov.shape.entity.Dot;
import by.kononov.shape.entity.Triangle;
import by.kononov.shape.listener.TriangleListener;
import by.kononov.shape.listener.impl.TriangleListenerImpl;
import by.kononov.shape.repository.TriangleRepository;
import by.kononov.shape.warehouse.Warehouse;

public class WarehouseTest{
	TriangleRepository repository = TriangleRepository.getInstance();
	TriangleListener listener;
	Warehouse warehouse;
	Triangle triangle1;
	Triangle triangle2;
	Triangle triangle3;
	List<Triangle> expected;

	@BeforeClass
	public void setUp() {
		warehouse = Warehouse.getInstance();
		listener = new TriangleListenerImpl();
		triangle1 = new Triangle(1, new Dot("dotA", 1.0, 1.0), new Dot("dotB", 4.0, 1.0), new Dot("dotC", 1.0, 4.0));
		triangle1.addListener(listener);
		listener.update(triangle1);
		triangle2 = new Triangle(7, new Dot("dotA", 2.7, 5.0), new Dot("dotB", 0, 0), new Dot("dotC", 5.0, 2.7));
		triangle2.addListener(listener);
		listener.update(triangle2);
		triangle3 = new Triangle(20, new Dot("dotA", 3.0, 10.0), new Dot("dotB", 0, 0), new Dot("dotC", 10.0, 3.0));
		triangle3.addListener(listener);
		listener.update(triangle3);
		repository.addTriangle(triangle1);
		repository.addTriangle(triangle2);
		repository.addTriangle(triangle3);
		expected = new ArrayList<Triangle>();
	}

	@AfterClass
	public void tierDown() {
		repository.removeAll();
		warehouse = null;
		expected = null;
		triangle1 = null;
		triangle2 = null;
		triangle3 = null;
	}

	@Test(description = "receive square from warehouse by id")
	public void receiveSquareTest() {
		long triangleId = 1;
		double actual = warehouse.receiveSquare(triangleId);
		double expected = SQUARE.service(triangle1);
		assertEquals(actual, expected);
	}

	@Test(description = "receive perimeter from warehouse by id")
	public void receivePerimeterTest() {
		long shapeId = 1;
		double actual = warehouse.receivePerimeter(shapeId);
		double expected = PERIMETER.service(triangle1);
		assertEquals(actual, expected);
	}

	@Test(description = "unexpected id")
	public void receivePerimeterTestNegative() {
		long shapeId = 1;
		double actual = warehouse.receivePerimeter(shapeId);
		double expected = PERIMETER.service(triangle2);
		assertNotEquals(actual, expected);
	}

	@Test(description = "check the positive scenario after shape updating")
	public void updateTestPerimeterPositive() {
		long shapeId = 1;
		double expected = warehouse.receivePerimeter(shapeId);
		triangle1.setDotC(new Dot("dotC", 8.0, 8.0));
		repository.update(triangle1);
		double actual = warehouse.receivePerimeter(shapeId);
		assertNotEquals(actual, expected);
	}

	@Test(description = "check the positive scenario after shape updating")
	public void updateTestSquarePositive() {
		long shapeId = 1;
		double expected = warehouse.receivePerimeter(shapeId);
		triangle1.setDotC(new Dot("dotC", 8.0, 8.0));
		repository.update(triangle1);
		double actual = warehouse.receiveSquare(shapeId);
		assertNotEquals(actual, expected);
	}

	@Test(description = "check the positive scenario after shape updating")
	public void receiveParamListTest() {
		Map<Long, EnumMap<TriangleDataImpl, Double>> actual = warehouse.receiveParametersList();
		assertNotNull(actual);
	}

	@Test(description = "check the positive scenario after removing parameters")
	public void removeParamTest() {
		long shapeId = 7;
		boolean condition = warehouse.removeShapeParam(shapeId);
		assertTrue(condition);
	}
}
