import java.util.Hashtable;

public class Backpack{



    private static LinkedList[] array;
    private static int numItems; // current items in list
    private static int maxItems; // size of array


    public Backpack()
    {
        this(31); // odd number

    }
     public Backpack (int size)
     {
         maxItems = size;
         array = new LinkedList[size];
         numItems= 0;


     }

     public static int hashFunction(String key, int damage, int range)
     {
         int value = 0;
         for (int i = 0; i < key.length() ; i++) {
             value += key.charAt(i);
         }
         value = (value * range) + damage;
         return (value % maxItems);
     }

     public void displayTable()
     {
         //System.out.println("BackPack list : " + numItems);

         for (int i = 0; i < maxItems ; i++) {
             System.out.println("[" + i + "]  --> ");
             if (array[i] != null)
                 array[i].displayList();
             else
                 System.out.println("----");
         }
     }

     public Weapon search(String key, int dam, int range)
     {
         int loc = hashFunction(key.toLowerCase(), dam, range);

         if(array[loc] != null)
             return array[loc].weaponSearch(key);


         return null;
     }

     public static void addWeapon(Weapon weapon)
     {

         String key = weapon.getWeaponName().toLowerCase();
         int dam = weapon.getDamage();
         int range  = weapon.getRange();
         //double weight = weapon.getWeight();
         int loc = hashFunction(key, dam, range);

         if (array[loc] == null)
             array[loc] = new LinkedList();

         array[loc].insertFront(weapon);

         numItems++;
     }

     public void delete(Weapon key)
     {
         String name = key.getWeaponName().toLowerCase();
         int dam = key.getDamage();
         int ran  = key.getRange();
         int loc = hashFunction(name, dam, ran);

         if(array[loc] != null )
         {
             array[loc].deleteNode(key.weaponName);
             numItems--;
         }
         else
             System.out.println("Value " + key + " not present \n");

     }

}
