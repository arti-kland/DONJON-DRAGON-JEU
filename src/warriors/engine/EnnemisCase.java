package warriors.engine;

public class EnnemisCase extends Cases {

    private String enemisName = getNameCase();
    private int ennemisLife;
    private int ennemisAttack;
    private String addMessage = "";

    public Personnages updateHero(Personnages currentHero){
        while (currentHero.getNiveauVie() > 0 && ennemisLife > 0) {
                fight(currentHero);
            }
        return currentHero;
    }


    public EnnemisCase (String nameCase, int ennemisLife, int ennemisAttack){
        super(nameCase);
        setEnnemisAttack(ennemisAttack);
        setEnnemisLife(ennemisLife);
        addMessage = " Vous êtes tombez sur  : " + getNameCase() + "\n vous attaquez !\n";
    }

    public String getEnemisName() {
        return enemisName;
    }

    public void setEnemisName(String newEnemisName) {
        this.enemisName = newEnemisName;
    }

    public void setEnnemisLife(int newEnnemisLife) {

        this.ennemisLife = newEnnemisLife;
    }

    public void setEnnemisAttack(int newEnnemisAttack) {

        this.ennemisAttack = newEnnemisAttack;
    }

    public int getEnnemisLife() {

        return ennemisLife;
    }

    public int getWeaponAttack() {

        return ennemisAttack;
    }

    @Override
    public String toString() {

                    return addMessage;
    }

    public void fight(Personnages currentHero){
      ennemisLife = ennemisLife - currentHero.getAttackLevel();
        if (ennemisLife > 0) {
             currentHero.setNiveauVie(currentHero.getNiveauVie() - ennemisAttack);
            addMessage +=  enemisName + " attaque et vous inflige : " + getWeaponAttack() + " de dégats !\n";

        }else {
            addMessage += "Vous avez tué " + enemisName +  "\n";
        }
    }
}
