package mvc;

import strategy.*;

public interface Beobachter {

	/**
	 * Methode aktualisiere sobald ein Eigenwert oder Eigenvektor errechnet wurde,
	 * wird das Ergebnis aktualisiert und an die GUI übermittelt
	 * 
	 * @param a errechneter Eigenwert
	 * @param b errechneter Eigenvektor
	 */
	public void aktualisiere(RMaxZahl a, RMaxVektor b);
}
