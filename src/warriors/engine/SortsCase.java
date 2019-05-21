package warriors.engine;

public class SortsCase extends WeaponCase {

    private String sortName;
    private String addMessage = "";

    public SortsCase(String nameCase, int weaponAttack) {

        super(nameCase, weaponAttack);
        setSortName(sortName);

    }

    public Personnages updateHero(Personnages currentHero) {
        if (currentHero instanceof Magicien) {
            if (currentHero.getAttackLevel() < currentHero.getNiveauAttaquekMax()) {
                int newAttak = currentHero.getAttackLevel() + weaponAttack;
                if (newAttak > currentHero.getNiveauAttaquekMax()) {
                    newAttak = currentHero.niveauAttaquekMax;
                }
                addMessage += " Vous avez trouvez : " + getNameCase() + " vous gagnez : " + getWeaponAttack() + " point d'attaque !\n";
                currentHero.setNiveauAttaque(newAttak);
            }
        } else {
            addMessage += "Vous n'êtes pas un Magicien ! vous ne pouvez pas utiliser les Sort !! \n";
        }
        return currentHero;
    }

    public void setSortName(String newSortName) {

        this.sortName = newSortName;
    }


    public String getSortName() {

        return sortName;
    }

    @Override
    public String toString() {

        return super.toString() + "\n" + addMessage;
    }
}
