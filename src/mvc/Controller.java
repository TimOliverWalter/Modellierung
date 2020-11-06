package mvc;

import strategy.*;

public class Controller implements Strategy {

	private Algorithmus alg;
	
	public Controller(Algorithmus alg) {
		new View(alg, this);
		this.alg = alg;
	}

	@Override
	public void setLoesungsverhalten(Loesungsverhalten v) {
		alg.setLoesungverhalten(v);
	}

	@Override
	public void setMatrix(double[][] matrix) {
		alg.setMatrix(matrix);
	}

	@Override
	public String ausgabe() {
		return alg.ausgabe();
	}

	@Override
	public void loesenEigenwert() {
		alg.loesenEigenwert();
	}

	@Override
	public void loesenEigenvektor() {
		alg.loesenEigenvektor();
	}

}