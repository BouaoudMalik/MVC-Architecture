package model;

import java.util.*;

import util.ModelEcoutable;
/**
 *represente une matrice N,M de pieces , ou l'utilisateur
 * a la possibilite de jouer en lignes de commandes
 */
public class Puzzle extends ModelEcoutable {


	private Piece[][] grid;
	private  int n;
	private  int m;


	/**
	 * constructeur de la classe
	 * @param n	nombre de ligne
	 * @param m	nombre de clonne
	 */
	public Puzzle(int n,int m) {
		this.n=n;
		this.m=m;
		this.grid = this.initGrid();

	}



	/**
	 * initialise la grille
	 * @return l'etat initial du puzzle avant le debut de la partie
	 */
	public Piece[][] initGrid() {
		this.grid = new Piece[n][m];
		int c=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				this.grid[i][j] = new Piece(c,i,j);
				c++;
			}
		}
		this.grid[n-1][m-1]=new Piece(0,n-1,m-1);
		return grid;
		
	}
	/**
	 * ce code permet d'afficher la grille
	 */
	public void afficheGrid() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(this.grid[i][j].getIdentifiant());
				System.out.print("   ");
			}
			System.out.println("");
		}
	}
	/**
	 * getter de n (nombre de ligne)
	 * @return nombre de ligne
	 */

	public int getN() {
		return n;
	}

	/**
	 * setter de n (nombre de ligne)
	 * @param n nombre de ligne souhaité
	 */
	public void setN(int n) {
		this.n = n;
	}
	/**
	 * getter de m (nombre de colonne )
	 * @return nombre de clonne
	 */
	public int getM() {
		return m;
	}

	/**
	 * setter de m (nombre de colonne)
	 * @param m nombre de colonne
	 */
	public void setM(int m) {
		this.m = m;
	}

	/**
	 * getter de la grille
	 * @return Piece[][] retourne la grille du puzzle
	 */
	public Piece[][] getGrid(){
		return this.grid;
	}

	/**
	 * vrai : si une piece peut se deplacer,faux sinon
	 * @param piece piece
	 * @return boolean
	 */
	 public boolean isMovable(Piece piece) {
		 Position destination=this.getEmptyPiece().getCurrentPosition();
			
			if(((piece.getCurrentPosition().getX()-1==destination.getX())
						&&(piece.getCurrentPosition().getY()==destination.getY()))
					||((piece.getCurrentPosition().getX()+1==destination.getX())
							&&(piece.getCurrentPosition().getY()==destination.getY()))
					||((piece.getCurrentPosition().getX()==destination.getX())
							&&(piece.getCurrentPosition().getY()-1==destination.getY()))
					||((piece.getCurrentPosition().getX()==destination.getX())
							&&(piece.getCurrentPosition().getY()+1==destination.getY()))) {
				return true;
			}
				
			return false;
			
	 }

	/**
	 * retourne vrai, quand le joueur gagne la partie ,faux sinon
	 * teste si le puzzle courant = puzzle initial
	 * @return boolean
	 */
	public boolean hasWon() {
		Puzzle savedPuzzle =new Puzzle(this.getN(),this.getM());
		int i=0,j=0;
		boolean b=true;
			while((i<n)&&(b)) {
				j=0;
				while((j<m)&&(b)) {
					if(this.grid[i][j].getIdentifiant()!=savedPuzzle.grid[i][j].getIdentifiant()) {
						b=false;
						break; }
					j++;}
				i++;}
		return b;
	}


	/**
	 * retourne la piece vide
	 * @return objet Piece
	 */
	public Piece getEmptyPiece() {
		int i=0;
		while(i<n) {
			int j=0;
			while((j<m) && this.grid[i][j].getIdentifiant() != 0) {
				j++;
			}

			if((i<n)&&(j<m)&&(this.grid[i][j].getIdentifiant() == 0 )) {
				return this.grid[i][j];
			}else {
				i++;
			}


		}
		return null;

	}

	/**
	 * cette methode permet de retourner un map d'identifiant de piece ,dont les valeurs sont
	 * les directions qu'elle peuvent emprunter , une direction pour une piece
	 * @return un Map identifiant : direction
	 */
	public Map<Integer,Direction> movablePiecesDirection(){
		Position destination=this.getEmptyPiece().getCurrentPosition();
		Map<Integer,Direction> Pieces =new LinkedHashMap<>();
		if(((destination.getX()+1)<n)){
			Pieces.put(grid[destination.getX()+1][destination.getY()].getIdentifiant(),Direction.BAS);
		}

		if((destination.getX()-1)>=0){
				Pieces.put(grid[destination.getX()-1][destination.getY()].getIdentifiant(),Direction.HAUT);
		}

		if((destination.getY()+1)<m){
				Pieces.put(grid[destination.getX()][destination.getY()+1].getIdentifiant(),Direction.DROITE);
		}

		if((destination.getY()-1>=0)){
				Pieces.put(grid[destination.getX()][destination.getY()-1].getIdentifiant(),Direction.GAUCHE);
		}


		return Pieces;


		}

	/**
	 * retourne la piece permutee avec la piece vide
	 * @param direction objet de l'enum direction
	 * @return Piece
	 */
	public Piece movablePieces(Direction direction){
	Position destination=this.getEmptyPiece().getCurrentPosition();
	return grid[destination.getX()+direction.getX()][destination.getY()+direction.getY()];
	
	}


	/**
	 * ce code returne le nouveau puzzle apres la permutation
	 * @param piece permutable avec la piece vide
	 * @return Puzzle
	 */
	public Puzzle switchPieces(Piece piece){

		Position empty=this.getEmptyPiece().getCurrentPosition();
		Position piecePosition = new Position(piece.getCurrentPosition().getX(),piece.getCurrentPosition().getY());
		this.grid[empty.getX()][empty.getY()].setIdentifiant(piece.getIdentifiant());
		this.grid[piecePosition.getX()][piecePosition.getY()]=new Piece(0,piecePosition.getX(),piecePosition.getY());
		fireChangement();
	    return new Puzzle(this.n,this.m);
	    

		}

	/**
	 * cette methode retourne une piece aleatoire parmis celles qui peuvent se deplacer
	 * @return Piece
	 */
	public Piece radomInit(){
		Random random=new Random();
		int rand;
		Piece destinationPiece;

		Map<Integer,Direction>switchablePiecesDirection ;
		switchablePiecesDirection= this.movablePiecesDirection();
		List<Integer> indexes = new ArrayList<Integer>(switchablePiecesDirection.keySet());
			rand=random.nextInt(indexes.size());
			int choice=indexes.get(rand);
			destinationPiece=this.movablePieces(switchablePiecesDirection.get(choice));


		return destinationPiece;

	}

	/**
	 * permet d'executer x fois ,un deplacement random en mettant a jour le puzzle
	 * @param randomNumber l'entier indiquant le nombre de permuation a faire
	 */
	public void mixGrid(int randomNumber) {
		Piece destination ;
		Puzzle puzzle = null;
		
		while(randomNumber!=0){

			destination = this.radomInit();
			puzzle = this.switchPieces(destination);
			
			randomNumber--;
			fireChangement();
		}
	
	}

	/** permet d'avoir  un map string : direction
	 * @return    un map dont la cle est un string (une lettre) et la valeur est la direction
	 */
	public HashMap<String,Direction> getMapDirection(){
		HashMap<String,Direction> directions= new HashMap<>();
		directions.put("h",Direction.HAUT);
		directions.put("b",Direction.BAS);
		directions.put("g",Direction.GAUCHE);
		directions.put("d",Direction.DROITE);
		return directions;
	}

	/**
	 * elle permet jouer sans interface graphique
	 */
	public  void play() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		Puzzle puzzle=new Puzzle(this.n,this.m);
		System.out.println("saved grid :");
		puzzle.afficheGrid();
		System.out.println("-------");
		System.out.println("  **************   Debut du jeu  *****************");
		puzzle.mixGrid(10);
		
		while(!puzzle.hasWon()) {
			puzzle.afficheGrid();
			System.out.print("direction possible ");
			System.out.println(puzzle.movablePiecesDirection());
			System.out.println("entrez la premiere lettre des direction possibles(h-b-d-g) :");
			String choix=sc.next();
			sc.nextLine();
			puzzle.switchPieces(puzzle.movablePieces(getMapDirection().get(choix)));
		}
	puzzle.afficheGrid();
	System.out.println("partie terminee!!!");
	}


	
	
    
	

	}
	


