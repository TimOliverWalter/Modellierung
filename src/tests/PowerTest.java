package tests;

import strategy.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PowerTest {
	
	double eps = Double.NEGATIVE_INFINITY;
	
	Power algorithmus1 = new Power();
	Power algorithmus2 = new Power();
	Power algorithmus3 = new Power();
	Power algorithmus4 = new Power();

	/**
	 * Test zum Lösen des Eigenwerts mithilfe des Karp-Algorithmus (Beispiel 1)
	 */	
	@Test
	void testLoesenEigenwert1() { 
		
		double[][] temp1 = {{eps, eps, eps, 3},{5, 2, eps, eps},{eps, 1, eps, eps},{eps ,eps , 7, eps}};
		RMaxMatrix temp2 = new RMaxMatrix(temp1);
		RMaxZahl act = algorithmus1.loesenEigenwert(temp2);
		RMaxZahl exp = new RMaxZahl(4);
		assertEquals(act, exp);
	}
	
	/**
	 * Test zum Lösen des Eigenwerts mithilfe des Karp-Algorithmus (Beispiel 2)
	 */	
	@Test
	void testLoesenEigenwert2() { 
		double[][] temp1 = {{3, 7},{2, 4}};
		RMaxMatrix temp2 = new RMaxMatrix(temp1);
		RMaxZahl act = algorithmus1.loesenEigenwert(temp2);
		RMaxZahl exp = new RMaxZahl(4.5);
		assertEquals(act, exp);
	}
	
	/**
	 * Test zum Lösen des Eigenwerts mithilfe des Karp-Algorithmus (Beispiel 3)
	 */	
	@Test
	void testLoesenEigenwert3() { 
		double[][] temp1 = {{6, 7, eps, eps},{1, 4, eps, 6},{eps, 2, 4, 5},{eps, eps, 3, 6}};
		RMaxMatrix temp2 = new RMaxMatrix(temp1);
		RMaxZahl act = algorithmus1.loesenEigenwert(temp2);
		RMaxZahl exp = new RMaxZahl(6);
		assertEquals(act, exp);
	}
	
	/**
	 * Test zum Lösen des Eigenwerts mithilfe des Karp-Algorithmus (Beispiel 4)
	 */	
	@Test
	void testLoesenEigenwert4() { 
		double[][] temp1 = {{2, eps, 3, eps},{2, eps, 3, eps},{eps, 2, eps, 1},{eps, 2, eps, 1}};
		RMaxMatrix temp2 = new RMaxMatrix(temp1);
		RMaxZahl act = algorithmus1.loesenEigenwert(temp2);
		RMaxZahl exp = new RMaxZahl(2.5);
		assertEquals(act, exp);
		
	}
}
