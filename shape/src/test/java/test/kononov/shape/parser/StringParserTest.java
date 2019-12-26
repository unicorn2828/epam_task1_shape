package test.kononov.shape.parser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kononov.shape.entity.Dot;
import by.kononov.shape.parser.StringParser;

public class StringParserTest{
	private StringParser stringParser;
	private List<String> shapesDataList;
	private List<String> expectedList;

	@BeforeClass
	public void setUp() {
		stringParser = new StringParser();
		expectedList = new ArrayList<String>();
		expectedList.add("111 1.0 1.0 1.0 2.0 2.0 1.0");
		expectedList.add("115 1.11 1.12 1.13 2.14 2.15 222.168");
		shapesDataList = new ArrayList<String>();
		shapesDataList.add("111 1.0 1.0 1.0 2.0 2.0 1.0");
		shapesDataList.add("112 1,5 z1.5 1.0 1.01.0 3.0");
		shapesDataList.add(" ");
		shapesDataList.add("1g3 3.0 1.0 2.4 ");
		shapesDataList.add("116 this is some str*/$nge string");
		shapesDataList.add("888 1.3 5.9 1.0 1..0");
		shapesDataList.add("1.0 1.0 1.0 2.0 2.0 1.0");
		shapesDataList.add("115 1.11 1.12 1.13 2.14 2.15 222.168");
		shapesDataList.add("119 1.0 -1.0 -1.0 1.0");
	}

	@AfterClass
	public void tierDown() {
		stringParser = null;
		expectedList = null;
		shapesDataList = null;
	}

	@Test(description = "check the strings")
	public void checkStringTest() {
		List<String> actualList = stringParser.checkString(shapesDataList);
		assertEquals(actualList, expectedList);
	}

	@Test(description = "check parser of string")
	public void parseStringTest() {
		String testString = expectedList.get(0);
		Map<String, Object> actual = stringParser.parseString(testString);
		Map<String, Object> expected = new HashMap<>();
		expected.put("triangleId", (long) 111);
		expected.put("dotA", new Dot("dotA", 1.0, 1.0));
		expected.put("dotB", new Dot("dotB", 1.0, 2.0));
		expected.put("dotC", new Dot("dotC", 2.0, 1.0));
		assertEquals(actual, expected);
	}

	@Test(description = "check parser of string")
	public void parseStringTestNegative() {
		String testString = expectedList.get(0);
		Map<String, Object> actual = stringParser.parseString(testString);
		Map<String, Object> expected = new HashMap<>();
		expected.put("triangleId", (long) 111);
		assertNotEquals(actual, expected);
	}
}
