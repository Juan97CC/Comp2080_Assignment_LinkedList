class Weapon
{

    public String weaponName;
    public int range;
    public int damage;
    public double weight;
    public double cost;

    public Weapon(String n, int rang, int dam, double w, double c)
    {
        weaponName = n;
        damage = dam;
        range = rang;
        weight = w;
        cost = c;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public String getWeaponName() {
        return weaponName;
    }

    public int getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }

    public double getWeight() {
        return weight;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString(){
        return weaponName + " " + weight + "lbs ";

    }






}
