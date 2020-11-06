package tests;

import strategy.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KarpTest {
	
	double eps = Double.NEGATIVE_INFINITY;
	
	Karp algorithmus1 = new Karp();
	Karp algorithmus2 = new Karp();
	Karp algorithmus3 = new Karp();
	Karp algorithmus4 = new Karp();
	
	
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

	/**
	 * Test des Iteriervorgangs beim Karp-Algorithmus
	 */	
	@Test
	void testIterieren1() { 
		
		double[][] temp1 = {{eps, eps, eps, 3},{5, 2, eps, eps},{eps, 1, eps, eps},{eps ,eps , 7, eps}};
		RMaxMatrix temp2 = new RMaxMatrix(temp1); 
		double[] startvektor = {0, eps, eps, eps};
		RMaxVektor temp3 = new RMaxVektor(startvektor);
		RMaxVektor act = algorithmus2.iterieren(temp2, temp3);
		double[] temp4 = {eps,5,eps,eps};
		RMaxVektor exp = new RMaxVektor(temp4);
		assertEquals(act, exp);
	}

	/**
	 * Test der Minimumbestimmung im Karp-Algorithmus (Beispiel 1)
	 */	
	@Test
	void testMinimum1() { 
		RMaxZahl[] temp1 = {new RMaxZahl(5), new RMaxZahl(2), new RMaxZahl(6), new RMaxZahl(7)};
		RMaxZahl act = algorithmus3.minimum(temp1);
		RMaxZahl exp = new RMaxZahl(2);
		assertEquals(act, exp);
	}
	
	/**
	 * Test der Minimumbestimmung im Karp-Algorithmus (Beispiel 2)
	 */	
	@Test
	void testMinimum2() { 
		RMaxZahl[] temp1 = {new RMaxZahl(5), new RMaxZahl(-2), new RMaxZahl(6), new RMaxZahl(-7)};
		RMaxZahl act = algorithmus3.minimum(temp1);
		RMaxZahl exp = new RMaxZahl(-7);
		assertEquals(act, exp);
	}
	
	/**
	 * Test der Minimumbestimmung im Karp-Algorithmus (Beispiel 3)
	 */	
	@Test
	void testMinimum3() { 
		RMaxZahl[] temp1 = {new RMaxZahl(5), new RMaxZahl(-2), new RMaxZahl(Double.NEGATIVE_INFINITY), new RMaxZahl(-7)};
		RMaxZahl act = algorithmus3.minimum(temp1);
		RMaxZahl exp = new RMaxZahl(Double.NEGATIVE_INFINITY);
		assertEquals(act, exp);
	}

	/**
	 * Test der Maximumbestimmung im Karp-Algorithmus (Beispiel 1)
	 */	
	@Test
	void testMaximum1() { 
		RMaxZahl[] temp1 = {new RMaxZahl(5), new RMaxZahl(2), new RMaxZahl(6), new RMaxZahl(7)};
		RMaxZahl act = algorithmus4.maximum(temp1);
		RMaxZahl exp = new RMaxZahl(7);
		assertEquals(act, exp);
	}
	
	/**
	 * Test der Maximumbestimmung im Karp-Algorithmus (Beispiel 2)
	 */	
	@Test
	void testMaximum2() { 
		RMaxZahl[] temp1 = {new RMaxZahl(5), new RMaxZahl(-2), new RMaxZahl(6), new RMaxZahl(-7)};
		RMaxZahl act = algorithmus4.maximum(temp1);
		RMaxZahl exp = new RMaxZahl(6);
		assertEquals(act, exp);
	}
	
	/**
	 * Test der Maximumbestimmung im Karp-Algorithmus (Beispiel 3)
	 */	
	@Test
	void testMaximum3() { 
		RMaxZahl[] temp1 = {new RMaxZahl(Double.NEGATIVE_INFINITY), new RMaxZahl(-2), new RMaxZahl(6), new RMaxZahl(-7)};
		RMaxZahl act = algorithmus4.maximum(temp1);
		RMaxZahl exp = new RMaxZahl(6);
		assertEquals(act, exp);
	}

}
