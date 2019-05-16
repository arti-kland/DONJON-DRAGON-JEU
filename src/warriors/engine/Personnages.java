package warriors.engine;
import warriors.contracts.Hero;

abstract class Personnages implements Hero {

    protected String classe;
    protected String name;
    protected String image;
    protected int niveauVie;
    protected int niveauAttaque;

    public Personnages ( String name, int niveauVie,  int niveauAttaque){
        this.name = name;
        this.niveauVie = niveauVie;
        this.niveauAttaque = niveauAttaque;
    }

        /////SETTER/////
    public void setName(String newName) {
        this.name = newName;
    }

    public void setImage(String newImage) {
        this.image = newImage;
    }

    /////GETTER/////
    public String getName() {
        return name; }

    public String getImage()
    {
        return image; }

    public int getLife()
    {
        return niveauVie; }

    public int getAttackLevel()
    {
        return niveauAttaque;
    }
}
