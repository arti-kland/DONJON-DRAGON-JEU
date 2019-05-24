package warriors.engine;

public class Magicien extends Personnages {

    /**
     *
     * @param classe
     * @param name
     * @param niveauVie
     * @param niveauAttaque
     * @param niveauVieMax
     * @param niveauAttaqueMax
     */
    public Magicien(String classe, String name, int niveauVie, int niveauAttaque, int niveauVieMax, int niveauAttaqueMax) {
        super(classe, name, niveauVie, niveauAttaque, niveauVieMax, niveauAttaqueMax);
    }

    /////SETTER/////

    /**
     *
     * @param newClasse
     */
    public void setClass(String newClasse) {

        this.classe = newClasse;
    }

    /**
     *
     * @param newNiveauVie
     */
    public void setNiveauVie(int newNiveauVie) {

        this.niveauVie = newNiveauVie;
    }

    /**
     *
     * @param newNiveauAttaque
     */
    public void setNiveauAttaque(int newNiveauAttaque) {

        this.niveauAttaque = newNiveauAttaque;
    }

    /////GETTER/////

    /**
     *
     * @return
     */
    public String getClasse() {

        return classe;
    }

    /**
     *
     * @return
     */
    public int getNiveauVie() {

        return niveauVie;
    }

    /**
     *
     * @return
     */
    public int getNiveauAttaque() {

        return niveauAttaque;
    }

}
