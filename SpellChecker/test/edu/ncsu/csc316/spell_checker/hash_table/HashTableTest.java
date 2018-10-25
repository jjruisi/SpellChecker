package edu.ncsu.csc316.spell_checker.hash_table;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.spell_checker.word.Word;

/**
 * Test hash table
 * @author John Ruisi
 *
 */
public class HashTableTest {

	/**
	 * Tests the hash table
	 */
	@Test
	public void testTable() {
		HashTable t = new HashTable("input/dictionary.txt");
		
		for (int i = 0; i < t.getSize(); i++) {
			
			if (t.getTable().get(i) == null) {
				continue;
			}
		}
		assertNotNull(t);
		
		int i = t.hashCode("the");
		assertNotNull(i);
		
		Word w = t.getIdx(1);
		assertNull(w);
	}

}
