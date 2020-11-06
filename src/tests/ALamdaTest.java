package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import strategy.ALambda;
import strategy.RMaxMatrix;
import strategy.RMaxZahl;

class ALambdaTest {

	ALambda algorithmus = new ALambda();
	
	/**
	 * Test zum lösen des Eigenvektors mit Hilfe des ALambda-Algorithmus
	 */
	@Test
	void testLoeseEigenvektor() {
		double eps = Double.NEGATIVE_INFINITY;
		double[][] temp1 = {{eps, eps, eps, 3}, {5, 2, eps, eps}, {eps, 1, eps, eps}, {eps, eps, 7, eps}};
		
		RMaxMatrix a = new RMaxMatrix(temp1);
		
		RMaxZahl act = algorithmus.loesenEigenvektor(a).getRMaxKomponente(3);
		
		RMaxZahl exp = new RMaxZahl(1);
		
		assertEquals(exp, act);
	}

}
