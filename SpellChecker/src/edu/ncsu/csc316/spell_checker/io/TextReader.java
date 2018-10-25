package edu.ncsu.csc316.spell_checker.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.spell_checker.util.ArrayList;
import edu.ncsu.csc316.spell_checker.word.Word;

/**
 * Reads text from a file and stores it in an array list
 * @author John Ruisi
 *
 */
public class TextReader {

	/**
	 * Reads strings of user input
	 * @param fileName the users file
	 * @return text the list of strings the input contained
	 */
	public static ArrayList<String> readFile(String fileName) {
		
		Scanner scan;
		try {
			scan = new Scanner(new FileInputStream(fileName), "UTF8");
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("FNF");
		}
		
		ArrayList<String> text = new ArrayList<String>();
		
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			Scanner s = new Scanner(line);
			
			while (s.hasNext()) {
				text.add(s.next());
			}
			
			s.close();
		}
		
		scan.close();
		return text;
	}
	
	/**
	 * Reads in a list of dictionary words
	 * @param fileName the file location of the dictionary
	 * @return text the list of words the dictionary contained
	 */
	public static ArrayList<Word> readDictionary(String fileName) {
		
		Scanner scan;
		try {
			scan = new Scanner(new FileInputStream(fileName), "UTF8");
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("FNF");
		}
		
		ArrayList<Word> text = new ArrayList<Word>();
		
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			Scanner s = new Scanner(line);
			
			while (s.hasNext()) {
				Word w = new Word(s.next());
				text.add(w);
			}
			
			s.close();
		}
		
		scan.close();
		return text;
	}
}
