package warriors.engine;

import warriors.contracts.Hero;

abstract class Personnages implements Hero {

    protected String classe;
    protected String name;
    protected String image;
    protected int niveauVieMax;
    protected int niveauVie;
    protected int niveauAttaquekMax;
    protected int niveauAttaque;

    /**
     *
     * @param classe
     * @param name
     * @param niveauVie
     * @param niveauAttaque
     * @param niveauVieMax
     * @param niveauAttaquekMax
     */
    public Personnages(String classe, String name, int niveauVie, int niveauAttaque, int niveauVieMax, int niveauAttaquekMax) {
        this.classe = classe;
        this.name = name;
        this.niveauVie = niveauVie;
        this.niveauAttaque = niveauAttaque;
        this.niveauVieMax = niveauVieMax;
        this.niveauAttaquekMax = niveauAttaquekMax;
    }

    /////SETTER/////

    /**
     *
     * @param newClasse
     */
    public void setClasse(String newClasse) {

        this.classe = newClasse;
    }

    /**
     *
     * @param newName
     */
    public void setName(String newName) {

        this.name = newName;
    }

    /**
     *
     * @param newNiveauVieMax
     */
    public void setNiveauVieMax(int newNiveauVieMax) {

        this.niveauVieMax = newNiveauVieMax;
    }

    /**
     *
     * @param newImage
     */
    public void setImage(String newImage) {

        this.image = newImage;
    }

    /**
     *
     * @param niveauVie
     */
    public void setNiveauVie(int niveauVie) {

        this.niveauVie = niveauVie;
    }

    /**
     *
     * @param niveauAttaque
     */
    public void setNiveauAttaque(int niveauAttaque) {

        this.niveauAttaque = niveauAttaque;
    }

    /**
     *
     * @param newNiveauAttaqueMax
     */
    public void setNiveauAttaqueMax(int newNiveauAttaqueMax) {

        this.niveauAttaquekMax = niveauAttaquekMax;
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
    public int getNiveauVieMax() {

        return niveauVieMax;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @return
     */
    public int getLife() {
        return niveauVie;
    }

    /**
     *
     * @return
     */
    public int getAttackLevel() {

        return niveauAttaque;
    }

    /**
     *
     * @return
     */
    public int getNiveauAttaquekMax() {

        return niveauAttaquekMax;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name + " à " + niveauVie + " points de vie, " + " et " + niveauAttaque + " points d'attaque !";
    }
}
