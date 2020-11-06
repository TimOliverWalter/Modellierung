package mvc;

import strategy.*;

public class View implements Beobachter {

	private GUI Fenster;
	private Beobachtungssubjekt s;
	private Strategy c;

	public View(Beobachtungssubjekt s, Strategy c) {
		this.s = s;
		this.c = c;
		s.registriereBeobachter(this);
		Fenster = new GUI(c);
	}

	@Override
	public void aktualisiere(RMaxZahl a, RMaxVektor b) {
		Fenster.anzeigen(a, b);
	}

	/**
	 * Methode getStrategy, gibt die Strategy zur�ck 
	 * 
	 * @return	verwendete Strategy
	 */
	public Strategy getStrategy() {
		return this.c;
	}

	/**
	 * Methode getBeobachtungssubjekt, gibt das Beobachtungssubjekt zur�ck
	 * 
	 * @return verwendetes Beobachtungssubjekt
	 */
	public Beobachtungssubjekt getBeobachtungssubjekt() {
		return this.s;
	}

}
