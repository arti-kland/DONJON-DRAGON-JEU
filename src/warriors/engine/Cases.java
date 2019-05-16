package warriors.engine;

public class Cases {

    private String name;
    private int number;

    public Cases ( int number, String name){
        this.name = name;
        this.number = number;
    }
    /////SETTER/////
    public void setName(String newName) {
        this.name = newName;
    }

    public void setNumber(int newNumber) {
        this.number = newNumber;
    }
    /////GETTER/////
    public String getName() {
        return name; }

    public int getNumber() {
        return number; }

}

