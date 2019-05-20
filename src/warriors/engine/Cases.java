package warriors.engine;

abstract public class Cases {


    private String nameCase;

    public Cases ( String nameCase){

        this.nameCase = nameCase;
    }
    /////SETTER/////


    public void setNameCase(String newNameCase) {
        this.nameCase = newNameCase;
    }

    /////GETTER/////

    public String getNameCase() {
        return nameCase; }

    public abstract Personnages updateHero(Personnages currentHero);


    @Override
    public String toString() {
        return "Vous êtes sur une case de type : " + getClass().getSimpleName();
    }
}

