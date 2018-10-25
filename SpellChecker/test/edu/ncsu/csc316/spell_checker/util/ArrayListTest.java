package edu.ncsu.csc316.spell_checker.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the array list
 * @author John Ruisi
 *
 */
public class ArrayListTest {

	/**
	 * Tests the constructor
	 */
	@Test
	public void testArrayList() {
		ArrayList<String> a = new ArrayList<String>();
		assertEquals(a.size(), 0);
	}

	/**
	 * Tests the add method
	 */
	@Test
	public void testAdd() {
		ArrayList<String> a = new ArrayList<String>();
		
		a.add("0");
		a.add("1");
		a.add("2");
		a.add("3");
		a.add("4");
		a.add("5");
		a.add("6");
		a.add("7");
		a.add("8");
		a.add("9");
		a.add("10");
		a.set(0, "2");
		
		assertEquals(a.size(), 11);
		assertEquals(a.entries(), 0);
	}
	
	/**
	 * Tests the set length array
	 */
	@Test
	public void testList2() {
		ArrayList<String> a = new ArrayList<String>(100);
		assertNotNull(a);
		
		assertTrue(a.add("tests", 0));
		assertFalse(a.add("tests", 0));
		assertNull(a.get(5));
		assertEquals(a.get(0), "tests");
		
		try {
			a.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(e.getMessage(), "Invalid Index");
		}
	}
	
}
