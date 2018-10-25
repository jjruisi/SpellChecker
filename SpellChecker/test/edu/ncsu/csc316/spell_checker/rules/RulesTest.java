package edu.ncsu.csc316.spell_checker.rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the rules class
 * @author John Ruisi
 *
 */
public class RulesTest {

	/**
	 * Tests each individual rule
	 */
	@Test
	public void testRules() {
		Rules r = new Rules();
		assertNotNull(r);
		
		Rules.lowerCase("Test");
		Rules.possession("Test's");
		Rules.plurality1("Tests");
		Rules.plurality2("Testes");
		Rules.pastTense1("Testd");
		Rules.pastTense2("Tested");
		Rules.occupation1("Testr");
		Rules.occupation2("Tester");
		Rules.gerund1("Testing");
		Rules.gerund2("Testing");
		Rules.adverb("Testly");
		
	}

}
