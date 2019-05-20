package warriors.engine;

public class BonusCase extends Cases {

    private int bonusLvl;


    public Personnages updateHero(Personnages currentHero){
        if (currentHero.getNiveauVie() < currentHero.getNiveauVieMax()) {
            int newLife = currentHero.getNiveauVie() + bonusLvl;
            if (newLife > currentHero.getNiveauVieMax()){
                newLife = currentHero.niveauVieMax;
            }
            currentHero.setNiveauVie(newLife);
        }
       return currentHero;
    }


    public BonusCase (String nameCase, int bonusLvl){
        super(nameCase);
        setBonusLvl(bonusLvl);
    }

    public void setBonusLvl(int newBonusLvl) {
        this.bonusLvl = newBonusLvl;
    }

    public int getbonusLvl() {
        return bonusLvl;
    }

    @Override
    public String toString() {

        return " Vous avez trouvez : " + getNameCase() + " vous gagnez : " + getbonusLvl() + " point de vie !\n";
    }
}
