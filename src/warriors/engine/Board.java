package warriors.engine;
import warriors.contracts.Map;
import java.util.ArrayList;



public class Board implements Map {

        private int numberOfCase;
        private String nomCases;
//        private ArrayList<Cases> boardLength = new ArrayList<>();


    public Board(String nomCases, int numberOfCase){
            this.nomCases = nomCases;
            this.numberOfCase = numberOfCase;
//        for (int i = 0; i < numberOfCase; i++) {
//            Cases carre = new Cases("Case n° : ", i);
//            boardLength.add(carre);
//            return boardLength;
//        }
        }

        /////GETTER//////
        public String getName() {
            return nomCases;
        }

        public int getNumberOfCase() {
            return numberOfCase;
        }

        /////SETTER//////
//        public void  setNameMap(String newNameMap) {
        public void setName(String newNomCases) {

            this.nomCases = newNomCases;
        }

        public void setNumberOfCase(int newNumberOfCase) {

            this.numberOfCase = newNumberOfCase;
        }

        @Override
        public String toString() {
            return "case n° : " + numberOfCase + " et s'appel : " + nomCases;
        }
    }