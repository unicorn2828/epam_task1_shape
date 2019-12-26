package test.kononov.shape.producer;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kononov.shape.entity.Dot;
import by.kononov.shape.entity.Triangle;
import by.kononov.shape.producer.TriangleProducer;

public class ShapeProducerTest{
	private TriangleProducer shapeProducer;
	private List<Triangle> expectedList;
	private List<Triangle> actualList;
	private List<String> badDataList;
	private List<String> dataList;

	@BeforeClass
	public void setUp() {
		shapeProducer = TriangleProducer.getInstance();
		expectedList = new ArrayList<Triangle>();
		dataList = new ArrayList<String>();
		dataList.add("111 1.0 1.0 1.0 2.0 2.0 1.0");
		badDataList = new ArrayList<String>();
		badDataList.add("112 1.0 3.0 2.0 2.0 3.0 1.0");
		badDataList.add("113 1.0 1.0 1.0 1.0 1.0 1.0");
	}

	@AfterClass
	public void tierDown() {
		expectedList = null;
		actualList = null;
		badDataList = null;
		dataList = null;
	}

	@Test(description = "check production of correct shape")
	public void createTrianglesTestPositive() {
		actualList = shapeProducer.createTriangleList(dataList);
		expectedList.add(
				new Triangle(111, new Dot("dotA", 1.0, 1.0), new Dot("dotB", 1.0, 2.0), new Dot("dotC", 2.0, 1.0)));
		assertEquals(actualList, expectedList);
	}

	@Test(description = "check production of incorrect shape")
	public void createTrianglesTestNegative() {
		actualList = shapeProducer.createTriangleList(badDataList);
		assertEquals(actualList, expectedList);
	}

	@Test(description = "check production of correct shape")
	public void createTriangleTest() {
		Optional<Triangle> optional = shapeProducer.createTriangle(111, new Dot("dotA", 1.0, 1.0),
				new Dot("dotB", 1.0, 2.0), new Dot("dotC", 2.0, 1.0));
		Triangle actual = optional.get();
		Triangle expected =
				new Triangle(111, new Dot("dotA", 1.0, 1.0), new Dot("dotB", 1.0, 2.0), new Dot("dotC", 2.0, 1.0));
		assertEquals(actual, expected);
	}
}
