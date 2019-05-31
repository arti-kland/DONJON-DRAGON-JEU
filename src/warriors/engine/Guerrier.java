package warriors.engine;

/**
 *
 */
public class Guerrier extends Personnages {

    /**
     * +
     *
     * @param idHero
     * @param classe
     * @param name
     * @param life
     * @param attackLevel
     * @param maxLife
     * @param maxAttackLevel
     */
    public Guerrier(int idHero, String classe, String name, int life, int attackLevel, int maxLife, int maxAttackLevel, String image) {
        super(idHero, classe, name, life, attackLevel, maxLife, maxAttackLevel, image);
    }

    public Guerrier() {
        super();
    }


}
