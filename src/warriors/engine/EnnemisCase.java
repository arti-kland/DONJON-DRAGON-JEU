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
     *
     * @param currentHero
     * @return
     */
    public Personnages updateHero(Personnages currentHero) {
        while (currentHero.getNiveauVie() > 0 && ennemisLife > 0) {
            fight(currentHero);
        }
        return currentHero;
    }

    /**
     *
     * @param nameCase
     * @param ennemisLife
     * @param ennemisAttack
     */
    public EnnemisCase(String nameCase, int ennemisLife, int ennemisAttack) {
        super(nameCase);
        setEnnemisAttack(ennemisAttack);
        setEnnemisLife(ennemisLife);
        addMessage = " Vous êtes tombez sur  : " + getNameCase() + "\n il à une vie de : " + getEnnemisLife() + "\n il à une attaque de : " + getEnemisAttack() +  "\n vous attaquez !\n";
    }

    /**
     *
     * @return
     */
    public String getEnemisName() {
        return enemisName;
    }

    /**
     *
     * @return
     */
    public int getEnemisAttack() {
        return ennemisAttack;
    }

    /**
     *
     * @param newEnemisName
     */
    public void setEnemisName(String newEnemisName) {
        this.enemisName = newEnemisName;
    }

    /**
     *
     * @param newEnnemisLife
     */
    public void setEnnemisLife(int newEnnemisLife) {

        this.ennemisLife = newEnnemisLife;
    }

    /**
     *
     * @param newEnnemisAttack
     */
    public void setEnnemisAttack(int newEnnemisAttack) {

        this.ennemisAttack = newEnnemisAttack;
    }

    /**
     *
     * @return
     */
    public int getEnnemisLife() {

        return ennemisLife;
    }

    /**
     *
     * @return
     */
    public int getWeaponAttack() {

        return ennemisAttack;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {

        return addMessage;
    }

    /**
     *
     * @param currentHero
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
                currentHero.setNiveauVie(currentHero.getNiveauVie() - ennemisAttack);
                addMessage += enemisName + " attaque et vous inflige : " + getWeaponAttack() + " de dégats !\n";

            } else if (critique == 12) {
                currentHero.setNiveauVie(currentHero.getNiveauVie() - (ennemisAttack * 2));
                addMessage += enemisName + " lance CRITIQUE ! et vous inflige : " + (getWeaponAttack() * 2) + " de dégats !\n";
            }

        } else {
            addMessage += "Vous avez tué " + enemisName + "\n";
        }
    }
}
