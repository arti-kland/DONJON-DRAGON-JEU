package warriors.engine;

public class NeutralCase extends Cases {
    /**
     * @param nameCase
     */
    public NeutralCase(String nameCase) {
        super(nameCase);
    }

    /**
     * @param currentHero
     * @return
     */
    public Personnages updateHero(Personnages currentHero) {

        return currentHero;
    }
}
