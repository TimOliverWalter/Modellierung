package strategy;


import java.util.Arrays;

public class RMaxMatrix {

	private RMaxZahl[][] matrix;
	private int dim;

	/**
	 * Erzeugt eine Identitäsmatrix
	 * 
	 * @param n Dimension dieser Matrix
	 */
	public RMaxMatrix(int n) {
		dim = n;
		matrix = new RMaxZahl[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (i == j) {
					this.matrix[i][j] = new RMaxZahl(0);
				} else {
					this.matrix[i][j] = new RMaxZahl(Double.NEGATIVE_INFINITY);
				}
			}
		}
	}

	/**
	 * Erzeugt aus einem zweidimensionalen Double Array eine Max-Plus-Matrix
	 * 
	 * @param a zweidimensionalen Double Array
	 */
	public RMaxMatrix(double[][] a) {
		dim = a.length;
		matrix = new RMaxZahl[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				this.matrix[i][j] = new RMaxZahl(a[i][j]);
			}
		}
	}

	/**
	 * Diese Methode wird in der GUI zur darstellung der eingegebenen Matrix
	 * benötigt und wandelt die Einträge der Matrix in Strings um
	 * 
	 * @return in String umgewandelte Matrix
	 */
	public String ausgabe() {
		String matrixInhalt = "";

		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				matrixInhalt = matrixInhalt + this.matrix[i][j].toString() + "\t";
			}
			matrixInhalt = matrixInhalt + "\n\n";
		}

		return matrixInhalt;
	}

	/**
	 * @return liefert eine Max-Plus-Matrix
	 */
	public RMaxZahl[][] getRMaxMatrix() {

		return this.matrix;
	}
	
	/**
	 * @param i Zeile die benötigt wird
	 * @return liefert benötigte Zeile der Max-Plus Matrix
	 */
	public RMaxVektor getRMaxZeile(int i) {

		double[] spalte = new double[this.matrix.length];

		for (int j = 0; j < this.matrix.length; j++) {
			spalte[j] = this.matrix[i][j].getRMaxZahl();
		}

		return new RMaxVektor(spalte);
	}

	/**
	 * @param i Spalte die benötigt wird
	 * @return liefert benötigte Spalte der Max-Plus Matrix
	 */
	public RMaxVektor getRMaxSpalte(int i) {

		double[] zeile = new double[this.matrix.length];

		for (int j = 0; j < this.matrix.length; j++) {
			zeile[j] = this.matrix[j][i].getRMaxZahl();
		}

		return new RMaxVektor(zeile);
	}

	/**
	 * 
	 * @param i Zeile
	 * @param j Spalte
	 * @return liefert benötigten Eintrag der Max-Plus-Matrix
	 */
	public RMaxZahl getRMaxKomponente(int i, int j) {
		return this.matrix[i][j];
	}

	/**
	 * @return Matrixdimension
	 */
	public int getDimension() {
		return this.matrix.length;
	}
	
	public void setRMaxMatrixKomponente(RMaxZahl a, int i, int j) {
		this.matrix[i][j] = a;
	}

	/**
	 * Matrix Addition
	 * 
	 * @param a Matrix die zu "this" addiert wird
	 * @return Ergebnismatrix
	 */
	public RMaxMatrix rMaxMatrixAddition(RMaxMatrix a) {
		int dim = this.getDimension();
		double matrix[][] = new double[dim][dim];

		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				RMaxZahl temp = this.getRMaxKomponente(i, j).rMaxZahlAddition(a.getRMaxKomponente(i, j));
				matrix[i][j] = temp.getRMaxZahl();
			}
		}

		return new RMaxMatrix(matrix);
	}

	/**
	 * Vektor-Matrix Multiplikation
	 * 
	 * @param w Vektor der mit der Matrix multipliziert wird
	 * @return Ergebnisvektor
	 */
	public RMaxVektor rMaxMatrixVektorMultiplikation(RMaxVektor w) {
		int dim = this.getDimension();
		RMaxVektor v = new RMaxVektor(dim);

		for (int i = 0; i < dim; i++) {
			RMaxZahl l = new RMaxZahl(Double.NEGATIVE_INFINITY);
			for (int j = 0; j < dim; j++) {
				l = l.rMaxZahlAddition(this.getRMaxKomponente(i, j).rMaxZahlMultiplikation(w.getRMaxKomponente(j)));
			}
			v.setRMaxKomponente(i, l);
		}
		return v;
	}
	
	public RMaxMatrix rMaxMatrixMultiplikation(RMaxMatrix a) {
		RMaxMatrix ergebnis = new RMaxMatrix(dim);
		
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j < dim; j++) {
				ergebnis.setRMaxMatrixKomponente(this.getRMaxZeile(i).rMaxVektorMultiplikation(a.getRMaxSpalte(j)), i, j);
			}
		}
		
		return ergebnis;
	}
	
	public RMaxMatrix rMaxMatrixPotenzierung(int k) {
		RMaxMatrix ergebnis = this;
		
		if (k == 0) {
			return new RMaxMatrix(this.dim);
		}
		else if(k == 1) {
			return ergebnis;
		}
		else {
			for(int i = 0; i < k-1; i++) {
				ergebnis = ergebnis.rMaxMatrixMultiplikation(this);
			}
		}
		
		return ergebnis;
	}
	

	/**
	 * Skalare Multiplikation von RMax Matrix mit RMax Zahl
	 * 
	 * @param a RMax Zahl mit der die Komponenten multipliziert werden
	 * @return Ergebnismatrix
	 */
	public RMaxMatrix rMaxSkalarMultiplikationMatrix(RMaxZahl a) {
		int dim = this.getDimension();
		double matrix[][] = new double[dim][dim];

		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				RMaxZahl temp = this.getRMaxKomponente(i, j).rMaxZahlMultiplikation(a);
				matrix[i][j] = temp.getRMaxZahl();
			}
		}
		return new RMaxMatrix(matrix);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrix);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RMaxMatrix other = (RMaxMatrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		return true;
	}

}
