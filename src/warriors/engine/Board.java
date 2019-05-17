package warriors.engine;
import warriors.contracts.Map;
import java.util.ArrayList;
import java.util.List;


public class Board implements Map {

        private int numberOfCase;
        private String nomBoard;
        private ArrayList<Cases> boardLength = new ArrayList<>();



    public Board(String nomBoard, int numberOfCase){
            this.nomBoard = nomBoard;
            this.numberOfCase = numberOfCase;
            makeCase();
        }

        /////GETTER//////
        public Cases getBoardLength(int pos){
        return boardLength.get(pos);
        }

        public String getName() {
            return nomBoard;
        }

        public int getNumberOfCase() {
            return numberOfCase;
        }

        /////SETTER//////
//        public void  setNameMap(String newNameMap) {
        public void setName(String newNomCases) {

            this.nomBoard = newNomCases;
        }

        public void setNumberOfCase(int numCase){
            this.numberOfCase = numCase;
        }

        public void makeCase(){
            /////CASE ENNEMIES//////
            for ( int j = 0; j < 64; j++) {
                if (j == 45 || j == 52 || j == 56 || j == 62) {
                    Cases carre = new EnnemisCase( "Dragon !", "Ennemi !");
                    boardLength.add(carre);
                } else if (j == 10 || j == 20 || j == 25 || j == 32 || j ==35 || j == 36 || j ==37 || j == 40 || j == 44 || j == 47) {
                    Cases carre = new EnnemisCase( "Sorcier ! !", "Ennemi !");
                    boardLength.add(carre);
                } else if (j == 3 || j == 6 || j == 9 || j == 12 || j == 15 || j == 18 || j == 21 || j == 24 || j ==27 || j ==30){
                    Cases carre = new EnnemisCase( " Gobelin !", "Ennemi !");
                    boardLength.add(carre);
                    ////CASE SURPRISES/////
                } else if (j == 2 || j == 11 || j == 14 || j == 19 || j == 26){
                    Cases carre = new WeaponCase( " Un arc !","Surprise !");
                    boardLength.add(carre);
                } else if (j == 5 || j == 22 || j == 38){
                    Cases carre = new WeaponCase( " Une massue !", "Surprise !");
                    boardLength.add(carre);
                } else if (j == 42 || j == 53){
                    Cases carre = new WeaponCase( " Une épée !", "Surprise !");
                    boardLength.add(carre);
                } else if (j == 1 || j == 4 || j == 8 || j == 17 || j == 23){
                    Cases carre = new WeaponCase( " Un sort éclair !","Surprise !");
                    boardLength.add(carre);
                } else if (j == 48 || j == 49){
                    Cases carre = new WeaponCase( " Un sort boule de feu !", "Surprise !");
                    boardLength.add(carre);
                } else if (j == 7 || j == 13 || j == 28 || j == 29 || j == 33){
                    Cases carre = new BonusCase( " Une potion mineure !","Surprise !");
                    boardLength.add(carre);
                } else if (j == 31 || j == 39 || j == 43){
                    Cases carre = new BonusCase( " Une potion standard !", "Surprise !");
                    boardLength.add(carre);
                }  else if (j == 41){
                    Cases carre = new BonusCase( " Une grande potion !","Surprise !");
                    boardLength.add(carre);
                }  else {
                    Cases carre = new NeutralCase( " Rien !","Neutre !");
                    boardLength.add(carre);
                }
            }
        }

        public List<Cases> getCase(){
            return boardLength;
        }

        @Override
        public String toString() {
            return "case n° : " + numberOfCase + " et s'appel : " + nomBoard;
        }
    }