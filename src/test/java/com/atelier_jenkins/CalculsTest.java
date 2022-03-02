package test.java.com.atelier_jenkins;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.atelier_jenkins.Calculs;

/**
 * 
 */

/**
 * @author test
 * 
 */
class CalculsTest {

	private Calculs c1 = null;
	private Calculs c2 = null;
	private Calculs c3 = null;
	
	/**
	 * Initialise les valeurs avant chaque test 
	 */
	@BeforeEach // D�clencher cette m�thode avant l'ex�cution
	void setUp() throws Exception 
	{
		c1 = new Calculs(1,2);
		c2 = new Calculs(10,20);
		c3 = new Calculs(400,200);
	}

	

	/**
	 * Test method for {@link Calculs#multiplier()}.
	 */
	@Test
	void testMultiplier() 
	{
		if(c1.multiplier() != 2)
		{
			fail("Methode multiplier non conforme 2*1=2 ne fonctionne pas.");
		}
		
		// Est ce que (2 == 42) ? non donc : test en Erreur
		assertEquals(c1.multiplier(), 2);
		
	}

	/**
	 * Test method for {@link Calculs#additionner()}.
	 */
	@Test
	void testAdditionner() {
		if(c2.additionner() != 30)
		{
			fail("Methode addition non conforme | ne fonctionne pas.");
		}
	}
	

	/**
	 * Test method for {@link Calculs#diviser()}.
	 */
	@Test
	void testDiviser() {
		if(c3.diviser() != 2)
	{
		fail("Methode division non conforme 2*1=2 ne fonctionne pas.");
	}
	}

	/**
	 * Test method for {@link Calculs#soustraire()}.
	 */
	/*@Test
	void testSoustraire() {
		fail("Not yet implemented");
	}*/

}
