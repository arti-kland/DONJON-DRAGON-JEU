package warriors.engine;

/**
 *
 */
public class Guerrier extends Personnages {

    /**
     *
     * @param classe
     * @param name
     * @param niveauVie
     * @param niveauAttaque
     * @param niveauVieMax
     * @param niveauAttaqueMax
     */
    public Guerrier(String classe, String name, int niveauVie, int niveauAttaque, int niveauVieMax, int niveauAttaqueMax) {
        super(classe, name, niveauVie, niveauAttaque, niveauVieMax, niveauAttaqueMax);
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
