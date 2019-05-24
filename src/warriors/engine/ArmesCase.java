package warriors.engine;

/**
 *
 */
public class ArmesCase extends WeaponCase {

    private String armeName;
    private String addMessage = "";

    /**
     *
     * @param nameCase
     * @param weaponAttack
     */
    public ArmesCase(String nameCase, int weaponAttack) {

        super(nameCase, weaponAttack);
        setArmeName(armeName);
    }

    /**
     *
     * @param currentHero
     * @return
     */
    public Personnages updateHero(Personnages currentHero) {
        if (currentHero instanceof Guerrier) {
            if (currentHero.getAttackLevel() < currentHero.getNiveauAttaquekMax()) {
                int newAttak = currentHero.getAttackLevel() + weaponAttack;
                if (newAttak > currentHero.getNiveauAttaquekMax()) {
                    newAttak = currentHero.niveauAttaquekMax;
                }
                addMessage += " Vous avez trouvez : " + getNameCase() + " vous gagnez : " + getWeaponAttack() + " point d'attaque !\n";

                currentHero.setNiveauAttaque(newAttak);
            }
        } else {
            addMessage += "Vous n'êtes pas un Guerrier ! vous ne pouvez pas utiliser les Armes !! \n";
        }
        return currentHero;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {

        return super.toString() + "\n" + addMessage;
    }

    /**
     *
     * @param newArmeName
     */
    public void setArmeName(String newArmeName) {

        this.armeName = newArmeName;
    }

    /**
     *
     * @return
     */
    public String getArmeName() {

        return armeName;
    }


}
