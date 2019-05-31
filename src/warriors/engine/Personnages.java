package warriors.engine;

import warriors.contracts.Hero;

public abstract class Personnages implements Hero {

    protected int idHero;
    protected String classe;
    protected String name;
    protected int life;
    protected int maxLife;
    protected int attackLevel;
    protected int maxAttackLevel;
    protected String image;


    /**
     * @param classe
     * @param name
     * @param life
     * @param attackLevel
     * @param maxLife
     * @param maxAttackLevel
     */
    public Personnages(int idHero, String classe, String name, int life, int attackLevel, int maxLife, int maxAttackLevel, String image) {
        this.idHero = idHero;
        this.classe = classe;
        this.name = name;
        this.life = life;
        this.attackLevel = attackLevel;
        this.maxLife = maxLife;
        this.maxAttackLevel = maxAttackLevel;
        this.image = image;
    }

    public Personnages() {

    }

/////SETTER/////

    public void setIdHero(int idHero) {
        this.idHero = idHero;
    }

    /**
     * @param newClasse
     */
    public void setClasse(String newClasse) {

        this.classe = newClasse;
    }

    /**
     * @param newName
     */
    public void setName(String newName) {

        this.name = newName;
    }


    /**
     * @param life
     */
    public void setNiveauVie(int life) {

        this.life = life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setMaxAttackLevel(int maxAttackLevel) {
        this.maxAttackLevel = maxAttackLevel;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /////GETTER/////

    public int getIdHero() {
        return idHero;
    }

    /**
     * @return
     */
    public String getClasse() {

        return classe;
    }

    /**
     * @return
     */
    public int getMaxLife() {
        return maxLife;
    }


    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public int getLife() {
        return life;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getMaxAttackLevel() {
        return maxAttackLevel;
    }


    @Override
    public String getImage() {
        return image;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return name + " à " + life + " points de vie, " + " et " + attackLevel + " points d'attaque !";
    }

}