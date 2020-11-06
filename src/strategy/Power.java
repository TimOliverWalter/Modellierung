package strategy;


//Methoden nach Testen wieder private machen!

import java.util.ArrayList;

public class Power implements Loesungsverhalten {

	private int n1;
	private int n2;
	private int dim;
	private double r;
	private RMaxVektor startVektor;
	private ArrayList<RMaxVektor> xNVektor = new ArrayList<RMaxVektor>();
	private RMaxZahl eigenwert;
	private RMaxVektor eigenvektor;

	/**
	 * Diese Methode wird von Loesungsverhalten implementiert und errechnet den
	 * Eigenwert der Matrix dafür werden die Hilfsmethoden "startVektor",
	 * "iterieren" und "istVielfaches" verwendet. Zuerst mit mit hilfe der Methode
	 * "iterieren" solange iteriert bis man bis man mit der Methode "istVielfaches"
	 * festgestellt hat das der n te und der n-1 te Vektor Vielfache voneinander
	 * sind
	 */
	@Override
	public RMaxZahl loesenEigenwert(RMaxMatrix a) {
		dim = a.getDimension();

		startVektor();

		xNVektor.add(startVektor);

		do {
			xNVektor.add(iterieren(a, xNVektor.get(xNVektor.size() - 1)));
			int f = 0;
			f = f + 5;
		} while (!istVielfaches());

		return eigenwert;
	}
	
	/**
	 * Diese Methode wird von Loesungsverhalten implementiert und
	 * errechnet den Eigenvektor der Matrix 
	 */
	@Override
	public RMaxVektor loesenEigenvektor(RMaxMatrix a) {

		eigenvektor = new RMaxVektor(dim);

		double eps = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < dim; i++) {
			eigenvektor.setRMaxKomponente(i, new RMaxZahl(eps));
		}

		RMaxZahl lambda;
		for (int i = 1; i <= n1 - n2; i++) {
			lambda = eigenwert.rMaxZahlPotenzierung(n1 - n2 - i);
			eigenvektor = eigenvektor
					.rMaxVektorAddition(xNVektor.get(n2 + i - 1).rMaxSkalarMultiplikationVektor(lambda));
		}

		return eigenvektor;
	}

	/**
	 * Bestimmt den Satrtvektor dieser muss ungleich dem "Epsilonvektor" sein also
	 * einem Vektor der nur "Epsilon" als Einträge besitzt
	 */
	public void startVektor() {

		startVektor = new RMaxVektor(dim);

		for (int i = 0; i < dim; i++) {
			if (i == 0) {
				startVektor.setRMaxKomponente(i, new RMaxZahl(0));
			} else {
				startVektor.setRMaxKomponente(i, new RMaxZahl(Double.NEGATIVE_INFINITY));
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

		return temp;
	}

	/**
	 * Methode istVielfaches überprüft, ob iterierter Vektor Vielfaches eines bereits errechneten Vektorss ist.
	 * Zuerst wird überprüft, ob gleich viele Epsilon im iterierten Vektor vorkommen.
	 * (Sollten nicht gleich viele Epsilon vorhanden sein, ist es nicht möglich dass die Vektoren Vielfache von einander sind)
	 * 
	 * Danach wird überprüft, ob die Epsilon an der selben Stelle im Vektor stehen.
	 * 
	 * Wenn beide Vektoren gleich viele Epsilon an der selben Stelle stehen haben wird die nötige Differenz berechnuet 
	 * und überprüft ob die Differenz in jeder Komponente dieselbe ist.
	 * 
	 * In diesem Fall wird "true" zurückgegeben (damit mit dem iterieren aufgehört wird)
	 * Ansonsten wird "false" zurückgegeben (damit erneut iteriert wird)
	 * 
	 * @return	true oder false (je nachdem ob Vektor Vielfaches ist oder nicht)
	 */
	public boolean istVielfaches() {

		int countA = 0; // zählt Epsilon im letzten Vektor
		int countB = 0; // zählt Epsilon in den anderen Vektoren
		RMaxZahl diff = new RMaxZahl();

		for (int i = 0; i < dim; i++) {
			if (xNVektor.get(xNVektor.size() - 1).getRMaxKomponente(i).equals(new RMaxZahl(Double.NEGATIVE_INFINITY))) {
				countA++;
			}
		}

		for (int i = 0; i < xNVektor.size() - 1; i++) {

			for (int j = 0; j < dim; j++) {
				if (xNVektor.get(i).getRMaxKomponente(j).equals(new RMaxZahl(Double.NEGATIVE_INFINITY))) {
					countB++;
				}
			}

			if (countA == countB) {
				// an welcher Stelle sind die Epsilons?
				int countC = 0; // wird hochgezählt wenn eps an der selben stelle ist
				if (countA > 0) {
					for (int j = 0; j < dim; j++) {
						// ist Eps an der selben Stelle?
						if (xNVektor.get(xNVektor.size() - 1).getRMaxKomponente(j)
								.equals(new RMaxZahl(Double.NEGATIVE_INFINITY))
								&& !xNVektor.get(i).getRMaxKomponente(j)
										.equals(new RMaxZahl(Double.NEGATIVE_INFINITY))) {
							break;
						} else if (xNVektor.get(i).getRMaxKomponente(j).equals(new RMaxZahl(Double.NEGATIVE_INFINITY))
								&& !xNVektor.get(xNVektor.size() - 1).getRMaxKomponente(j)
										.equals(new RMaxZahl(Double.NEGATIVE_INFINITY))) {
							break;
						} else {
							countC++;
						}
					}
				}

				if (countA == countC) {
					int start = 0;
					for (int j = 0; j < dim; j++) {
						if (!xNVektor.get(xNVektor.size() - 1).getRMaxKomponente(j)
								.equals(new RMaxZahl(Double.NEGATIVE_INFINITY))) {
							diff = xNVektor.get(xNVektor.size() - 1).getRMaxKomponente(j)
									.rMaxZahlPowerSubtraktion(xNVektor.get(i).getRMaxKomponente(j));
							start = j;
							break;
						}
					}
					for (int j = start + 1; j < dim; j++) {
						if (!diff.equals(xNVektor.get(xNVektor.size() - 1).getRMaxKomponente(j)
								.rMaxZahlPowerSubtraktion(xNVektor.get(i).getRMaxKomponente(j)))) {
							break;
						} else if (j == dim - 1) {
							n1 = xNVektor.size() - 1;
							n2 = i;
							r = diff.getRMaxZahl();
							eigenwert = new RMaxZahl(r / (n1 - n2));
							return true;
						}
					}

				}

			} else {
				countB = 0; // falls vektoren nicht gleich viele eps haben muss countB wieder 0 gesetzt
							// werden (für neuen Vektor)
			}
		}
		return false;
	}

}