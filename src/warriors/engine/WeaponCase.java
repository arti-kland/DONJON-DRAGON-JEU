package warriors.engine;

public class WeaponCase extends Cases {


    private int weaponAttack;


    public Personnages updateHero(Personnages currentHero){
        if (currentHero.getAttackLevel() < currentHero.getNiveauAttaquekMax()) {
            int newAttak = currentHero.getAttackLevel() + weaponAttack;
            if (newAttak > currentHero.getNiveauAttaquekMax()) {
                newAttak = currentHero.niveauAttaquekMax;
            }
            currentHero.setNiveauAttaque(newAttak);
        }
        return currentHero;
    }

    public WeaponCase (String nameCase, int weaponAttack){

        super(nameCase);
        setWeaponAttack(weaponAttack);

    }

    public void setWeaponAttack(int newWeaponAttack) {

        this.weaponAttack = newWeaponAttack;
    }


    public int getWeaponAttack() {

        return weaponAttack;
    }


    @Override
    public String toString() {

        return " Vous avez trouvez : " + getNameCase() + " vous gagnez : " + getWeaponAttack() + " point d'attaque !\n";
    }
}
