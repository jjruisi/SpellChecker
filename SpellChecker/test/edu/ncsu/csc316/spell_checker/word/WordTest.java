package edu.ncsu.csc316.spell_checker.word;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the word class
 * @author John Ruisi
 *
 */
public class WordTest {

	/**
	 * Tests the word class
	 */
	@Test
	public void test() {
		Word w = new Word("String");
		int code = w.getCode();
		String s = w.getWord();
		assertEquals(s, "String");
		assertNotNull(code);
	}

}
