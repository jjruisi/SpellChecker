package edu.ncsu.csc316.spell_checker.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the manager class
 * @author John Ruisi
 *
 */
public class SpellCheckerManagerTest {

	/**
	 * Tests the whole program with different user inputs
	 */
	@Test
	public void test() {
		SpellCheckerManager m = new SpellCheckerManager("input/dictionary.txt");
		String s = m.spellCheck("input/small_sample.txt");
		String s1 = m.spellCheck("input/jumping.txt");
		System.out.println(s);
		System.out.println();
		System.out.println(s1);
		assertNotNull(s);
		assertNotNull(s1);
	}
}
