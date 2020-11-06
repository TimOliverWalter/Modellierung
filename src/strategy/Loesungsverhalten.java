package strategy;


public interface Loesungsverhalten {

	/**
	 * Methode loesenEigenwert Berechnet mit Hilfe des gewählten Algorithmus den
	 * Eigenwert der Matrix
	 * 
	 * @param a Matrix, deren Eigenwert berechnet werden soll
	 * @return Eigenwert der Matrix
	 */
	public RMaxZahl loesenEigenwert(RMaxMatrix a);

	/**
	 * Methode loesenEigenvektor Berechnet mit Hilfe des gewählten Algorithmus den
	 * Eigenvektor der Matrix
	 * 
	 * @param a Matrix, deren Eigenvektor berechnet werden soll
	 * @return Eigenvektor der Matrix
	 */
	public RMaxVektor loesenEigenvektor(RMaxMatrix a);
}
