package edu.ncsu.csc316.spell_checker.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import edu.ncsu.csc316.spell_checker.manager.SpellCheckerManager;

/**
 * Creates GUI
 * @author John Ruisi
 *
 */
public class ManagerGUI extends JFrame {


	/** serial version uid */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets user input and creates spell checker manager
	 * @param args the input
	 * @throws FileNotFoundException if file is not found
	 */
	public static void main(String args[]) throws FileNotFoundException {
		
		SpellCheckerManager sm = null;
		String input = null;
		
		try {
			if (args.length == 2) {
				sm = new SpellCheckerManager(args[0]);
				input = args[1];
    		} else if (args.length == 0) {
    			throw new IllegalArgumentException("No file given");
    		} else {
    			throw new IllegalArgumentException("Please only enter two files");
    		}
			
		} catch (IllegalArgumentException e) {	
			JOptionPane.showMessageDialog(null, e.getMessage(), "File errors", JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}
		
		ManagerGUI mg = new ManagerGUI(sm, input);
		mg.setVisible(true);
		
		
	}
	
	/**
	 * Creates the UI
	 * @param sm the spell checker manager
	 * @param input the users input
	 */
	public ManagerGUI(SpellCheckerManager sm, String input) {
		
		setSize(400, 100);
		setLocation(100, 100);
		setTitle("Manager Manager");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		String output = null;
		
		try {
			output = sm.spellCheck(input);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "File errors", JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}
		
		JLabel result = new JLabel(output);
		c.add(result, BorderLayout.CENTER);
	}
}
