package edu.ncsu.csc316.spell_checker.hash_table;

import edu.ncsu.csc316.spell_checker.io.TextReader;
import edu.ncsu.csc316.spell_checker.util.ArrayList;
import edu.ncsu.csc316.spell_checker.word.Word;

/**
 * Creates a hash table
 * @author John Ruisi
 *
 */
public class HashTable {

	/** table size */
	private static final int TABLE_SIZE = 36007;
	/** dictionary list */
	private ArrayList<Word> dictionary;
	/** hash table */
	private ArrayList<Word> table;
	/** size of table */
	private int size;
	
	/**
	 * Creates a hash table with given dictionary
	 * @param dictionary the dictionary
	 */
	public HashTable(String dictionary) {
		this.dictionary = TextReader.readDictionary(dictionary);
		size = 0;
		createTable();
	}
	
	/**
	 * Creates the hash table
	 */
	public void createTable() {
		
		this.table = new ArrayList<Word>(TABLE_SIZE);
		
		for (int i = 0; i < dictionary.size(); i++) {
			
			Word current = dictionary.get(i);
			int idx = compress(current.getCode());
			
			if (!table.add(current, idx)) {
				int newIdx = resolveCollision(idx);
				table.add(current, newIdx);
			}
			size++;
		}
	}
	
	/**
	 * Compresses the hash code to fit the table
	 * @param hashCode the strings hash code
	 * @return the compressed hash code
	 */
	public int compress(int hashCode) {
		int compress = (31 * hashCode + 7) % TABLE_SIZE;
		return Math.abs(compress);
	}
	
	/**
	 * Resolves collisions
	 * @param code the compressed hash code
	 * @return hash the new compressed hash code
	 */
	public int resolveCollision(int code) {
		int hash = Math.abs(code);
		int count = 0;
		while (table.get(hash) != null) {
			hash = Math.abs((code + (int) Math.pow(count, 2))) % TABLE_SIZE;
			count++;
		}
		return hash;
	}
	
	/**
	 * Gets the hash code of a word
	 * @param word the string
	 * @return hash the hash code of the string
	 */
	public int hashCode(String word) { //
		int hash = 0;
		for (int i = 0; i < word.length(); i++) {
			hash = (hash << 5) | (hash >>> 27);
			hash += (int) word.charAt(i);
		}
		return hash;
	}
	
	/**
	 * Gets a string from given index
	 * @param idx index to get from
	 * @return the string at the given index
	 */
	public String get(int idx) {
		if (table.get(idx) == null) {
			return null;
		}
		return table.get(idx).getWord();
	}
	
	/**
	 * Gets the word from the given index
	 * @param idx the index to search
	 * @return the word at the given index
	 */
	public Word getIdx(int idx) { //
		return table.get(idx);
	}
	
	/**
	 * Gets the size of the table
	 * @return size the size of the table
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Gets the table
	 * @return table the hash table
	 */
	public ArrayList<Word> getTable() {
		return table;
	}
	
	
}
