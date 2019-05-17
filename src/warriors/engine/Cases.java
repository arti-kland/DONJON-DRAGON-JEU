package warriors.engine;

abstract public class Cases {

    private String typeCase;
    private String nameCase;

    public Cases ( String nameCase, String typeCase){
        this.typeCase = typeCase;
        this.nameCase = nameCase;
    }
    /////SETTER/////
    public void setTypeCase(String newTypeCase) {
        this.nameCase = newTypeCase;
    }

    public void setNameCase(String newNameCase) {
        this.nameCase = newNameCase;
    }

    /////GETTER/////
    public String getTypeCase() {
        return typeCase; }

    public String getNameCase() {
        return nameCase; }



    @Override
    public String toString() {
        return "Vous êtes sur une case de type : " + typeCase + " qui contient : " + nameCase;
    }
}

