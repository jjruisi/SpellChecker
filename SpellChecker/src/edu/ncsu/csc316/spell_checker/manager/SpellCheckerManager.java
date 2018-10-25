package edu.ncsu.csc316.spell_checker.manager;

import edu.ncsu.csc316.spell_checker.hash_table.HashTable;
import edu.ncsu.csc316.spell_checker.io.TextReader;
import edu.ncsu.csc316.spell_checker.rules.Rules;
import edu.ncsu.csc316.spell_checker.util.ArrayList;
import edu.ncsu.csc316.spell_checker.word.Word;

/**
 * Spell checker manager
 * @author John Ruisi
 *
 */
public class SpellCheckerManager {
	
	/** table size */
	private static final int TABLE_SIZE = 36007;
	/** hash table */
	private HashTable hashTable;
	/** input */
	private ArrayList<String> input;
	/** mispelled list */
	private ArrayList<String> mispelled;
	
	
	/**
	 * Constructs a new Spell Checker with the given dictionary
	 * 
	 * @param pathToDictionary the path to the dictionary
	 */
	 public SpellCheckerManager(String pathToDictionary) {
	 	hashTable = new HashTable(pathToDictionary);
	 }	
	 
	/**
	 * Returns a string representation of the list of misspelled
	 * words (in alphabetical order, case insensitive) in the input file.
	 * The string representation should be in the format:
	 * ArrayBasedList[a, b, c]
	 * 
	 * @param pathToFile the path to the file to be spell-checked
	 * @return a string representation of the list of misspelled words
	 */
	public String spellCheck(String pathToFile) {
		
		input = TextReader.readFile(pathToFile);
		mispelled = check();
		insertionSort();
	
		return getList();
	}
	
	/**
	 * Checks the rules to alter words and search them
	 * @return list the list of mispelled words
	 */
	public ArrayList<String> check() {
		
		//List of mispelled words
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < input.size(); i++) {
			
			StringBuilder word = new StringBuilder(input.get(i));
			
			//Standard search
			if (searchWord(word.toString())) {
				continue;
			}
			//Capitalizaiton rule
			if (Rules.lowerCase(word.toString()) != null) {
				
				String rule1 = Rules.lowerCase(word.toString());
				
				if (searchWord(rule1)) {
					continue;
				}
				
				word = new StringBuilder(rule1);
			}
			//Possession rule
			if (Rules.possession(word.toString()) != null) {
				
				String rule2 = Rules.possession(word.toString());
				
				if (searchWord(rule2)) {
					continue;
				}
				
				word = new StringBuilder(rule2);
			}
			
			boolean found = false;
			boolean used = false;
			
			while (!found) {
				
				int count = 0;
				
				//Plurality rule
				if (Rules.plurality1(word.toString()) != null || Rules.plurality2(word.toString()) != null) {
					
					String plural1 = Rules.plurality1(word.toString());
					String plural2 = Rules.plurality2(word.toString());
					
					if (searchWord(plural1) || searchWord(plural2)) {
						found = true;
						break;
					}
					
					word = new StringBuilder(plural1);
					count++;
				}	
				//Past-Tense rule
				if ((Rules.pastTense1(word.toString()) != null || Rules.pastTense2(word.toString()) != null) && !used) {
					
					String past1 = Rules.pastTense1(word.toString());
					String past2 = Rules.pastTense2(word.toString());
					
					if (searchWord(past1) || searchWord(past2)) {
						found = true;
						break;
					}
					
					if (past2 != null) {
						word = new StringBuilder(past2);
					} else {
						word = new StringBuilder(past1);
					}
					
					used = true;
					count++;
				}	
				//Occupation rule
				if (Rules.occupation1(word.toString()) != null || Rules.occupation2(word.toString()) != null) {
					
					String occ1 = Rules.occupation1(word.toString());
					String occ2 = Rules.occupation2(word.toString());
					
					if (searchWord(occ1) || searchWord(occ2)) {
						found = true;
						break;
					}
					
					if (occ2 != null) {
						word = new StringBuilder(occ2);
					} else {
						word = new StringBuilder(occ1);
					}
					
					count++;
				}	
				//Gerund rule
				if (Rules.gerund1(word.toString()) != null || Rules.gerund2(word.toString()) != null) {
					
					String gerund1 = Rules.gerund1(word.toString());
					String gerund2 = Rules.gerund2(word.toString());
					
					if (searchWord(gerund1) || searchWord(gerund2)) {
						found = true;
						break;
					}
					
					word = new StringBuilder(gerund1);
					count++;
				}	
				//Adverb rule
				if (Rules.adverb(word.toString()) != null) {
					
					String adverb = Rules.adverb(word.toString());
					
					if (searchWord(adverb)) {
						found = true;
						break;
					}
					
					word = new StringBuilder(adverb);
					count++;
				}
				
				if (count == 0) {
					break;
				}
			}
			
			if (found) {
				continue;
			}
			
			//Word is mispelled
			boolean contains = false;
			
			//Dont add if already in the list
			for (int j = 0; j < list.size(); j++) {
				if (input.get(i).equals(list.get(j))) {
					contains = true;
				}
			}
			
			if (contains) {
				continue;
			} else {
				list.add(input.get(i));
			}
			
		}
		return list;
	}
	
	/**
	 * Seaches for a word in the hash table
	 * @param w the word to search
	 * @return true if the word is found
	 */
	public boolean searchWord(String w) {
		
		if (w == null) {
			return false;
		}
		
		Word word = new Word(w);
		int hashCode = hashTable.compress(word.getCode());
		
		if (hashTable.get(hashCode) != null && hashTable.get(hashCode).equals(word.getWord())) {
			return true;
			
		} else {
			
			int count = 0;
			int newCode = resolveCollision(hashCode, count);
			
			while (hashTable.get(newCode) != null) {
				
				if (hashTable.get(newCode).equals(word.getWord())) {
					return true;
				}
				
				count++;
				newCode = resolveCollision(hashCode, count);
			}
		}
		return false;
	}
	
	/**
	 * Searches the next index if word does not match at its hash code index
	 * @param code the old hash code
	 * @param i the amount of times the resolve collision has ran
	 * @return hash the new hash code to search at
	 */
	public int resolveCollision(int code, int i) {
		int hash = Math.abs(code);
		hash = Math.abs((code + (int) Math.pow(i, 2))) % TABLE_SIZE;
		return hash;
	}
	
	/**
	 * Gets the mispelled list in its proper syntax
	 * @return the list
	 */
	public String getList() {
		
		StringBuilder a = new StringBuilder();
		a.append("ArrayBasedList[");
		
		for (int i = 0; i < mispelled.size(); i++) {
			
			if (i == mispelled.size() - 1) {
				a.append(mispelled.get(i));
			} else {
				a.append(mispelled.get(i) + ", ");
			}
		}
		
		a.append("]");
		return a.toString();
	}
	
	/**
	 * Sorts the mispelled list
	 */
	public void insertionSort() {
		
		for (int i = 1; i < mispelled.size(); i++) {
			
			String key = mispelled.get(i);
			
			for (int j = i - 1; j >= 0; j--) {
				
				if (key.toLowerCase().compareTo(mispelled.get(j).toLowerCase()) < 0) {
					
					mispelled.set(j + 1, mispelled.get(j));
					
					if (j == 0) {
						mispelled.set(0, key);
					}
				} else {
					mispelled.set(j + 1, key);
					break;
				}
			}
		}
	}
}
