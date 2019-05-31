package warriors.engine;

/**
 *
 */
public class ArmesCase extends WeaponCase {

    private String armeName;
    private String addMessage = "";

    /**
     * @param nameCase
     * @param weaponAttack
     */
    public ArmesCase(String nameCase, int weaponAttack) {

        super(nameCase, weaponAttack);
        setArmeName(armeName);

    }

    /**
     * methode check if the currentHero can pickup the weapon fin on the case sort for magicien and arme for Guerrier
     * and then increment the attack of the currentHero, and check that he's not oversize the maxAttackLevel of the currrentHero
     * @param currentHero = Hero choose by the player
     * @return currentHero + weaponAttack
     */
    public Personnages updateHero(Personnages currentHero) {
        if (currentHero instanceof Guerrier) {
            int newAttak = currentHero.getAttackLevel() + weaponAttack;
            addMessage += " Vous avez trouvez : " + getNameCase() + " vous gagnez : " + getWeaponAttack() + " points d'attaque !\n";
            currentHero.setAttackLevel(newAttak);
        } else {
            addMessage += "Vous n'êtes pas un Guerrier ! vous ne pouvez pas utiliser les Armes !! \n";
        }
        return currentHero;
    }

    /**
     * @return
     */
    @Override
    public String toString() {

        return super.toString() + "\n" + addMessage;
    }

    /**
     * @param newArmeName
     */
    public void setArmeName(String newArmeName) {

        this.armeName = newArmeName;
    }


    /**
     * @return armeName
     */

    public String getArmeName() {

        return armeName;
    }


}
