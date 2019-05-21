package warriors.engine;

public class Magicien extends Personnages {


    public Magicien(String classe, String name, int niveauVie, int niveauAttaque, int niveauVieMax, int niveauAttaqueMax) {
        super(classe, name, niveauVie, niveauAttaque, niveauVieMax, niveauAttaqueMax);
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
