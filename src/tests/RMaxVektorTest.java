package tests;

import strategy.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RMaxVektorTest {
	
	/**
	 * Test zum setzen einer RMax-Zahl im RMax-Vektor (Beispiel 1)
	 */
	@Test
	void testSetRMaxKomponente1() { 
		RMaxVektor r1 = new RMaxVektor(3);
		r1.setRMaxKomponente(1, new RMaxZahl(14));
		double act = r1.getRMaxKomponente(1).getRMaxZahl();
		double exp = 14.0;
		assertEquals(exp, act);
	}
	
	/**
	 * Test zum setzen einer RMax-Zahl im RMax-Vektor (Beispiel 2)
	 */
	@Test
	void testSetRMaxKomponente2() { 
		RMaxVektor r1 = new RMaxVektor(3);
		r1.setRMaxKomponente(1, new RMaxZahl(-14));	
		double act = r1.getRMaxKomponente(1).getRMaxZahl();
		double exp = -14.0;		
		assertEquals(exp, act);
	}
	
	/**
	 * Test zum setzen einer RMax-Zahl im RMax-Vektor (Beispiel 3)
	 */
	@Test
	void testSetRMaxKomponente3() { 
		RMaxVektor r1 = new RMaxVektor(7);
		r1.setRMaxKomponente(5, new RMaxZahl(Double.NEGATIVE_INFINITY));		
		double act = r1.getRMaxKomponente(5).getRMaxZahl();
		double exp = Double.NEGATIVE_INFINITY;
		assertEquals(exp, act);
	}

	/**
	 * Test zum erhalten eines RMax-Vektors (Beispiel 1)
	 */	
	@Test
	void testGetRMaxVektor1() { 
		double [] temp = {2.0, 4.3, 5.7};
		RMaxVektor r1 = new RMaxVektor(temp);
		for(int i = 0; i < temp.length; i++) {
			double act = r1.getRMaxKomponente(i).getRMaxZahl();
			double exp = temp[i];		
			assertEquals(exp, act);
		}
	}
	
	/**
	 * Test zum erhalten eines RMax-Vektors (Beispiel 2)
	 */	
	@Test
	void testGetRMaxVektor2() { 
		double [] temp = {0, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};
		RMaxVektor r1 = new RMaxVektor(temp);		
		for(int i = 0; i < temp.length; i++) {
			double act = r1.getRMaxKomponente(i).getRMaxZahl();
			double exp = temp[i];		
			assertEquals(exp, act);
		}
	}

	/**
	 * Test zum erhalten einer RMax-Zahl aus einem RMax-Vektor (Beispiel 1)
	 */	
	@Test
	void testGetRMaxKomponente1() { 
		double [] temp = {2.0, 4.3, 5.7};
		RMaxVektor r1 = new RMaxVektor(temp);		
		double act = r1.getRMaxKomponente(1).getRMaxZahl();
		double exp = new RMaxZahl(4.3).getRMaxZahl();		
		assertEquals(exp, act);
	}
	
	/**
	 * Test zum erhalten einer RMax-Zahl aus einem RMax-Vektor (Beispiel 2)
	 */	
	@Test
	void testGetRMaxKomponente2() { 
		double [] temp = {Double.NEGATIVE_INFINITY, 4.3, 5.7};
		RMaxVektor r1 = new RMaxVektor(temp);	
		double act = r1.getRMaxKomponente(0).getRMaxZahl();
		double exp = new RMaxZahl(Double.NEGATIVE_INFINITY).getRMaxZahl();		
		assertEquals(exp, act);
	}
	
	/**
	 * Test zum erhalten einer RMax-Zahl aus einem RMax-Vektor (Beispiel 3)
	 */	
	@Test
	void testGetRMaxKomponente3() { 
		double [] temp = {2.0, 4.3, 5.7, 5.2, 6.0, 7.7, 8.1};
		RMaxVektor r1 = new RMaxVektor(temp);		
		double act = r1.getRMaxKomponente(6).getRMaxZahl();
		double exp = new RMaxZahl(8.1).getRMaxZahl();	
		assertEquals(exp, act);
	}

	/**
	 * Test zum erhalten der Dimension eines RMax-Vektors (Beispiel 1)
	 */	
	@Test
	void testGetDimension1() { 
		double [] temp = {2.0, 4.3, 5.7};
		RMaxVektor r1 = new RMaxVektor(temp);	
		int act = r1.getDimension();
		int exp = 3;		
		assertEquals(exp, act);
	}
	
	/**
	 * Test zum erhalten der Dimension eines RMax-Vektors (Beispiel 2)
	 */	
	@Test
	void testGetDimension2() { 
		double [] temp = {2.0, 4.3, 5.7, 5.2, 6.0, 7.7, 8.1};
		RMaxVektor r1 = new RMaxVektor(temp);		
		int act = r1.getDimension();
		int exp = 7;	
		assertEquals(exp, act);
	}

	/**
	 * Test der Addition zweier Rmax-Vektoren (Beispiel 1)
	 */	
	@Test
	void testRMaxVektorAddition1() { 
		double [] temp1 = {2.0, 4.3, 5.7};
		RMaxVektor r1 = new RMaxVektor(temp1);		
		double [] temp2 = {6.5, 7.2, 4.0};
		RMaxVektor r2 = new RMaxVektor(temp2);		
		double [] temp3 = {6.5, 7.2, 5.7};		
		for(int i = 0; i < temp1.length; i++) {
			double act = r1.rMaxVektorAddition(r2).getRMaxKomponente(i).getRMaxZahl();
			double exp = temp3[i];
			assertEquals(exp, act);
		}
	}
	
	/**
	 * Test der Addition zweier RMax-Vektoren (Beispiel 2)
	 */	
	@Test
	void testRMaxVektorAddition2() { 
		double [] temp1 = {Double.NEGATIVE_INFINITY, 4.3, 5.7};
		RMaxVektor r1 = new RMaxVektor(temp1);		
		double [] temp2 = {6.5, 7.2, Double.NEGATIVE_INFINITY};
		RMaxVektor r2 = new RMaxVektor(temp2);		
		double [] temp3 = {6.5, 7.2, 5.7};		
		for(int i = 0; i < temp1.length; i++) {
			double act = r1.rMaxVektorAddition(r2).getRMaxKomponente(i).getRMaxZahl();
			double exp = temp3[i];			
			assertEquals(exp, act);
		}
	}

	/**
	 * Test des Skalarprodukts zweier Rmax-Vektoren (Beispiel 1)
	 */	
	@Test
	void testRMaxVektorMultiplikation1() { 
		double [] temp1 = {2.0, 4.3, 5.7};
		RMaxVektor r1 = new RMaxVektor(temp1);		
		double [] temp2 = {6.5, 7.2, 4.0};
		RMaxVektor r2 = new RMaxVektor(temp2);	
		double act = r1.rMaxVektorMultiplikation(r2).getRMaxZahl();
		double exp = 11.5;		
		assertEquals(exp, act);
	}
	
	/**
	 * Test des Skalarprodukts zweier Rmax-Vektoren (Beispiel 2)
	 */	
	@Test
	void testRMaxVektorMultiplikation2() { 
		double [] temp1 = {Double.NEGATIVE_INFINITY, 4.3, 5.7};
		RMaxVektor r1 = new RMaxVektor(temp1);		
		double [] temp2 = {6.5, 7.2, Double.NEGATIVE_INFINITY};
		RMaxVektor r2 = new RMaxVektor(temp2);
		double act = r1.rMaxVektorMultiplikation(r2).getRMaxZahl();
		double exp = 11.5;		
		assertEquals(exp, act);
	}

	/**
	 * Test der Multiplikation eines Skalars und eines RMax-Vektors (Beispiel 1)
	 */	
	@Test
	void testRMaxSkalarMultiplikationVektor1() { 
		double [] temp1 = {2.0, 4.3, 5.7};
		RMaxVektor r1 = new RMaxVektor(temp1);
		RMaxZahl a = new RMaxZahl(2);
		RMaxVektor act = r1.rMaxSkalarMultiplikationVektor(a);
		double [] temp2 = {4.0, 6.3, 7.7};
		RMaxVektor exp = new RMaxVektor(temp2);	
		for(int i = 0; i < temp1.length; i++) {
			assertEquals(exp.getRMaxKomponente(i).getRMaxZahl(), act.getRMaxKomponente(i).getRMaxZahl());
		}
		
	}
	
	/**
	 * Test der Multiplikation eines Skalars und eines RMax-Vektors (Beispiel 2)
	 */	
	@Test
	void testRMaxSkalarMultiplikationVektor2() { 
		double [] temp1 = {2.0, 4.3, 5.7};
		RMaxVektor r1 = new RMaxVektor(temp1);
		RMaxZahl a = new RMaxZahl(Double.NEGATIVE_INFINITY);
		RMaxVektor act = r1.rMaxSkalarMultiplikationVektor(a);
		double [] temp2 = {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};
		RMaxVektor exp = new RMaxVektor(temp2);	
		for(int i = 0; i < temp1.length; i++) {
			assertEquals(exp.getRMaxKomponente(i).getRMaxZahl(), act.getRMaxKomponente(i).getRMaxZahl());
		}
		
	}
	
	/**
	 * Test der Multiplikation eines Skalars und eines RMax-Vektors (Beispiel 3)
	 */	
	@Test
	void testRMaxSkalarMultiplikationVektor3() { 
		double [] temp1 = {Double.NEGATIVE_INFINITY, 4.3, Double.NEGATIVE_INFINITY};
		RMaxVektor r1 = new RMaxVektor(temp1);
		RMaxZahl a = new RMaxZahl(2);
		RMaxVektor act = r1.rMaxSkalarMultiplikationVektor(a);
		double [] temp2 = {Double.NEGATIVE_INFINITY, 6.3, Double.NEGATIVE_INFINITY};
		RMaxVektor exp = new RMaxVektor(temp2);	
		for(int i = 0; i < temp1.length; i++) {
			assertEquals(exp.getRMaxKomponente(i).getRMaxZahl(), act.getRMaxKomponente(i).getRMaxZahl());
		}
		
	}

	/**
	 * Test der Multiplikation einer RMax-Matrix und eines RMax-Vektors (Beispiel 1)
	 */	
	@Test
	void testRMaxVektorMatrixMultiplikation1() { 
		double [] temp1 = {3, 5};
		RMaxVektor r1 = new RMaxVektor(temp1);		
		double[][] temp2 = {{7, 2}, {1, 9}};
		RMaxMatrix m1 = new RMaxMatrix(temp2);		
		double[] temp3 = {10, 14};
		RMaxVektor exp = new RMaxVektor(temp3);		
		RMaxVektor act = r1.rMaxVektorMatrixMultiplikation(m1);		
		for(int i = 0; i < temp1.length; i++) {
			assertEquals(exp.getRMaxKomponente(i).getRMaxZahl(), act.getRMaxKomponente(i).getRMaxZahl());
		}
	}
}
