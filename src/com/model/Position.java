package model;
/**
 * represente la position d'une piece dans une matrice
 * x represente  les lignes et y les colonnes
 */

public class Position {


	private int x;
	private int y;


	/**
	 * constructeur de la classe
	 * @param x valeur de la ligne
	 * @param y valeur de la colonne
	 */
	public Position (int x, int y) {
		this.x=x;
		this.y=y;
	}

	/**
	 * getter de X
	 * @return numero de ligne
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * getter de Y
	 * @return numero de colonne
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * setter de X
	 * @param x numero de ligne
	 */
	public void setX(int x) {
		 this.x=x;
	}

	/**
	 * setter de  Y
	 * @param y numero de colonne
	 */
	public void setY(int y) {
		 this.y=y;
	}

	/**
	 *
	 * @param position la 2eme position pour effectuer la comparaison
	 * @return boolean : true si les positions sont égales sinon false
	 */

	public boolean equalPositions(Position position){
		return this.x==position.getX() && this.y==position.getY();
	}

	/**
	 * redefinition de toString
	 * @return String de la position
	 */
	public String  toString() {
		return "("+this.getX()+","+this.getY()+")";
	}

}
