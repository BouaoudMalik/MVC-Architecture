package view;

import model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *represente la fenetre de jeu et 2 bouttons start et exit,
 */
public class PuzzleGui extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	private Puzzle puzzle;
	private Dimension dim=new Dimension(600,600);
	JButton  start=null,exit=null,newGameButton=null,exitButton=null;
	private Container cp;
	private PuzzleVue puzzleVue;

	/**
	 * constructeur de la classe,contenant la VU (le puzzle)
	 * ajoute 2 boutons ,start et exit
	 * @param puzzle instantiation du  modele
	 */
	public PuzzleGui(Puzzle puzzle) {
		super("Taquin Puzzle");

		this.puzzle=puzzle;

		puzzleVue=new PuzzleVue(this.puzzle);
		cp=this.getContentPane();

		ImageIcon img = new ImageIcon("livraison/src/ressources/images/icone.jpg"); //pour creer une icone
		this.setIconImage(img.getImage());

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		puzzleVue.setSize(dim);

		start=new JButton("Start");
		start.setBounds(20,500 ,250 , 50);
		start.setOpaque(true);
		start.setBackground(Color.DARK_GRAY);
		start.setForeground(Color.GREEN);
		start.addActionListener(this);

		exit=new JButton("Exit");
		exit.setBounds(300,500 , 250, 50);
		exit.setOpaque(true);
		exit.setBackground(Color.DARK_GRAY);
		exit.setForeground(Color.RED);
		exit.addActionListener(this);


		cp.add(start);
		cp.add(exit);
		cp.add(puzzleVue);

		super.setSize(this.dim);
		super.setMinimumSize(this.dim);
		super.setResizable(true);


		pack();
		setVisible(true);

	}
	/**
	 *ce code permet de melanger le plateau si on clique sur start
	 * et de quitter le jeu si on clique sur exit
	 * @param e ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==start) {
			this.puzzle.initGrid();	
			this.puzzle.mixGrid(20);
			
		}
		if(e.getSource()==exit) {
			System.exit(0);
		}

		
		
	}

	/**
	 * retourne le container
	 * @return Container
	 */
	public Container getCp() {
		return cp;
	}

	/**
	 * getter de la vu
	 * @return PuzzleVue
	 */
	public PuzzleVue getPuzzleVue() {
		return puzzleVue;
	}
	
	
	
	
}