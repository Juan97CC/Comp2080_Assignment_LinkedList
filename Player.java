public class Player
{
    public String name;
    public Backpack backpack;
    public int numItems;
    public double money;
    public double currWeight;
    public double maxWeight;
    public int maxItems;

    public Player(String n, double m)
    {
        name = n;
        money = m;
        numItems = 0;
        backpack = new Backpack();
        currWeight = 0;
        maxWeight = 90;
        maxItems = 10;
    }

    public void buy(Weapon w)
    {
        if ((w.weight + currWeight) <= maxWeight && money >= w.cost && numItems < maxItems )  {
            Backpack.addWeapon(w); // add to list
            withdraw(w.cost); // remove weapon cost from total
            System.out.println(w.weaponName + " bought...");
            numItems++;
            currWeight += w.weight;
            System.out.println(numItems);
            System.out.println(currWeight);
        }

        else System.out.println("Sorry :( transaction could not be completed \n");
    }


    public void withdraw(double amt)
    {
        if (currWeight <= maxWeight && money >= amt && numItems < maxItems) {
            money = money - amt;
        }
    }

    public boolean inventoryFull()
    {
        return (numItems == 10) ;
    }

    public void printCharacter()
    {
        System.out.println("Name: "+name+
                "\nMoney: "+money +
                "\nBack pack weight: " +currWeight+
                "\nCurrent Items(In Backpack): " + numItems);

    }

    public void printBackpack()
    {
        System.out.println(
                name +", you own "+numItems+" of Weapons," +
                "total weight is " + currWeight);
        backpack.displayTable();

    }

    public void removeBackpackItem(String weapon)
    {
        Weapon v = backpack.search(weapon);
        if (v != null){
            backpack.delete(v);
            currWeight -= v.weight;
            numItems--;
            System.out.println("Item has been deleted");
        }
        else System.out.println("Sorry :( item doesn't exist");

    }



}
