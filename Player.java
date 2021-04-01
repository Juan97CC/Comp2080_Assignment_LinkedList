public class Player
{
    public String name;
    public Backpack backpack;
    public int numItems;
    public double money;
    public double currWeight;
    public double maxWeight;

    public Player(String n, double m)
    {
        name = n;
        money = m;
        numItems = 0;
        backpack = new Backpack();
        currWeight = 0;
        maxWeight = 90;
    }

    public void buy(Weapon w)
    {
        if (currWeight <= maxWeight && money >= w.cost) {
            Backpack.addWeapon(w);

            System.out.println(w.weaponName + " bought...");
            numItems++;
            currWeight += w.weight;
            System.out.println(numItems);
        }
    }
    public void withdraw(double amt)
    {
        money = money - amt;
    }

    public boolean inventoryFull()
    {
        return (numItems == 10) ;
    }

    public void printCharacter()
    {
        System.out.println(" Name:"+name+"\n Money:"+money + "\nBack pack weight" +currWeight);

    }

    public void printBackpack()
    {

        System.out.println(" "+name+", you own "+numItems+" Weapons:");
        backpack.displayTable();

    }

    public void removeBackpackItem(String weapon)
    {
        Weapon v = backpack.search(weapon);
        if (v != null){
            backpack.delete(v);
            currWeight -= v.weight;
            numItems--;


        }



    }



}
