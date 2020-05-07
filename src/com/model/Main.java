package model;
import view.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

/**
 * Main du programme permet de lancer le jeu
 */
public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("entrez les lignes : ");
		int n=sc.nextInt();
		System.out.println("entrez les colonnes :");
		int m=sc.nextInt();
		Puzzle puzzle = new Puzzle(n,m);
		System.out.println("Veuillez choisir le mode de jeu ? \n1- Interface Graphique \n2- Ligne de Commande");
		int choix =sc.nextInt();
		if(choix==1) {
try {
			PuzzleLauncher puzzleLauncher=new PuzzleLauncher(puzzle);
			}
catch(UnsupportedAudioFileException| IOException| LineUnavailableException e) {
	System.out.println("erreur de chargement");
}
		}
		else{
		puzzle.afficheGrid();
		System.out.println("");
		System.out.println( puzzle.getEmptyPiece().toString());

		System.out.println(puzzle.movablePiecesDirection());
		System.out.println("--------");
		int randomNumber=2;
		puzzle.mixGrid(randomNumber);
		puzzle.play();
		}


		
		
			

	}

}
