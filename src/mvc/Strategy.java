package mvc;

import strategy.*;


public interface Strategy {

	/**
	 * Methode setLoesungsverhalten setzt das gewählte Lösungsverhalten beim
	 * Algorithmus
	 * 
	 * @param v zu setzendes Lösungsverhalten
	 */
	public void setLoesungsverhalten(Loesungsverhalten v);

	/**
	 * Methode setMatrix setzt die Matrix, 
	 * auf welche der Algorithmus angewendet wird
	 * 
	 * @param matrix zu setzende Matrix
	 */
	public void setMatrix(double[][] matrix);

	/**
	 * Methode ausgabe gibt die Matrix als "String" in der Gui aus
	 * 
	 * @return Matrix als String
	 */
	public String ausgabe();

	/**
	 * Methode loesenEigenwert berechnet den Eigenwert der Matrix
	 */
	public void loesenEigenwert();

	/**
	 * Methode loesenEigenvektor  berechnet den Eigenvektor der Matrix
	 */
	public void loesenEigenvektor();
}
