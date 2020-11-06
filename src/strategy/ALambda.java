package strategy;

public class ALambda implements Loesungsverhalten{

	private int dim;
	private Karp algorithmus = new Karp();
	
	/**
	 * Diese Methode wird vom Loesungsverhalten implementiert,
	 * sie wird für den ALambda Algorithmus nicht benötigt und gibt daher "einfach" NUll zurück.
	 */
	@Override
	public RMaxZahl loesenEigenwert(RMaxMatrix a) {
		return null;
	}
	
	/**
	 * Diese Methode wird auch vom Loesungsverhalten implementiert,
	 * in der Methode wird der für den ALambda-Algorithmus benötigte Eigenwert berechnet.
	 * Der Algorithmus berrechnet mit Hilfe des Karp Algorithmus "intern" den Eigenwert.
	 * Der negierte Eigenwert wird benötigt um die Matrix aLambda zu berechnen.
	 * Aus der Matrix "aLambda" wird die Matrix "aLambdaPlus" berechnet.
	 * In dieser Matrix wird anhand der Einträge auf der Diagonalen festgestellt, 
	 * in welcher Spalte der Eigenvektor zum errechneten Eigenwert steht.
	 * Der maximale Eintrag auf der Diagonalen steht hier in der Spalte des Eigenvektors.
	 */
	@Override
	public RMaxVektor loesenEigenvektor(RMaxMatrix a) {
		dim = a.getDimension();
		
		RMaxZahl negEigenwert = new RMaxZahl(-1*algorithmus.loesenEigenwert(a).getRMaxZahl());
		
		RMaxMatrix aLambda = a.rMaxSkalarMultiplikationMatrix(negEigenwert);
		RMaxMatrix aLambdaPlus = new RMaxMatrix(dim);
		
		for (int i = 1; i < dim; i++) {
			aLambdaPlus = aLambdaPlus.rMaxMatrixAddition(aLambda.rMaxMatrixPotenzierung(i));
		}
		
		int spalte = 0;
		double max = Double.NEGATIVE_INFINITY;
		for(int i = 0; i < dim; i++) {
			if(max < aLambdaPlus.getRMaxKomponente(i, i).getRMaxZahl()) {
				max = aLambdaPlus.getRMaxKomponente(i, i).getRMaxZahl();
				spalte = i;
			}
		}
		
		return aLambdaPlus.getRMaxSpalte(spalte);
	}

}
