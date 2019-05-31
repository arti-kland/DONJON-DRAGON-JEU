package warriors.engine;

public class SortsCase extends WeaponCase {

    private String sortName;
    private String addMessage = "";

    /**
     * @param nameCase
     * @param weaponAttack
     */
    public SortsCase(String nameCase, int weaponAttack) {

        super(nameCase, weaponAttack);
        setSortName(sortName);

    }

    /**

     * methode check if the currentHero can pickup the weapon fin on the case sort for magicien and arme for Guerrier
     * and then increment the attack of the currentHero, and check that he's not oversize the maxAttackLevel of the currrentHero
     * @param currentHero = Hero choose by the player
     * @return currentHero + weaponAttack
     * */
    public Personnages updateHero(Personnages currentHero) {
        if (currentHero instanceof Magicien) {
            if (currentHero.getAttackLevel() < currentHero.getMaxAttackLevel()) {
                int newAttak = currentHero.getAttackLevel() + weaponAttack;
                if (newAttak > currentHero.getMaxAttackLevel()) {
                    newAttak = currentHero.maxAttackLevel;
                }
                addMessage += " Vous avez trouvez : " + getNameCase() + " vous gagnez : " + getWeaponAttack() + " point d'attaque !\n";
                currentHero.setAttackLevel(newAttak);
            }
        } else {
            addMessage += "Vous n'êtes pas un Magicien ! vous ne pouvez pas utiliser les Sort !! \n";
        }
        return currentHero;
    }

    /**
     * @param newSortName
     */
    public void setSortName(String newSortName) {

        this.sortName = newSortName;
    }

    /**
     * @return
     */
    public String getSortName() {

        return sortName;
    }

    /**
     * @return
     */
    @Override
    public String toString() {

        return super.toString() + "\n" + addMessage;
    }
}
