package tests;

import strategy.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RMaxZahlTest {
	
	double eps = Double.NEGATIVE_INFINITY;

	/**
	 * Test zum erhalten einer RMax-Zahl (Beispiel 1)
	 */	
	@Test
	void testGetRMaxZahl1() { 
		RMaxZahl r1 = new RMaxZahl(5);
		double exp = 5;
		double act = r1.getRMaxZahl();
		assertEquals(exp, act);
	}
	
	/**
	 * Test zum erhalten einer RMax-Zahl (Beispiel 2)
	 */	
	@Test
	void testGetRMaxZahl2() { 
		RMaxZahl r2 = new RMaxZahl(-20);
		double exp = -20;
		double act = r2.getRMaxZahl();
		assertEquals(exp, act);
	}
	
	/**
	 * Test zum erhalten einer RMax-Zahl (Beispiel 3)
	 */	
	@Test
	void testGetRMaxZahl3() { 
		RMaxZahl r2 = new RMaxZahl(eps);
		double exp = eps;
		double act = r2.getRMaxZahl();
		assertEquals(exp, act);
	}
	
	/**
	 * Test der Addition von zwei RMax-Zahlen (Beispiel 1)
	 */
	@Test
	void testRMaxZahlAddition1() { 
		RMaxZahl r1 = new RMaxZahl(8);
		RMaxZahl r2 = new RMaxZahl(3);
		RMaxZahl act = r1.rMaxZahlAddition(r2);
		RMaxZahl exp = new RMaxZahl(8);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
	
	/**
	 * Test der Addition von zwei RMax-Zahlen (Beispiel 2)
	 */	
	@Test
	void testRMaxZahlAddition2() { 
		RMaxZahl r1 = new RMaxZahl(-8);
		RMaxZahl r2 = new RMaxZahl(3);
		RMaxZahl act = r1.rMaxZahlAddition(r2);
		RMaxZahl exp = new RMaxZahl(3);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
	
	/**
	 * Test der Addition von zwei RMax-Zahlen (Beispiel 3)
	 */	
	@Test
	void testRMaxZahlAddition3() { 
		RMaxZahl r1 = new RMaxZahl(Double.NEGATIVE_INFINITY);
		RMaxZahl r2 = new RMaxZahl(-3);
		RMaxZahl act = r1.rMaxZahlAddition(r2);
		RMaxZahl exp = new RMaxZahl(-3);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
	
	/**
	 * Test der Subtraktion von zwei RMax-Zahlen (Beispiel 1)
	 */
	@Test
	void testRMaxZahlSubtraktion1() { 
		RMaxZahl r1 = new RMaxZahl(8);
		RMaxZahl r2 = new RMaxZahl(3);
		RMaxZahl act = r1.rMaxZahlKarpSubtraktion(r2);
		RMaxZahl exp = new RMaxZahl(5);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
	
	/**
	 * Test der Addition von zwei RMax-Zahlen (Beispiel 2)
	 */	
	@Test
	void testRMaxZahlSubtraktion2() { 
		RMaxZahl r1 = new RMaxZahl(-8);
		RMaxZahl r2 = new RMaxZahl(3);
		RMaxZahl act = r1.rMaxZahlKarpSubtraktion(r2);
		RMaxZahl exp = new RMaxZahl(-11);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
	
	/**
	 * Test der Addition von zwei RMax-Zahlen (Beispiel 3)
	 */	
	@Test
	void testRMaxZahlSubtraktion3() { 
		RMaxZahl r1 = new RMaxZahl(-8);
		RMaxZahl r2 = new RMaxZahl(-3);
		RMaxZahl act = r1.rMaxZahlKarpSubtraktion(r2);
		RMaxZahl exp = new RMaxZahl(-5);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
	
	/**
	 * Test der Addition von zwei RMax-Zahlen (Beispiel 4)
	 */	
	@Test
	void testRMaxZahlSubtraktion4() { 
		RMaxZahl r1 = new RMaxZahl(Double.NEGATIVE_INFINITY);
		RMaxZahl r2 = new RMaxZahl(-3);
		RMaxZahl act = r1.rMaxZahlKarpSubtraktion(r2);
		RMaxZahl exp = new RMaxZahl(Double.NEGATIVE_INFINITY);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
	
	/**
	 * Test der Division von zwei RMax-Zahlen (Beispiel 1)
	 */
	@Test
	void testRMaxZahlDivision1() { 
		RMaxZahl r1 = new RMaxZahl(8);
		RMaxZahl r2 = new RMaxZahl(4);
		RMaxZahl act = r1.rMaxZahlDivision(r2);
		RMaxZahl exp = new RMaxZahl(2);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
	
	/**
	 * Test der Division von zwei RMax-Zahlen (Beispiel 2)
	 */	
	@Test
	void testRMaxZahlDivision2() { 
		RMaxZahl r1 = new RMaxZahl(-8);
		RMaxZahl r2 = new RMaxZahl(4);
		RMaxZahl act = r1.rMaxZahlDivision(r2);
		RMaxZahl exp = new RMaxZahl(-2);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
	
	/**
	 * Test der Division von zwei RMax-Zahlen (Beispiel 3)
	 */	
	@Test
	void testRMaxZahlDivision3() { 
		RMaxZahl r1 = new RMaxZahl(-8);
		RMaxZahl r2 = new RMaxZahl(-4);
		RMaxZahl act = r1.rMaxZahlDivision(r2);
		RMaxZahl exp = new RMaxZahl(2);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
	
	/**
	 * Test der Multiplikation von zwei RMax-Zahlen (Beispiel 1)
	 */
	@Test
	void testRMaxZahlMultiplikation1() { 
		RMaxZahl r1 = new RMaxZahl(8);
		RMaxZahl r2 = new RMaxZahl(3);
		RMaxZahl act = r1.rMaxZahlMultiplikation(r2);
		RMaxZahl exp = new RMaxZahl(11);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
	
	/**
	 * Test der Multiplikation von zwei RMax-Zahlen (Beispiel 2)
	 */
	@Test
	void testRMaxZahlMultiplikation2() { 
		RMaxZahl r1 = new RMaxZahl(-8);
		RMaxZahl r2 = new RMaxZahl(3);
		RMaxZahl acty = r1.rMaxZahlMultiplikation(r2);
		RMaxZahl expy = new RMaxZahl(-5);
		RMaxZahl act = new RMaxZahl(acty.getRMaxZahl());
		RMaxZahl exp = new RMaxZahl(expy.getRMaxZahl());
		assertEquals(exp, act);
	}
	
	/**
	 * Test der Multiplikation von zwei RMax-Zahlen (Beispiel 3)
	 */	
	@Test
	void testRMaxZahlMultiplikation3() { 
		RMaxZahl r1 = new RMaxZahl(-8);
		RMaxZahl r2 = new RMaxZahl(-3);
		RMaxZahl act = r1.rMaxZahlMultiplikation(r2);
		RMaxZahl exp = new RMaxZahl(-11);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
	
	/**
	 * Test der Multiplikation von zwei RMax-Zahlen (Beispiel 4)
	 */
	@Test
	void testRMaxZahlMultiplikation4() { 
		RMaxZahl r1 = new RMaxZahl(Double.NEGATIVE_INFINITY);
		RMaxZahl r2 = new RMaxZahl(3);
		RMaxZahl act = r1.rMaxZahlMultiplikation(r2);
		RMaxZahl exp = new RMaxZahl(Double.NEGATIVE_INFINITY);
		assertEquals(exp.getRMaxZahl(), act.getRMaxZahl());
	}
}
