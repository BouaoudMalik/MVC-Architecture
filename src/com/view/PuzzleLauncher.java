package view;

import model.Puzzle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
/**
*classe qui lance l'ecran principale du jeu
*/
public class PuzzleLauncher extends JFrame implements ActionListener {
   JButton newGameButton,exitButton;
   Puzzle puzzle;
   Dimension dim=new Dimension(600,600);

    /**
     * constructeur de la classe permettant de lancer l'ecran principale avec 2 boutons,
     * new game et exit
     * @param puzzle instance de Puzzle
     * @throws IOException 
     * @throws UnsupportedAudioFileException 
     * @throws LineUnavailableException 
     */
    public PuzzleLauncher(Puzzle puzzle) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        super("Taquin Puzzle Game");
        this.puzzle=puzzle;
 
            String pathToSound="ressources/son/game.wav";
     
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(pathToSound).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(10);
            clip.start();
     
        
        ImageIcon img = new ImageIcon("ressources/images/icone.jpg"); //pour creer une icone
        this.setIconImage(img.getImage());

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String pathBackground="ressources/images/puzzle.jpg";
        ImageIcon background=new ImageIcon(pathBackground);
        JLabel label=new JLabel(background);
        label.setSize(dim);
        super.setSize(dim);
        Container cp=super.getContentPane();
        JPanel panel=new JPanel();
        
        newGameButton=new JButton("New Game");
        newGameButton.setBackground(Color.DARK_GRAY);
        newGameButton.setForeground(Color.lightGray);
        newGameButton.addActionListener(this);

        exitButton=new JButton("Exit Game");
        exitButton.setBackground(Color.DARK_GRAY);
        exitButton.setForeground(Color.lightGray);
        exitButton.addActionListener(this);
      
        panel.add(newGameButton);
        panel.add(exitButton);
	panel.add(label);
        panel.setBackground(Color.lightGray);

        
        cp.add(panel);
        super.setVisible(true);
    }


    /**
     * cette methode permet de lancer une instantiation de la classe puzzle vue
     * si on clique sur le bouton new Game button
     * sort du jeu si on clique sur exit
     * @param e cliquer sur un bouton
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newGameButton){
            PuzzleGui puzzleGui=new PuzzleGui(this.puzzle);
        }
        if(e.getSource()==exitButton) {
           System.exit(0);

        }
    }
}
