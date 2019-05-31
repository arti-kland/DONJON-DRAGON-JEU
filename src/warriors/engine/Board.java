package warriors.engine;

import warriors.contracts.Map;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Board implements Map {

    private int numberOfCase;
    private String nomBoard;
    private ArrayList<Cases> boardLength = new ArrayList<>();

    /**
     * @param nomBoard
     * @param numberOfCase
     */
    public Board(String nomBoard, int numberOfCase) {
        this.nomBoard = nomBoard;
        this.numberOfCase = numberOfCase;
//        makeCase();
    }

    /////GETTER//////

    /**
     * @param pos
     * @return
     */
    public Cases getBoardLength(int pos) {

        return boardLength.get(pos);
    }

    /**
     * @return
     */
    public String getName() {

        return nomBoard;
    }

    /**
     * @return
     */
    public int getNumberOfCase() {

        return numberOfCase;
    }

    /////SETTER//////

    /**
     * @param newNomCases
     */
    public void setName(String newNomCases) {

        this.nomBoard = newNomCases;
    }

    /**
     * @param numCase
     */
    public void setNumberOfCase(int numCase) {

        this.numberOfCase = numCase;
    }

    /**
     *
     */
//    public void makeCase() {
//        if (nomBoard.equals("Easy - Promenons nous dans les bois !")) {
//            makeCaseEasy();
//        } else if (nomBoard.equals("Medium - Promenons nous dans le cimetière !!")) {
//            makeCaseMedium();
//        } else if (nomBoard.equals("Hard - Promenons nous en enfert !!!")) {
//            makeCaseHard();
//        }
//    }

    /**
     *
     //     */
//    public void makeCaseEasy() {
//        /////CASE ENNEMIES//////
//        for (int j = 0; j < 64; j++) {
//            if (j == 37 || j == 40 || j == 45 || j == 47 || j == 52 || j == 56 || j == 62) {
//                Cases carre = new EnnemisCase("Dragon ", 15, 4);
//                boardLength.add(carre);
//            } else if (j == 10 || j == 20 || j == 25 || j == 32 || j == 35 || j == 36 || j == 44) {
//                Cases carre = new EnnemisCase("Sorcier ", 9, 2);
//                boardLength.add(carre);
//            } else if (j == 3 || j == 6 || j == 9 || j == 12 || j == 15 || j == 18 || j == 21 || j == 24 || j == 27 || j == 30) {
//                Cases carre = new EnnemisCase(" Gobelin ", 6, 1);
//                boardLength.add(carre);
//                ////CASE WEAPON/////
//            } else if (j == 2 || j == 11 || j == 14 || j == 19 || j == 26) {
//                Cases carre = new ArmesCase(" Un arc !", 1);
//                boardLength.add(carre);
//            } else if (j == 5 || j == 22 || j == 38) {
//                Cases carre = new ArmesCase(" Une massue !", 3);
//                boardLength.add(carre);
//            } else if (j == 42 || j == 53) {
//                Cases carre = new ArmesCase(" Une épée !", 5);
//                boardLength.add(carre);
//            } else if (j == 1 || j == 4 || j == 8 || j == 17 || j == 23) {
//                Cases carre = new SortsCase(" Un sort éclair !", 2);
//                boardLength.add(carre);
//            } else if (j == 48 || j == 49) {
//                Cases carre = new SortsCase(" Un sort boule de feu !", 7);
//                boardLength.add(carre);
//                ////CASE BONUS/////
//            } else if (j == 7 || j == 13 || j == 28 || j == 29 || j == 33) {
//                Cases carre = new BonusCase(" Une potion mineure !", 1);
//                boardLength.add(carre);
//            } else if (j == 31 || j == 39 || j == 43) {
//                Cases carre = new BonusCase(" Une potion standard !", 2);
//                boardLength.add(carre);
//            } else if (j == 41) {
//                Cases carre = new BonusCase(" Une grande potion !", 5);
//                boardLength.add(carre);
//            } else {
//                Cases carre = new NeutralCase(" Rien !");
//                boardLength.add(carre);
//            }
//        }
//    }
//
//    /**
//     *
//     */
//    public void makeCaseMedium() {
//        /////CASE ENNEMIES//////
//        for (int j = 0; j < 64; j++) {
//            if (j == 37 || j == 38 || j == 40 || j == 44 || j == 45 || j == 47 || j == 52 || j == 56 || j == 62) {
//                Cases carre = new EnnemisCase("Dragon ", 15, 4);
//                boardLength.add(carre);
//            } else if (j == 10 || j == 20 || j == 21 || j == 24 || j == 27 || j == 30 || j == 25 || j == 32 || j == 35 || j == 36) {
//                Cases carre = new EnnemisCase("Sorcier ", 9, 2);
//                boardLength.add(carre);
//            } else if (j == 3 || j == 6 || j == 9 || j == 12 || j == 15 || j == 18) {
//                Cases carre = new EnnemisCase(" Gobelin ", 6, 1);
//                boardLength.add(carre);
//                ////CASE WEAPON/////
//            } else if (j == 2 || j == 11 || j == 14 || j == 19 || j == 26) {
//                Cases carre = new ArmesCase(" Un arc !", 1);
//                boardLength.add(carre);
//            } else if (j == 5 || j == 22) {
//                Cases carre = new ArmesCase(" Une massue !", 3);
//                boardLength.add(carre);
//            } else if (j == 42 || j == 53) {
//                Cases carre = new ArmesCase(" Une épée !", 5);
//                boardLength.add(carre);
//            } else if (j == 4 || j == 8 || j == 17 || j == 23) {
//                Cases carre = new SortsCase(" Un sort éclair !", 2);
//                boardLength.add(carre);
//            } else if (j == 48 || j == 49) {
//                Cases carre = new SortsCase(" Un sort boule de feu !", 7);
//                boardLength.add(carre);
//                ////CASE BONUS/////
//            } else if (j == 7 || j == 13 || j == 28) {
//                Cases carre = new BonusCase(" Une potion mineure !", 1);
//                boardLength.add(carre);
//            } else if (j == 31 || j == 43) {
//                Cases carre = new BonusCase(" Une potion standard !", 2);
//                boardLength.add(carre);
//            } else if (j == 41) {
//                Cases carre = new BonusCase(" Une grande potion !", 5);
//                boardLength.add(carre);
//            } else {
//                Cases carre = new NeutralCase(" Rien !");
//                boardLength.add(carre);
//            }
//        }
//    }
//
//    /**
//     *
//     */
//    public void makeCaseHard() {
//        /////CASE ENNEMIES//////
//        for (int j = 0; j < 64; j++) {
//            if (j == 32 || j == 35 || j == 36 || j == 37 || j == 38 || j == 40 || j == 44 || j == 45 || j == 47 || j == 52 || j == 56 || j == 62) {
//                Cases carre = new EnnemisCase("Dragon ", 15, 4);
//                boardLength.add(carre);
//            } else if (j == 12 || j == 15 || j == 18 || j == 10 || j == 20 || j == 21 || j == 24 || j == 27 || j == 30 || j == 25) {
//                Cases carre = new EnnemisCase("Sorcier ", 9, 2);
//                boardLength.add(carre);
//            } else if (j == 3 || j == 6 || j == 9) {
//                Cases carre = new EnnemisCase(" Gobelin ", 6, 1);
//                boardLength.add(carre);
//                ////CASE WEAPON/////
//            } else if (j == 2 || j == 11 || j == 14 || j == 19) {
//                Cases carre = new ArmesCase(" Un arc !", 1);
//                boardLength.add(carre);
//            } else if (j == 5 || j == 22) {
//                Cases carre = new ArmesCase(" Une massue !", 3);
//                boardLength.add(carre);
//            } else if (j == 42) {
//                Cases carre = new ArmesCase(" Une épée !", 5);
//                boardLength.add(carre);
//            } else if (j == 8 || j == 17 || j == 23) {
//                Cases carre = new SortsCase(" Un sort éclair !", 2);
//                boardLength.add(carre);
//            } else if (j == 49) {
//                Cases carre = new SortsCase(" Un sort boule de feu !", 7);
//                boardLength.add(carre);
//                ////CASE BONUS/////
//            } else if (j == 7 || j == 13) {
//                Cases carre = new BonusCase(" Une potion mineure !", 1);
//                boardLength.add(carre);
//            } else if (j == 41) {
//                Cases carre = new BonusCase(" Une potion standard !", 2);
//                boardLength.add(carre);
//            } else if (j == 43) {
//                Cases carre = new BonusCase(" Une grande potion !", 5);
//                boardLength.add(carre);
//            } else {
//                Cases carre = new NeutralCase(" Rien !");
//                boardLength.add(carre);
//            }
//        }
//    }

    /**
     * @return
     */
    public List<Cases> getCase() {

        return boardLength;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "case n° : " + numberOfCase + " et s'appel : " + nomBoard;
    }
}