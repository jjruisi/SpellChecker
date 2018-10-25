package edu.ncsu.csc316.spell_checker.rules;

/**
 * Rules for spell checking
 * @author John Ruisi
 *
 */
public class Rules {

	/**
	 * Check for lower case
	 * @param word the word to check
	 * @return the spellchecked word
	 */
	public static String lowerCase(String word) {
		
		StringBuilder s = new StringBuilder(word);
		
		if (Character.isUpperCase(s.charAt(0))) {
			s.setCharAt(0, Character.toLowerCase(s.charAt(0)));
			return s.toString();
		} else {
			return null;
		}
	}
	
	/**
	 * Check for possesion
	 * @param word the word to check
	 * @return the spellchecked word
	 */
	public static String possession(String word) {
		
		StringBuilder s = new StringBuilder(word);
		
		if (s.length() <= 2) {
			return null;
		}
		
		String s1 = s.substring(s.length() - 2, s.length());
		
		if (s1.equals("'s")) {
			return s.substring(0, s.length() - 2);
		} else {
			return null;
		}
	}
	
	/**
	 * Check for plurality case 1
	 * @param word the word to check
	 * @return the spellchecked word
	 */
	public static String plurality1(String word) {
		
		StringBuilder s = new StringBuilder(word);
		
		if (s.length() <= 1) {
			return null;
		}
		
		String s1 = s.substring(s.length() - 1, s.length());
		
		if (s1.equals("s")) {
			return s.substring(0, s.length() - 1);
		} else {
			return null;
		}
		
	}
	
	/**
	 * Check for plurality case 2
	 * @param word the word to check
	 * @return the spellchecked word
	 */
	public static String plurality2(String word) {
		
		StringBuilder s = new StringBuilder(word);
		
		if (s.length() <= 2) {
			return null;
		}
		
		String s1 = s.substring(s.length() - 2, s.length());
		
		if (s1.equals("es")) {
			return s.substring(0, s.length() - 2);
		} else {
			return null;
		}
		
	}
	
	/**
	 * Check for past tense case 1
	 * @param word the word to check
	 * @return the spellchecked word
	 */
	public static String pastTense1(String word) {
	
		StringBuilder s = new StringBuilder(word);
		
		if (s.length() <= 1) {
			return null;
		}
		
		String s1 = s.substring(s.length() - 1, s.length());
		
		if (s1.equals("d")) {
			return s.substring(0, s.length() - 1);
		} else {
			return null;
		}
		
	}
	
	/**
	 * Check for past tense case 2
	 * @param word the word to check
	 * @return the spellchecked word
	 */
	public static String pastTense2(String word) {
		
		StringBuilder s = new StringBuilder(word);
		
		if (s.length() <= 2) {
			return null;
		}
		
		String s1 = s.substring(s.length() - 2, s.length());
		
		if (s1.equals("ed")) {
			return s.substring(0, s.length() - 2);
		} else {
			return null;
		}
		
	}
	
	/**
	 * Check for occupation case 1
	 * @param word the word to check
	 * @return the spellchecked word
	 */
	public static String occupation1(String word) {
		
		StringBuilder s = new StringBuilder(word);
		
		if (s.length() <= 1) {
			return null;
		}
		
		String s1 = s.substring(s.length() - 1, s.length());
		
		if (s1.equals("r")) {
			return s.substring(0, s.length() - 1);
		} else {
			return null;
		}
		
	}
	
	/**
	 * Check for occupation case 2
	 * @param word the word to check
	 * @return the spellchecked word
	 */
	public static String occupation2(String word) {
		
		StringBuilder s = new StringBuilder(word);
		
		if (s.length() <= 2) {
			return null;
		}
		
		String s1 = s.substring(s.length() - 2, s.length());
		
		if (s1.equals("er")) {
			return s.substring(0, s.length() - 2);
		} else {
			return null;
		}
		
	}
	
	/**
	 * Check for gerund case 1
	 * @param word the word to check
	 * @return the spellchecked word
	 */
	public static String gerund1(String word) {
		
		StringBuilder s = new StringBuilder(word);
		
		if (s.length() <= 3) {
			return null;
		}
		
		String s1 = s.substring(s.length() - 3, s.length());
		
		if (s1.equals("ing")) {
			return s.substring(0, s.length() - 3);
		} else {
			return null;
		}
	}
	
	/**
	 * Check for ggerund case 2
	 * @param word the word to check
	 * @return the spellchecked word
	 */
	public static String gerund2(String word) {
		
		StringBuilder s = new StringBuilder(word);
		
		if (s.length() <= 3) {
			return null;
		}
		
		String s1 = s.substring(s.length() - 3, s.length());
		
		if (s1.equals("ing")) {
			s.delete(s.length() - 3, s.length());
			s.append("e");
			return s.toString();
		} else {
			return null;
		}
	}
	
	/**
	 * Check for adverbs
	 * @param word the word to check
	 * @return the spellchecked word
	 */
	public static String adverb(String word) {

		StringBuilder s = new StringBuilder(word);
		
		if (s.length() <= 2) {
			return null;
		}
		
		String s1 = s.substring(s.length() - 2, s.length());
		
		if (s1.equals("ly")) {
			return s.substring(0, s.length() - 2);
		} else {
			return null;
		}
		
	}
}
