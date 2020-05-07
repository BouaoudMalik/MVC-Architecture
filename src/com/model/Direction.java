package model;
/**
 * enum des direction possible
 * x=-1 pour aller vers le haut ,+1 pour le bas
 * y=-1 pour aller vers la gauche ,+1 pour la droite
 */
public enum Direction {

	HAUT(-1,0),
	BAS(1,0),
	DROITE(0,1),
	GAUCHE(0,-1);
	
	
	private int x,y;

	/**
	 *
	 * @param x entier entre [-1,1]
	 * @param y entier entre [-1,1]
	 */
	Direction(int x,int y){
		this.x=x;
		this.y=y;
	}

	/**
	 * getter de x
	 * @return int
	 */
	public int  getX() {
		return this.x;
	}

	/**
	 * getter de y
	 * @return int
	 */
	public int getY() {
		return this.y;
	}
}
