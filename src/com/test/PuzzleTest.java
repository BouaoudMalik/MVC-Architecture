package test;


import model.Direction;
import model.Piece;
import model.Puzzle;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;


public class PuzzleTest{

    Puzzle puzzle = new Puzzle(3,3);

    Piece emtyPiece = puzzle.getEmptyPiece();
    Piece emptyPieceTest = new Piece(0,2,2);

    Boolean ismovablePiece1 = puzzle.isMovable(new Piece(6,1,2));
    Boolean ismovablePiece2 = puzzle.isMovable(new Piece(8,2,1));
    Boolean ismovablePiece3 = puzzle.isMovable(new Piece(2,0,1));

    Piece movablePieceDirection1 = puzzle.movablePieces(Direction.HAUT);
    Piece movablePieceDirection2 = puzzle.movablePieces(Direction.GAUCHE);


    /**
     * afficher le message si le Test se passe bien
     */
    @After
    public void after(){
        System.out.println("Finished !");
    }

    /**
     * comparer les identifiants
     */
    @Test
    public void getEmptyPieceIdTest(){
        assertTrue("ça doit retourner True :"
                ,emptyPieceTest.getIdentifiant()==emtyPiece.getIdentifiant());
    }

    /**
     * comparer les positions
     */
    @Test
    public void getEmptyPiecePositionTest(){
        assertTrue("ça doit retourner True :"
                ,emtyPiece.getCurrentPosition().equalPositions(emptyPieceTest.getCurrentPosition())
                        && emtyPiece.getFinalPosition().equalPositions(emptyPieceTest.getFinalPosition()));
    }

    /**
     * Tester si ismovablePiece1 est permutable avec la piece vide
     */
    @Test
    public void isMovablePiece1Test(){
        assertTrue("ça doit retourner True :", ismovablePiece1);
    }

    /**
     * Tester si ismovablePiece2 est permutable avec la piece vide
     */

    @Test
    public void isMovablePiece2Test(){
        assertTrue("ça doit retourner True :", ismovablePiece2);
    }

    /**
     * Tester si ismovablePiece3 est permutable avec la piece vide
     */
    @Test
    public void isMovablePiece3Test(){
        assertFalse("ça doit retourner False :", ismovablePiece3);
    }

    /**
     * tester si c'est la bonne piece à déplacer dans la bonne direction
     */
    @Test
    public void movablePiece1Test(){
        assertTrue("ça doit retourner True :",
                movablePieceDirection1.equalPieces(new Piece(6,1,2)));
    }

    /**
     * tester si c'est la bonne piece à déplacer dans la bonne direction
     */

    @Test
    public void movablePiece2Test(){
        assertTrue("ça doit retourner True :",
                movablePieceDirection2.equalPieces(new Piece(8,2,1)));
    }






}
