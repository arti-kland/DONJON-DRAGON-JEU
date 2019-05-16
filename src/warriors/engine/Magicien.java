package warriors.engine;

public class Magicien extends Personnages {


    public Magicien (String name, int niveauVie, int niveauAttaque ){
        super(name, niveauVie, niveauAttaque);
    }

        /////SETTER/////
         public void setClass(String newClasse) {
            this.classe = newClasse;
        }

        public void setNiveauVie(int newNiveauVie) {
            this.niveauVie = newNiveauVie;
        }

        public void setNiveauAttaque(int newNiveauAttaque) {
            this.niveauAttaque = newNiveauAttaque;
        }

        /////GETTER/////
        public String getClasse() {
            return classe;
        }

        public int getNiveauVie() {
            return niveauVie;
        }

        public int getNiveauAttaque() {
            return niveauAttaque;
         }

}
