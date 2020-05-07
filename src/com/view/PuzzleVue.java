package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Direction;
import model.Puzzle;
import util.EcouteurModel;

/**
 * represente la Vu etends Jpanel et implemente EcouteurModele et MouseListener
 */
	
public class PuzzleVue extends JPanel implements EcouteurModel, MouseListener {

	private static final long serialVersionUID = 1L;
	private Puzzle puzzle;
	private static int nb=0;
	private int x,y;
	private final  int POSITIONNEMENT=100;


	/**
	 * constructeur de la classe PuzzleVue
	 * @param puzzle (objet de la classe Puzzle)
	 */
	public PuzzleVue(Puzzle puzzle) {
		this.puzzle=puzzle;
	    puzzle.ajoutEcouteur(this);
	    this.addMouseListener(this);
	}

	/**
	 * getter de NB le nombre de mouvement durant la partie
	 * @return int un entier
	 */
	public static int getNb() {
		return nb;
	}

	/**
	 * redifinition de ModelMisAjour
	 *
	 */
	@Override
	public void modeleMisAJour(Object source) {
		
		this.repaint();
	}

	/**
	 * ce code permet de dessiner toute la grille du jeu
	 * creer des squares  contenant l'identifiant de chaques pieces
	 * et colorie en vert les pieces qui peuvent etre déplacees ,et en rouges celles qui ne le peuvent pas
	 * @param  g objet  de la classe Graphics
	 */
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		this.setBackground(Color.lightGray);
		int i=0;
		int j=0;
		int column=0,line=10,lineStr=50, columnStr=50,width=100, height=100;
		// colonne ligne  largeur hauteur drawrect
		// col ligne drawstring 
		while(i<puzzle.getN()) {
			j=0;
			columnStr=50;
			column=10;
			while(j<puzzle.getM()) {
				if(puzzle.isMovable(puzzle.getGrid()[i][j])) {
				g.setColor(Color.GREEN.darker());}
				else {
					if(puzzle.getGrid()[i][j].emptyPiece()) {
					g.setColor(Color.LIGHT_GRAY.brighter());
				}	else {
					g.setColor(Color.RED);
					}
					
				}
				g.drawRect(column,line, width-10, height-10);			//same ligne colonne change
				g.fillRect(column, line, width-10, height-10);
				g.setColor(Color.black);
				g.drawString(""+puzzle.getGrid()[i][j].getIdentifiant(), columnStr, lineStr);
				columnStr+=100;
				column+=100;
				this.addMouseListener(this);
				j++; 
			}
			line+=100;
			lineStr+=100;
			i++;
		}
	}

	/**
	 *  ce code permet de recuperer la position de la piece sur laquelle on a cliqué
	 *  et fait la permutation avec la piece vide (si c'est possible)
	 * @param e MouseEvent
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

			x=e.getY()/POSITIONNEMENT;
			y=e.getX()/POSITIONNEMENT;
			Map<Integer, Direction> direction =puzzle.movablePiecesDirection();

			try{if(direction.containsKey(puzzle.getGrid()[x][y].getIdentifiant())) {
				nb++;
					puzzle.switchPieces(puzzle.movablePieces(direction.get(puzzle.getGrid()[x][y].getIdentifiant())));


				}}
			catch(ArrayIndexOutOfBoundsException exeption){
			}


			if(puzzle.hasWon()) {
				JOptionPane.showMessageDialog(null,"CONGRATULATION \n***YOU HAVE WON*** \n number of moves : "+PuzzleVue.getNb(),"CONGRATULATION", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
				
			}
			
			
		
	}

	/**
	 * redefinition vide
	 * @param e MouseEvent
	 */
	@Override
	public void mousePressed(MouseEvent e) { }
	/**
	 * redefinition vide
	 * @param e MouseEvent
	 */
	@Override
	public void mouseReleased(MouseEvent e) { }
	/**
	 * redefinition vide
	 * @param e MouseEvent
	 */
	@Override
	public void mouseEntered(MouseEvent e) { }
	/**
	 * redefinition vide
	 * @param e MouseEvent
	 */
	@Override
	public void mouseExited(MouseEvent e) { }

}
