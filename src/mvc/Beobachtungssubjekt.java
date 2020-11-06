package mvc;

import strategy.*;

public interface Beobachtungssubjekt {

	/**
	 * Methode registriereBeobachter registriert neue Objekte als Beobachter
	 * 
	 * @param b zu registrierender Beobachter
	 */
	public void registriereBeobachter(Beobachter b);

	/**
	 * Methode entferneBeobachter entfernt Objekte die nicht mehr als Beobachter
	 * benötigt werden
	 * 
	 * @param b zu entfernender Beobachter
	 */
	public void entferneBeobachter(Beobachter b);

	/**
	 * Methode benachrichtigeBeobachter benachrichtigt alle Beobachter, sobald sich
	 * im Algorithmus etwas ändert
	 */
	public void benachrichtigeBeobachter();

	/**
	 * Methode setLoesungsverhalten setzt das Lösungsverhalten, welches der
	 * Algorithmus verwenden soll (Power oder Karp)
	 * 
	 * @param verhalten zu setzendes Lösungsverhalten
	 */
	public void setLoesungverhalten(Loesungsverhalten verhalten);

	/**
	 * Methode loesenEigenwert ruft die Methode zum Lösen des Eigenwerts auf und
	 * benachrichtigt danach alle Beobachter.
	 */
	public void loesenEigenwert();

	/**
	 * Methode loesenEigenvektor ruft die Methode zum Lösen des Eigenvektors auf und
	 * benachrichtigt danach alle Beobachter.
	 */
	public void loesenEigenvektor();

	/**
	 * Methode setMatrix setzt die Matrix die in der GUI eingegeben bzw. eingelesen
	 * wird
	 * 
	 * @param a zu setzende Matrix
	 */
	public void setMatrix(double[][] a);

	/**
	 * Methode ausgabe die eingegebene Matrix wird über diese Methode in der GUI
	 * dargestellt
	 * 
	 * @return auszugebende Matrix
	 */
	public String ausgabe();
}