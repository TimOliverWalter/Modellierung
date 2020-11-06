package strategy;


import java.util.Arrays;

public class RMaxVektor {

	private RMaxZahl[] vektor;

	/**
	 * Erzeugt leeren Max-Plus-Vektor
	 * 
	 * @param n Dimension des Vektors
	 */
	public RMaxVektor(int n) {
		this.vektor = new RMaxZahl[n];
	}

	/**
	 * Erzeugt aus Double Array ein Max-Plus-Vektor
	 * 
	 * @param a Double Array
	 */
	public RMaxVektor(double[] a) {
		int dim = a.length;
		this.vektor = new RMaxZahl[dim];
		for (int i = 0; i < dim; i++) {
			this.vektor[i] = new RMaxZahl(a[i]);
		}
	}

	/**
	 * Ersetz an der Stelle i den Eintrag durch a
	 * 
	 * @param i	Stelle im Vektor, welche ersetzt werden soll
	 * @param a zu ersetzender Wert
	 */
	public void setRMaxKomponente(int i, RMaxZahl a) {
		this.vektor[i] = a;
	}

	/**
	 * @return liefert Max-Plus-Vektor
	 */
	public RMaxZahl[] getRMaxVektor() {
		return this.vektor;
	}

	/**
	 * liefert Komponente an der Stelle i
	 * 
	 * @param i	Komponente des Vektors
	 * @return Komponente der i-ten Stelle
	 */
	public RMaxZahl getRMaxKomponente(int i) {
		return vektor[i];
	}

	/**
	 * @return Double Array
	 */
	public double[] getRMaxZahlen() {
		double[] a = new double[this.getDimension()];

		for (int i = 0; i < a.length; i++) {
			a[i] = this.getRMaxKomponente(i).getRMaxZahl();
		}

		return a;
	}

	/**
	 * @return Dimension des Vektors
	 */
	public int getDimension() {
		return this.vektor.length;
	}

	/**
	 * Addition von zwei RMax Vektoren
	 * 
	 * @param v Vektor der zu "this" addiert wird
	 * @return Ergebnisvektor der Addition
	 */
	public RMaxVektor rMaxVektorAddition(RMaxVektor v) {
		int dim = this.vektor.length;
		RMaxVektor vektor = new RMaxVektor(dim);

		for (int i = 0; i < dim; i++) {
			vektor.setRMaxKomponente(i, this.getRMaxKomponente(i).rMaxZahlAddition(v.getRMaxKomponente(i)));
		}

		return vektor;
	}

	/**
	 * Multiplikation von zwei Vektoren
	 * 
	 * @param v Vektor der mit "this" multipliziert wird
	 * @return Ergebnis der Multiplikation
	 */
	public RMaxZahl rMaxVektorMultiplikation(RMaxVektor v) {
		int dim = this.vektor.length;
		RMaxZahl a = new RMaxZahl(Double.NEGATIVE_INFINITY);

		for (int i = 0; i < dim; i++) {
			a = a.rMaxZahlAddition(this.getRMaxKomponente(i).rMaxZahlMultiplikation(v.getRMaxKomponente(i)));
		}

		return a;
	}

	/**
	 * Skalare Multiplikation von RMax Vektor mit RMax Zahl
	 * 
	 * @param a RMax Zahl mit der die Komponenten multipliziert werden
	 * @return Ergebnisvektor der skalaren Multiplikation
	 */
	public RMaxVektor rMaxSkalarMultiplikationVektor(RMaxZahl a) {
		int dim = this.vektor.length;
		RMaxVektor vektor = new RMaxVektor(dim);

		for (int i = 0; i < dim; i++) {
			vektor.setRMaxKomponente(i, this.getRMaxKomponente(i).rMaxZahlMultiplikation(a));
		}

		return vektor;
	}

	/**
	 * Matrix-Vektor Multiplikation
	 * 
	 * @param a Matrix mit der "this" Vektor multipliziert wird
	 * @return Ergebnisvektor
	 */
	public RMaxVektor rMaxVektorMatrixMultiplikation(RMaxMatrix a) {
		int dim = a.getDimension();
		RMaxVektor v = new RMaxVektor(dim);

		for (int i = 0; i < dim; i++) {
			RMaxZahl l = new RMaxZahl(Double.NEGATIVE_INFINITY);
			for (int j = 0; j < dim; j++) {
				l = l.rMaxZahlAddition(this.getRMaxKomponente(j).rMaxZahlMultiplikation(a.getRMaxKomponente(i, j)));
			}
			v.setRMaxKomponente(i, l);
		}
		return v;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(vektor);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RMaxVektor other = (RMaxVektor) obj;
		if (!Arrays.equals(vektor, other.vektor))
			return false;
		return true;
	}
}
