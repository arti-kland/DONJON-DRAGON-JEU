package warriors.engine;

public class Magicien extends Personnages {

    /**
     * @param idHero
     * @param classe
     * @param name
     * @param life
     * @param attack
     * @param maxLife
     * @param maxAttackLevel
     * @param image
     */
    public Magicien(int idHero, String classe, String name, int life, int attack, int maxLife, int maxAttackLevel, String image) {
        super(idHero, classe, name, life, attack, maxLife, maxAttackLevel, image);
    }

    /////SETTER/////

    /**
     * @param newClasse
     */
    public void setClass(String newClasse) {

        this.classe = newClasse;
    }

    /**
     * @param newLife
     */
    public void setLife(int newLife) {

        this.life = newLife;
    }


    /////GETTER/////

    /**
     * @return
     */
    public String getClasse() {

        return classe;
    }

    /**
     * @return
     */
    public int getLife() {

        return life;
    }


}
