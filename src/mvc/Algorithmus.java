package mvc;

import java.util.*;
import strategy.*;

public class Algorithmus implements Beobachtungssubjekt {

	private Loesungsverhalten loesungsverhalten;
	private ArrayList<Beobachter> beobachter;
	private RMaxZahl eigenwert;
	private RMaxVektor eigenvektor;
	private RMaxMatrix matrix;

	/**
	 * Konstruktor Algorithmus Sobald der Algorithmus erstellt wird, wird eine Liste
	 * für die Beobachter angelegt
	 */
	public Algorithmus() {
		beobachter = new ArrayList<Beobachter>();
	}

	@Override
	public void registriereBeobachter(Beobachter b) {
		beobachter.add(b);
	}

	@Override
	public void entferneBeobachter(Beobachter b) {
		beobachter.remove(b);
	}

	@Override
	public void benachrichtigeBeobachter() {
		for (Beobachter b : beobachter) {
			b.aktualisiere(eigenwert, eigenvektor);
		}
	}

	@Override
	public void setLoesungverhalten(Loesungsverhalten verhalten) {
		loesungsverhalten = verhalten;
	}

	@Override
	public void loesenEigenwert() {
		eigenwert = loesungsverhalten.loesenEigenwert(matrix);
		benachrichtigeBeobachter();
	}

	@Override
	public void loesenEigenvektor() {
		eigenvektor = loesungsverhalten.loesenEigenvektor(matrix);
		benachrichtigeBeobachter();
	}

	@Override
	public void setMatrix(double[][] a) {
		this.matrix = new RMaxMatrix(a);
	}

	@Override
	public String ausgabe() {
		return this.matrix.ausgabe();
	}
}