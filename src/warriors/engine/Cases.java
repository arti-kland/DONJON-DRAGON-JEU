package warriors.engine;


abstract public class Cases {
    private String nameCase;


    /**
     * @param nameCase
     */
    public Cases(String nameCase) {

        this.nameCase = nameCase;
    }

    /**
     * @param newNameCase
     */
    /////SETTER/////
    public void setNameCase(String newNameCase) {

        this.nameCase = newNameCase;
    }

    /////GETTER/////

    /**
     * @return
     */
    public String getNameCase() {

        return nameCase;
    }

    /**
     * @param currentHero
     * @return
     */
    public abstract Personnages updateHero(Personnages currentHero);

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Vous êtes sur une case de type : " + getClass().getSimpleName();
    }
}

