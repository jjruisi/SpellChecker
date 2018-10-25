package edu.ncsu.csc316.spell_checker.word;

/**
 * Creates a word object
 * @author John Ruisi
 *
 */
public class Word {

	/** the actual word */
	private String word;
	/** the hash code of the word */
	private int code;
	
	/**
	 * Creates a word given a string
	 * @param word the string to create the word with
	 */
	public Word (String word) {
		this.word = word;
		this.code = hashCode(word);
	}
	
	/**
	 * Gets the hash code of the word
	 * @param word the word to get the hash code from
	 * @return hash the hash code
	 */
	public int hashCode(String word) {
		int hash = 0;
		for (int i = 0; i < word.length(); i++) {
			hash = (hash << 5) | (hash >>> 27);
			hash += (int) word.charAt(i);
		}
		return hash;
	}
	
	/**
	 * Gets the word
	 * @return word the word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Gets the code
	 * @return code the hash code
	 */
	public int getCode() {
		return code;
	}
}
