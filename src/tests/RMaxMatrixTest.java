package tests;

import strategy.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RMaxMatrixTest {
	
	/**
	 * Test, der die eingebene RMax-Matrix zurückgibt (Beispiel 1)
	 */
	@Test
	void testGetRMaxMatrix1() { 
		double[][] temp = {{1, 3}, {4, 7}};
		RMaxMatrix m = new RMaxMatrix(temp);
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[i].length; j++) {
				RMaxZahl act = new RMaxZahl(m.getRMaxKomponente(i, j).getRMaxZahl());
				RMaxZahl exp = new RMaxZahl(temp[i][j]);
				assertEquals(exp, act);
			}
		}
	}
	
	/**
	 * Test, der die eingebene RMax-Matrix zurückgibt (Beispiel 2)
	 */
	@Test
	void testGetRMaxMatrix2() {
		double[][] temp = {{1, -3}, {-4, 7}};
		RMaxMatrix m = new RMaxMatrix(temp);
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[i].length; j++) {
				RMaxZahl act = new RMaxZahl(m.getRMaxKomponente(i, j).getRMaxZahl());
				RMaxZahl exp = new RMaxZahl(temp[i][j]);
				assertEquals(exp, act);
			}
		}
	}
	
	/**
	 * Test, der die eingebene RMax-Matrix zurückgibt (Beispiel 3)
	 */
	@Test
	void testGetRMaxMatrix3() { 
		double[][] temp = {{Double.NEGATIVE_INFINITY, 3}, {4, Double.NEGATIVE_INFINITY}};
		RMaxMatrix m = new RMaxMatrix(temp);
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[i].length; j++) {
				RMaxZahl act = new RMaxZahl(m.getRMaxKomponente(i, j).getRMaxZahl());
				RMaxZahl exp = new RMaxZahl(temp[i][j]);
				assertEquals(exp, act);
			}
		}
	}

	/**
	 * Test, der die Spalte der eingebenen RMax-Matrix zurückgibt (Beispiel 1)
	 */
	@Test
	void testGetRMaxSpalte1a() { 
		double[][] temp = {{1, 3}, {4, 7}};
		RMaxMatrix m = new RMaxMatrix(temp);
		
		double[] expV = {1, 4};
		RMaxVektor v = m.getRMaxSpalte(0);
		for(int i = 0; i < temp.length; i++) {
			RMaxZahl act = new RMaxZahl(v.getRMaxKomponente(i).getRMaxZahl());
			RMaxZahl exp = new RMaxZahl(expV[i]);
			
			assertEquals(exp, act);
		}
	}
	
	/**
	 * Test, der die Spalte der eingebenen RMax-Matrix zurückgibt (Beispiel 2)
	 */
	@Test
	void testGetRMaxSpalte1b() { 
		double [][] temp = {{Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY}, {4, 7}};
		RMaxMatrix m = new RMaxMatrix(temp);
		double[] expV = {Double.NEGATIVE_INFINITY, 4};
		RMaxVektor v = m.getRMaxSpalte(0);
		for(int i = 0; i < temp.length; i++) {
			RMaxZahl act = new RMaxZahl(v.getRMaxKomponente(i).getRMaxZahl());
			RMaxZahl exp = new RMaxZahl(expV[i]);
			assertEquals(exp, act);
		}
	}
	
	/**
	 * Test, der die Spalte der eingebenen RMax-Matrix zurückgibt (Beispiel 3)
	 */
	@Test
	void testGetRMaxSpalte2a() { 
		double[][] temp = {{1, 3}, {4, 7}};
		RMaxMatrix m = new RMaxMatrix(temp);
		double[] expV = {3, 7};
		RMaxVektor v = m.getRMaxSpalte(1);
		for(int i = 0; i < temp.length; i++) {
			RMaxZahl act = new RMaxZahl(v.getRMaxKomponente(i).getRMaxZahl());
			RMaxZahl exp = new RMaxZahl(expV[i]);
			assertEquals(exp, act);
		}
	}
	
	/**
	 * Test, der die Spalte der eingebenen RMax-Matrix zurückgibt (Beispiel 4)
	 */
	@Test
	void testGetRMaxSpalte2b() { 
		double [][] temp = {{1, 3}, {Double.NEGATIVE_INFINITY, -7}};
		RMaxMatrix m = new RMaxMatrix(temp);
		double [] expV = {3, -7};
		RMaxVektor v  =m.getRMaxSpalte(1);
		for(int i = 0; i < temp.length; i++) {
			RMaxZahl act = new RMaxZahl(v.getRMaxKomponente(i).getRMaxZahl());
			RMaxZahl exp = new RMaxZahl(expV[i]);
			assertEquals(exp, act);
		}
	}

	/**
	 * Test, der die Zeile der eingebenen RMax-Matrix zurückgibt (Beispiel 1)
	 */
	@Test
	void testGetRMaxZeile1a() { 
		double[][] temp = {{1, 3}, {4, 7}};
		RMaxMatrix m = new RMaxMatrix(temp);
		double[] expV = {1, 3};
		RMaxVektor v = m.getRMaxZeile(0);
		for(int i = 0; i < temp.length; i++) {
			RMaxZahl act = new RMaxZahl(v.getRMaxKomponente(i).getRMaxZahl());
			RMaxZahl exp = new RMaxZahl(expV[i]);
			assertEquals(exp, act);
		}
	}
	
	/**
	 * Test, der die Zeile der eingebenen RMax-Matrix zurückgibt (Beispiel 2)
	 */
	@Test
	void testGetRMaxZeile1b() { 
		double [][] temp = {{-1, 3}, {Double.NEGATIVE_INFINITY, 7}};
		RMaxMatrix m = new RMaxMatrix(temp);
		
		double[] expV = {-1, 3};
		RMaxVektor v = m.getRMaxZeile(0);
		for(int i = 0; i < temp.length; i++) {
			RMaxZahl act = new RMaxZahl(v.getRMaxKomponente(i).getRMaxZahl());
			RMaxZahl exp = new RMaxZahl(expV[i]);
			
			assertEquals(exp, act);
		}
	}
	
	/**
	 * Test, der die Zeile der eingebenen RMax-Matrix zurückgibt (Beispiel 3)
	 */
	@Test
	void testGetRMaxZeile2a() { 
		double[][] temp = {{1, 3}, {4, 7}};
		RMaxMatrix m = new RMaxMatrix(temp);
		double[] expV = {4, 7};
		RMaxVektor v = m.getRMaxZeile(1);
		for(int i = 0; i < temp.length; i++) {
			RMaxZahl act = new RMaxZahl(v.getRMaxKomponente(i).getRMaxZahl());
			RMaxZahl exp = new RMaxZahl(expV[i]);
			assertEquals(exp, act);
		}
	}
	
	/**
	 * Test, der die Zeile der eingebenen RMax-Matrix zurückgibt (Beispiel 4)
	 */
	@Test
	void testGetRMaxZeile2b() { 
		double[][] temp = {{1, 3}, {4, Double.NEGATIVE_INFINITY}};
		RMaxMatrix m = new RMaxMatrix(temp);
		double[] expV = {4, Double.NEGATIVE_INFINITY};
		RMaxVektor v = m.getRMaxZeile(1);
		for(int i = 0; i < temp.length; i++) {
			RMaxZahl act = new RMaxZahl(v.getRMaxKomponente(i).getRMaxZahl());
			RMaxZahl exp = new RMaxZahl(expV[i]);
			assertEquals(exp, act);
		}
	}
	
	/**
	 * Test, der eine Komponente der eingebenen RMax-Matrix zurückgibt (Beispiel 1)
	 */
	@Test
	void testGetRMaxKomponente1() { 
		double[][] temp = {{1, 3}, {4, 7}};
		RMaxMatrix m = new RMaxMatrix(temp);
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[i].length; j++) {
				RMaxZahl act = new RMaxZahl(m.getRMaxKomponente(i, j).getRMaxZahl());
				RMaxZahl exp = new RMaxZahl(temp[i][j]);
				assertEquals(exp, act);	
			}	
		}
	}
	
	/**
	 * Test, der eine Komponente der eingebenen RMax-Matrix zurückgibt (Beispiel 2)
	 */
	@Test
	void testGetRMaxKomponente2() { 
		double[][] temp = {{-1, Double.NEGATIVE_INFINITY}, {Double.NEGATIVE_INFINITY, 7}};
		RMaxMatrix m = new RMaxMatrix(temp);
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[i].length; j++) {
				RMaxZahl act = new RMaxZahl(m.getRMaxKomponente(i, j).getRMaxZahl());
				RMaxZahl exp = new RMaxZahl(temp[i][j]);
				assertEquals(exp, act);
			}
		}
	}

	/**
	 * Test, der die Dimension der eingebenen RMax-Matrix zurückgibt (Beispiel 1)
	 */
	@Test
	void testGetDimension1() { 
		double[][] temp = {{1, 3, 7}, {4, 7, 8}, {1, 3, 12}};
		RMaxMatrix m = new RMaxMatrix(temp);
		int act = m.getDimension();
		int exp = 3;
		assertEquals(exp, act);
	}
	
	/**
	 * Test, der die Dimension der eingebenen RMax-Matrix zurückgibt (Beispiel 2)
	 */
	@Test
	void testGetDimension2() { 
		double[][] temp = {{1, 3, 7, 5}, {4, 7, 8, 7}, {1, 3, 12, 3}, {4, 9, 11, 2}};
		RMaxMatrix m = new RMaxMatrix(temp);
		int act = m.getDimension();
		int exp = 4;
		assertEquals(exp, act);
	}
	
	/**
	 * Test, der die Addition von zwei RMax-Matrizen durchführt (Beispiel 1)
	 */
	@Test
	void testRMaxMatrixAddition1() { 
		double[][] temp1 = {{1, 2}, {5, 4}};
		double[][] temp2 = {{3, 4}, {3, 6}};
		RMaxMatrix m1 = new RMaxMatrix(temp1);
		RMaxMatrix m2 = new RMaxMatrix(temp2);
		double[][] expM = {{3, 4}, {5, 6}};
		RMaxMatrix actM = m1.rMaxMatrixAddition(m2);
		for(int i = 0; i < expM.length; i++) {
			for(int j = 0; j < expM[i].length; j++) {
				RMaxZahl act = new RMaxZahl(actM.getRMaxKomponente(i, j).getRMaxZahl());
				RMaxZahl exp = new RMaxZahl(expM[i][j]);
				assertEquals(exp, act);
			}
		}
	}
	
	/**
	 * Test, der die Addition von zwei RMax-Matrizen durchführt (Beispiel 2)
	 */
	@Test
	void testRMaxMatrixAddition2() { 
		double[][] temp1 = {{1, Double.NEGATIVE_INFINITY}, {-5, -4}};
		double[][] temp2 = {{3, Double.NEGATIVE_INFINITY}, {Double.NEGATIVE_INFINITY, -6}};
		RMaxMatrix m1 = new RMaxMatrix(temp1);
		RMaxMatrix m2 = new RMaxMatrix(temp2);
		double[][] expM = {{3, Double.NEGATIVE_INFINITY}, {-5, -4}};
		RMaxMatrix actM = m1.rMaxMatrixAddition(m2);
		for(int i = 0; i < expM.length; i++) {
			for(int j = 0; j < expM[i].length; j++) {
				RMaxZahl act = new RMaxZahl(actM.getRMaxKomponente(i, j).getRMaxZahl());
				RMaxZahl exp = new RMaxZahl(expM[i][j]);
				
				assertEquals(exp, act);
			}
		}
	}
	
	/**
	 * Test, der die Multiplikation von einer RMax-Matrix mit einem RMax-Vektor durchführt (Beispiel 1)
	 */
	@Test
	void testRMaxMatrixVektorMultiplikation1() { 
		double [] temp1 = {3, 5};
		RMaxVektor r1 = new RMaxVektor(temp1);
		double[][] temp2 = {{7, 2}, {1, 9}};
		RMaxMatrix m1 = new RMaxMatrix(temp2);
		double[] temp3 = {10, 14};
		RMaxVektor exp = new RMaxVektor(temp3);
		RMaxVektor act = m1.rMaxMatrixVektorMultiplikation(r1);
		for(int i = 0; i < temp1.length; i++) {
			assertEquals(exp.getRMaxKomponente(i).getRMaxZahl(), act.getRMaxKomponente(i).getRMaxZahl());
		}
	}
	
	/**
	 * Test, der die Multiplikation von einer RMax-Matrix mit einem RMax-Vektor durchführt (Beispiel 2)
	 */
	@Test
	void testRMaxMatrixVektorMultiplikation2() { 
		double [] temp1 = {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};
		RMaxVektor r1 = new RMaxVektor(temp1);
		double [][] temp2 = {{7, 2}, {Double.NEGATIVE_INFINITY, -9}};
		RMaxMatrix m1 = new RMaxMatrix(temp2);
		double[] temp3 = {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};
		RMaxVektor exp = new RMaxVektor(temp3);
		RMaxVektor act = m1.rMaxMatrixVektorMultiplikation(r1);
		for(int i = 0; i < temp1.length; i++) {
			assertEquals(exp.getRMaxKomponente(i).getRMaxZahl(), act.getRMaxKomponente(i).getRMaxZahl());
		}
	}
	
	/**
	 * Test, der die Multiplikation von einer RMax-Matrix mit einer RMax-Zahl durchführt (Beispiel 1)
	 */
	@Test
	void testRMaxSkalarMultiplikationMatrix1() { 
		double[][] temp1 = {{1, 3, 7}, {4, 7, 8}, {1, 3, 12}};
		RMaxMatrix m = new RMaxMatrix(temp1);	
		RMaxZahl a = new RMaxZahl(4);	
		RMaxMatrix act = m.rMaxSkalarMultiplikationMatrix(a);	
		double[][] temp2 = {{5, 7, 11}, {8, 11, 12}, {5, 7, 16}};
		RMaxMatrix exp = new RMaxMatrix(temp2);	
		for(int i = 0; i < temp2.length; i++) {
			for(int j = 0; j < temp2[i].length; j++) {
				assertEquals(exp.getRMaxKomponente(i, j).getRMaxZahl(), act.getRMaxKomponente(i, j).getRMaxZahl());
			}
		}
	}
	
	/**
	 * Test, der die Multiplikation von einer RMax-Matrix mit einer RMax-Zahl durchführt (Beispiel 2)
	 */	
	@Test
	void testRMaxSkalarMultiplikationMatrix2() { 
		double [][] temp1 = {{1, Double.NEGATIVE_INFINITY, 7}, {4, -7, -8}, {Double.NEGATIVE_INFINITY, 3, Double.NEGATIVE_INFINITY}};
		RMaxMatrix m = new RMaxMatrix(temp1);
		RMaxZahl a = new RMaxZahl(Double.NEGATIVE_INFINITY);
		RMaxMatrix act = m.rMaxSkalarMultiplikationMatrix(a);
		double[][] temp2 = {{Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY}, {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY}, {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY}};
		RMaxMatrix exp = new RMaxMatrix(temp2);
		for(int i = 0; i < temp2.length; i++) {
			for(int j = 0; j < temp2[i].length; j++) {
				assertEquals(exp.getRMaxKomponente(i, j).getRMaxZahl(), act.getRMaxKomponente(i, j).getRMaxZahl());
			}
		}
	}
	
	/**
	 * Test, der die Multiplikation von zwei RMax-Matrizen durchführt 
	 */	
	@Test
	void testRMaxMatrixMultiplikation() {
		double d = Double.NEGATIVE_INFINITY;
		double [][] temp1 = {{1, 0}, {d, 4}};
		double [][] temp3 = {{3, 2}, {6, d}};
		RMaxMatrix temp2 = new RMaxMatrix(temp1);
		RMaxMatrix temp4 = new RMaxMatrix(temp3);
		RMaxMatrix acty = temp2.rMaxMatrixMultiplikation(temp4);
		double [][] temp5 = {{6, 3}, {10, d}};
		RMaxMatrix temp6 = new RMaxMatrix(temp5);
		RMaxMatrix expy = temp6;
		RMaxZahl act = acty.getRMaxKomponente(0, 0);
		RMaxZahl exp = new RMaxZahl(6);	
		assertEquals(exp, act);
		
	}
	
	/**
	 * Test, der die Pontenzierung einer Matrix mit einer RMax-Zahl durchführt
	 */	
	@Test
	void testRMaxMatrixPotenzierung() {
		double d = Double.NEGATIVE_INFINITY;
		double [][] temp1 = {{1, 0}, {d, 4}};
		RMaxMatrix temp2 = new RMaxMatrix(temp1);
		RMaxMatrix acty = temp2.rMaxMatrixPotenzierung(3);
		double [][] temp3 = {{3, 8}, {d, 12}};
		RMaxMatrix temp4 = new RMaxMatrix(temp3);
		RMaxMatrix expy = temp4;
		RMaxZahl exp = expy.getRMaxKomponente(0, 0);
		RMaxZahl act = acty.getRMaxKomponente(0, 0);	
		assertEquals(exp, act);
	}

}

