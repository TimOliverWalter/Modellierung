package strategy;


//Methoden nach Testen wieder private machen!

public class Karp implements Loesungsverhalten {

	RMaxVektor startVektor;

	/**
	 * Diese Methode wird von Loesungsverhalten implementiert sie berechnet durch
	 * die Hilfsmethoden "iterieren", "startVektor" und "minimum" den Eigenwert der
	 * Matrix Dafür wird zuerst der Startvektor gewählt in der Methode "startVektor"
	 * dann wird mit hilfe der Methode "iterieren" n mal multipliziert um
	 * anschließend in jedem n ten Schritt mit hilfe der Methode "minimum" einen
	 * möglichen Kandidaten für den Eigenwert zu bestimmen anschließend wird mit der
	 * Methode "maximum" aus allen Kandidaten der Eigenwert bestimmt
	 */
	@Override
	public RMaxZahl loesenEigenwert(RMaxMatrix a) {
		int dim = a.getDimension();
		startVektor = new RMaxVektor(dim);

		startVektor(dim);

		RMaxVektor[] xNVektor = new RMaxVektor[dim + 1];
		xNVektor[0] = startVektor;
		for (int i = 1; i < dim + 1; i++) {
			xNVektor[i] = iterieren(a, startVektor);
		}

		RMaxZahl[] minima = new RMaxZahl[dim];

		for (int i = 1; i < dim + 1; i++) {
			RMaxZahl[] temp = new RMaxZahl[dim];
			for (int j = 0; j < dim; j++) {
				RMaxZahl zaehler = xNVektor[dim].getRMaxKomponente(i - 1)
						.rMaxZahlKarpSubtraktion(xNVektor[j].getRMaxKomponente(i - 1));
				RMaxZahl nenner = new RMaxZahl(dim - j);
				temp[j] = new RMaxZahl(zaehler.rMaxZahlDivision(nenner).getRMaxZahl());
			}
			minima[i - 1] = minimum(temp);
		}
		return new RMaxZahl(maximum(minima).getRMaxZahl());
	}

	/**
	 * Methode wird vom Loesungsverhalten implementiert, diese Methode hat fuer den
	 * Karp Algorithmus keinen Nutzen, da dieser nur den Eigenwert berechnet.
	 */
	@Override
	public RMaxVektor loesenEigenvektor(RMaxMatrix a) {

		return null;
	}

	/**
	 * Bestimmt in abhängigkeit der Dimension der Matrix den Startvektor der
	 * mindestens einen Eintrag ungleich "Epsilon" besitzt
	 * 
	 * @param dim Dimension der Matrix wovon der Eigenwert berechnet werden soll
	 */
	public void startVektor(int dim) {
		startVektor = new RMaxVektor(dim);
		double eps = Double.NEGATIVE_INFINITY;

		for (int i = 0; i < dim; i++) {
			if (i == 0) {
				startVektor.setRMaxKomponente(i, new RMaxZahl(0));
			} else {
				startVektor.setRMaxKomponente(i, new RMaxZahl(eps));
			}
		}

	}

	/**
	 * Führt n malige multiplikation zwischen dem aus dem vorherigen schritt
	 * errechneten Vektor und der Matrix durch
	 * 
	 * @param a Matrix aus der der Eigenwert berechnet werden soll
	 * @param v Vektor aus dem iterationsschritt zuvor
	 * @return Temporärer Vektor des n ten schrittes
	 */
	public RMaxVektor iterieren(RMaxMatrix a, RMaxVektor v) {

		RMaxVektor temp = a.rMaxMatrixVektorMultiplikation(v);
		startVektor = temp;
		return temp;
	}

	/**
	 * Bestimmt in jedem n ten Schritt das Minimum
	 * 
	 * @param a alle errechneten Werte aus dem n ten Schritt
	 * @return das Minimum
	 */
	public RMaxZahl minimum(RMaxZahl[] a) {
		double x = Double.POSITIVE_INFINITY;

		for (int i = 0; i < a.length; i++) {
			if (a[i].getRMaxZahl() < x) {
				x = a[i].getRMaxZahl();
			}
		}

		return new RMaxZahl(x);
	}

	/**
	 * Bestimmt aus allen Minima das Maximum
	 * 
	 * @param a alle Minima aus allen n Schritten
	 * @return Eigenwert
	 */
	public RMaxZahl maximum(RMaxZahl[] a) {
		double x = Double.NEGATIVE_INFINITY;

		for (int i = 0; i < a.length; i++) {
			if (a[i].getRMaxZahl() > x) {
				x = a[i].getRMaxZahl();
			}
		}

		return new RMaxZahl(x);
	}

}