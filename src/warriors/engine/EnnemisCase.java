package warriors.engine;

/**
 *
 */
public class EnnemisCase extends Cases {

    private String enemisName = getNameCase();
    private int ennemisLife;
    private int ennemisAttack;
    private String addMessage = "";

    /**
     * @param currentHero
     * @return
     */
    public Personnages updateHero(Personnages currentHero) {
        while (currentHero.getLife() > 0 && ennemisLife > 0) {
            fight(currentHero);
        }
        return currentHero;
    }

    /**
     * @param nameCase
     * @param ennemisLife
     * @param ennemisAttack
     */
    public EnnemisCase(String nameCase, int ennemisLife, int ennemisAttack) {
        super(nameCase);
        setEnnemisAttack(ennemisAttack);
        setEnnemisLife(ennemisLife);
        addMessage = " Vous êtes tombez sur  : " + getNameCase() + "\n il à une vie de : " + getEnnemisLife() + "\n il à une attaque de : " + getEnemisAttack() + "\n vous attaquez !\n";
    }

    /**
     * @return
     */
    public String getEnemisName() {
        return enemisName;
    }

    /**
     * @return
     */
    public int getEnemisAttack() {
        return ennemisAttack;
    }

    /**
     * @param newEnemisName
     */
    public void setEnemisName(String newEnemisName) {
        this.enemisName = newEnemisName;
    }

    /**
     * @param newEnnemisLife
     */
    public void setEnnemisLife(int newEnnemisLife) {

        this.ennemisLife = newEnnemisLife;
    }

    /**
     * @param newEnnemisAttack
     */
    public void setEnnemisAttack(int newEnnemisAttack) {

        this.ennemisAttack = newEnnemisAttack;
    }

    /**
     * @return
     */
    public int getEnnemisLife() {

        return ennemisLife;
    }

    /**
     * @return
     */
    public int getWeaponAttack() {

        return ennemisAttack;
    }

    /**
     * @return
     */
    @Override
    public String toString() {

        return addMessage;
    }

    /**
     * Method who manage the fight mode
     * currentHero attack first check if critique is call
     * decrement ennemi of the attackHero
     * check if ennemi still a life
     * if no = currentHero win
     * if yes = check if ennemi call critique
     * decrement currentHero of ennemiAttack
     * check if currentHero still a life
     * if no = gameOver
     * if yes = restart method fight
     * @param currentHero mofify by the fight method
     */
    public void fight(Personnages currentHero) {
        int critique = 1 + (int) (Math.random() * ((20 - 1) + 1));
        if (critique != 10) {
            ennemisLife = ennemisLife - currentHero.getAttackLevel();
            addMessage += " vous infligez : " + currentHero.getAttackLevel() + " de dégats !\n";
        } else {
            ennemisLife = ennemisLife - (currentHero.getAttackLevel() * 2);
            addMessage += " vous lancez CRITIQUE ! et infligez : " + (currentHero.getAttackLevel() * 2) + " de dégats !\n";
        }
        if (ennemisLife > 0) {
            critique = 1 + (int) (Math.random() * ((20 - 1) + 1));
            if (critique != 12) {
                currentHero.setNiveauVie(currentHero.getLife() - ennemisAttack);
                addMessage += enemisName + " attaque et vous inflige : " + getWeaponAttack() + " de dégats !\n";

            } else if (critique == 12) {
                currentHero.setNiveauVie(currentHero.getLife() - (ennemisAttack * 2));
                addMessage += enemisName + " lance CRITIQUE ! et vous inflige : " + (getWeaponAttack() * 2) + " de dégats !\n";
            }

        } else {
            addMessage += "Vous avez tué " + enemisName + "\n";
        }
    }
}
