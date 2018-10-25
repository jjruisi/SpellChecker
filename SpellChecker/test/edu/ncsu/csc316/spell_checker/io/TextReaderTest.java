package edu.ncsu.csc316.spell_checker.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.spell_checker.util.ArrayList;
import edu.ncsu.csc316.spell_checker.word.Word;

/**
 * Tests the I/O of the program
 * @author John Ruisi
 *
 */
public class TextReaderTest {

	/**
	 * Tests the text reader
	 */
	@Test
	public void testReader() {
		TextReader a = new TextReader();
		assertNotNull(a);
		
		ArrayList<String> list = TextReader.readFile("input/small_sample.txt");
		assertNotNull(list);
	}
	
	/**
	 * Tests the dictionary reader
	 */
	@Test
	public void testDictionary() {
		ArrayList<Word> d = TextReader.readDictionary("input/dictionary.txt");
		assertNotNull(d);
	}
	
	/**
	 * Tests FNF elements of both methods
	 */
	@Test
	public void testFNF() {
		try {
			TextReader.readFile("asdfasdfasdfasdf.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "FNF");
		}
		
		try {
			TextReader.readDictionary("asdfasdfasdfasdf.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "FNF");
		}
	}

}
