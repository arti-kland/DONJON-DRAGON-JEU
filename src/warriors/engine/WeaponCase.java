package warriors.engine;

abstract class WeaponCase extends Cases {

    protected int weaponAttack;

    /**
     * @param nameCase
     * @param weaponAttack
     */
    public WeaponCase(String nameCase, int weaponAttack) {

        super(nameCase);
        setWeaponAttack(weaponAttack);

    }

    /**
     * @param newWeaponAttack
     */
    public void setWeaponAttack(int newWeaponAttack) {

        this.weaponAttack = newWeaponAttack;
    }

    /**
     * @return
     */
    public int getWeaponAttack() {

        return weaponAttack;
    }


}
