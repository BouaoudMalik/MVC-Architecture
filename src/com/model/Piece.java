package model;
/**
 *  represente les pieces du puzzle
 */
public class Piece {


	private int identifiant;
	private Position currentPosition;
	private Position finalPostion;

	/**
	 *
	 * @param identifiant la valeur de la piece
	 * @param positionX	   la valeur de sa ligne
	 * @param positionY		la valeur de sa colonne
	 */
	public Piece(int identifiant,int positionX,int positionY) {
	 this.identifiant=identifiant;
	 this.currentPosition = new Position (positionX,positionY);
	 this.finalPostion = currentPosition;
	}

	/**
	 *getter de CurrentPosition
	 * @return une position courante
	 */
	public Position getCurrentPosition(){
		return this.currentPosition;
	}

	/**
	 *  change CurrentPosition par une nouvelle position
	 * @param p position
	 */
	public void setNewPosition(Position p){
		this.currentPosition.setX(p.getX());
		this.currentPosition.setY(p.getY());
	}

	/**
	 *getter de FinalPosition
	 * @return une position final
	 */
	public Position getFinalPosition(){
		return this.finalPostion;
	}

	/**
	 * setter des position
	 * @param x valeur de ligne
	 * @param y valeur de la colonne
	 */
	public void setPosition(int x,int y){
		@SuppressWarnings("unused")
		int x1 = this.getCurrentPosition().getX();
		@SuppressWarnings("unused")
		int y1 = this.getCurrentPosition().getY();
		x1 = x;
		y1 = y;

	}

	/**
	 * setter de l'identifiant
	 * @param id identifiant de la pièce
	 */
	public void setIdentifiant(int id){
		this.identifiant=id;
	}

	/**
	 * retourne vrai si currentPosition est la meme que finalPosition
	 * @return boolean
	 */
	public boolean goodPosition() {
		return this.currentPosition.getX()==this.finalPostion.getX()
				&& this.currentPosition.getY()==this.finalPostion.getY();
	}

	/**
	 * retourne vrai si l'identifiant =0 ,faux sinon
	 * @return boolean
	 */
	public boolean emptyPiece(){
		return this.identifiant==0;
	}

	/**
	 * getter de l'identifiant
	 * @return int
	 */
	public int getIdentifiant() {
		return this.identifiant;
	}

	/**
	 *
	 * @param piece la 2eme piece pour faire la comparaison
	 * @return boolean : true si les 2 pieces sont égales sinon false
	 */

	public boolean equalPieces(Piece piece){
		return this.identifiant == piece.getIdentifiant()
				&& this.currentPosition.equalPositions(piece.getCurrentPosition())
				&& this.finalPostion.equalPositions(piece.getFinalPosition());
	}

	/**
	 * redefinition de la methode toString
	 * @return String de la piece
	 */
	@Override
	public String toString(){
		return "("+this.getIdentifiant()+",position courante"+this.getCurrentPosition()+",position suivante :"+this.getFinalPosition()+")";
	}


	
}
