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

    public Personnages(String classe, String name, int niveauVie, int niveauAttaque, int niveauVieMax, int niveauAttaquekMax) {
        this.classe = classe;
        this.name = name;
        this.niveauVie = niveauVie;
        this.niveauAttaque = niveauAttaque;
        this.niveauVieMax = niveauVieMax;
        this.niveauAttaquekMax = niveauAttaquekMax;
    }

    /////SETTER/////


    public void setClasse(String newClasse) {

        this.classe = newClasse;
    }

    public void setName(String newName) {

        this.name = newName;
    }

    public void setNiveauVieMax(int newNiveauVieMax) {

        this.niveauVieMax = newNiveauVieMax;
    }

    public void setImage(String newImage) {

        this.image = newImage;
    }

    public void setNiveauVie(int niveauVie) {

        this.niveauVie = niveauVie;
    }

    public void setNiveauAttaque(int niveauAttaque) {

        this.niveauAttaque = niveauAttaque;
    }

    public void setNiveauAttaqueMax(int newNiveauAttaqueMax) {

        this.niveauAttaquekMax = niveauAttaquekMax;
    }

    /////GETTER/////
    public String getClasse() {

        return classe;
    }

    public int getNiveauVie() {

        return niveauVie;
    }

    public int getNiveauVieMax() {

        return niveauVieMax;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getLife() {
        return niveauVie;
    }

    public int getAttackLevel() {

        return niveauAttaque;
    }

    public int getNiveauAttaquekMax() {

        return niveauAttaquekMax;
    }

    @Override
    public String toString() {
        return name + " à " + niveauVie + " points de vie, " + " et " + niveauAttaque + " points d'attaque !";
    }
}
