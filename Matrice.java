package prog.objet.projet.utilities;

public class Matrice<T> {
	private Object[][] m_matrice;

	public Matrice(int p_nbLigne, int p_nbColonne) {
		this.m_matrice = new Object[p_nbLigne][p_nbColonne];
	}

	public int NbLigne() {
		return this.m_matrice.length;
	}

	public int NbColonne() {
		return this.m_matrice[0].length;
	}

	@SuppressWarnings("unchecked")
	public T GetValue(int p_indiceLigne, int p_indiceColonne) {
		return (T) this.m_matrice[p_indiceLigne][p_indiceColonne];
	}

	public Matrice<T> GetLigne(int p_ligne) {
		Matrice<T> ligne = new Matrice<>(1, this.NbColonne());
		for (int i = 0; i < this.NbColonne(); i++) {
			ligne.SetValue(0, i, this.GetValue(p_ligne, i));
		}
		return ligne;
	}

	public Matrice<T> GetColonne(int p_colonne) {
		Matrice<T> colonne = new Matrice<>(1, this.NbLigne());
		for (int i = 0; i < this.NbColonne(); i++) {
			colonne.SetValue(0, i, this.GetValue(i, p_colonne));
		}
		return colonne;
	}

	public Matrice<T> GetDiagonal1() {
		Matrice<T> diago = new Matrice(1, this.NbLigne());

		for (int i = 0; i < this.NbLigne(); i++) {
			diago.SetValue(0, i, this.GetValue(i, i));
		}

		return diago;
	}

	public Matrice<T> GetDiagonal2() {
		Matrice<T> diago = new Matrice<>(1, this.NbLigne());

		for (int i = this.m_matrice.length - 1; i >= 0; i--) {
			for (int j = 0; j < this.NbColonne(); j++) {
				diago.SetValue(0, j, this.GetValue(i, j));
			}
		}

		return diago;
	}

	public void SetValue(int p_ligneIndice, int p_colonneIndice, T value) {
		this.m_matrice[p_ligneIndice][p_colonneIndice] = value;
	}

	public void SetAllValueTo(T p_value) {
		for (int l = 0; l < this.m_matrice.length; l++) {
			for (int c = 0; c < this.m_matrice[l].length; c++) {
				this.m_matrice[l][c] = p_value;
			}
		}
	}

	public Boolean IsFullOfValue(T p_value) {
		Boolean isFull = true;

		for (int i = 0; i < this.NbLigne() && isFull; i++) {
			for (int j = 0; j < this.NbColonne() && isFull; j++) {
				isFull = this.m_matrice[i][j].equals(p_value);
			}
		}

		return isFull;
	}

	public void SetColonne(int p_indexColonne, Object[] p_array) {
		for (int l = 0; l < this.NbLigne(); l++) {
			this.m_matrice[l][p_indexColonne] = p_array[l];
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int l = 0; l < this.NbLigne(); l++) {
			for (int c = 0; c < this.NbColonne(); c++) {
				sb.append(this.GetValue(l, c) + "\t");
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
