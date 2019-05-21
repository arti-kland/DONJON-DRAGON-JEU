package warriors.engine;

abstract class WeaponCase extends Cases {

    protected int weaponAttack;


    public WeaponCase(String nameCase, int weaponAttack) {

        super(nameCase);
        setWeaponAttack(weaponAttack);

    }


    public void setWeaponAttack(int newWeaponAttack) {

        this.weaponAttack = newWeaponAttack;
    }

    public int getWeaponAttack() {

        return weaponAttack;
    }


}
