package strategy;


public class RMaxZahl {

	private double zahl;

	public RMaxZahl() {
	}

	/**
	 * erzeugt Max-Plus-Zahl
	 * 
	 * @param a Wert der RMaxZahl 
	 */
	public RMaxZahl(double a) {
		this.zahl = a;
	}

	/**
	 * @return liefert Max-Plus-Zahl
	 */
	public double getRMaxZahl() {
		return zahl;
	}

	/**
	 * Addition von RMax Zahlen
	 * 
	 * @param a Zahl die mit "this" addiert wird
	 * @return Ergebnis der Addition
	 */
	public RMaxZahl rMaxZahlAddition(RMaxZahl a) {

		if (a.getRMaxZahl() >= this.getRMaxZahl()) {
			return new RMaxZahl(a.getRMaxZahl());
		} else {
			return new RMaxZahl(this.getRMaxZahl());
		}
	}

	/**
	 * Subtrktion von RMax Zahlen (für den Karp Algorithmus)
	 * 
	 * @param a Zahl die von "this" subtrahiert wird
	 * @return Ergebnis der Subtraktion
	 */
	public RMaxZahl rMaxZahlKarpSubtraktion(RMaxZahl a) {

		if (this.getRMaxZahl() == Double.NEGATIVE_INFINITY) {
			if (a.getRMaxZahl() == Double.NEGATIVE_INFINITY) {
				return new RMaxZahl(0);
			}
			return new RMaxZahl(Double.NEGATIVE_INFINITY);
		}
		if (a.getRMaxZahl() == Double.NEGATIVE_INFINITY) {
			return new RMaxZahl(Double.POSITIVE_INFINITY);
		} else {
			return new RMaxZahl(this.getRMaxZahl() - a.getRMaxZahl());
		}
	}

	public RMaxZahl rMaxZahlPowerSubtraktion(RMaxZahl a) {
		return new RMaxZahl(this.getRMaxZahl() - a.getRMaxZahl());
	}

	/**
	 * Division von RMax Zahlen
	 * 
	 * @param a Zahl durch die "this" dividiert wird
	 * @return Ergebnis der Division
	 */
	public RMaxZahl rMaxZahlDivision(RMaxZahl a) {
		if (a.getRMaxZahl() == 0) {
			return null;
		} else if (a.getRMaxZahl() == Double.NEGATIVE_INFINITY) {
			return new RMaxZahl(Double.POSITIVE_INFINITY);
		} else {
			return new RMaxZahl(this.getRMaxZahl() / a.getRMaxZahl());
		}
	}

	/**
	 * Multiplikation von RMax Zahlen
	 * 
	 * @param a Zahl die mir "this" multipliziert wird
	 * @return Ergebnis der Multiplikation
	 */
	public RMaxZahl rMaxZahlMultiplikation(RMaxZahl a) {
		if (this.getRMaxZahl() == Double.NEGATIVE_INFINITY) {
			return new RMaxZahl(Double.NEGATIVE_INFINITY);
		} else if (a.getRMaxZahl() == Double.NEGATIVE_INFINITY) {
			return new RMaxZahl(Double.NEGATIVE_INFINITY);
		} else {
			double x = this.getRMaxZahl() + a.getRMaxZahl();
			return new RMaxZahl(x);
		}
	}

	/**
	 * Potenzierung von RMax Zahlen
	 * 
	 * @param a Exponent
	 * @return potenzierte RMax Zahl
	 */
	public RMaxZahl rMaxZahlPotenzierung(double a) {
		if (a == 0) {
			return new RMaxZahl(0);
		} else {
			double x = a * this.getRMaxZahl();
			return new RMaxZahl(x);
		}
	}

	@Override
	public String toString() {
		if (zahl == Double.NEGATIVE_INFINITY) {
			return "Epsilon";
		} else {
			return Double.toString(zahl);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(zahl);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		RMaxZahl other = (RMaxZahl) obj;
		if (Double.doubleToLongBits(zahl) != Double.doubleToLongBits(other.zahl))
			return false;
		return true;
	}

}