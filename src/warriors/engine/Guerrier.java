package warriors.engine;

public class Guerrier extends Personnages {


public Guerrier (String name, int niveauVie, int niveauAttaque, int niveauVieMax, int niveauAttaqueMax ){
    super(name, niveauVie, niveauAttaque, niveauVieMax, niveauAttaqueMax);
}
    public void setNiveauVie(int newNiveauVie) {

        this.niveauVie = newNiveauVie;
    }

    public void setNiveauAttaque(int newNiveauAttaque) {

        this.niveauAttaque = newNiveauAttaque;
    }


    public int getNiveauVie() {

        return niveauVie;
    }

    public int getNiveauAttaque() {

        return niveauAttaque;
    }

}
