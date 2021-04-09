import java.util.Scanner;

public class Main {


    public static int getInteger(Scanner sc, String message){
        System.out.print(message);
        while (!sc.hasNextInt())
        {
            sc.nextLine(); //clear the invalid input ...
            //System.out.println(message);
        }
        return sc.nextInt();
    }

    public static double getDouble(Scanner sc,String message){
        System.out.print(message);
        while (!sc.hasNextDouble())
        {
            sc.nextLine(); //clear the invalid input ...
            System.out.print(message);
        }
        return sc.nextDouble();
    }

    public static String getString(Scanner sc, String msg)
    {
        System.out.print(msg);
        while (!sc.hasNextLine()){
            sc.nextLine();
            System.out.println(msg);

        }
        return sc.next();

    }

    public static void WelcomeMenu()
    {
        System.out.println("**********Welcome To DataStructGame***********");
    }



    public static void addWeapons(ArrayManager h,Scanner sc)
    {
        System.out.println("***********WELCOME TO THE WEAPON ADDING MENU*********");
        String weaponName; int weaponRange; int weaponDamage; double weaponWeight; double weaponCost;
        int quantity;
        System.out.print("Please enter the NAME of the Weapon ('end' to quit):");
        weaponName=sc.next();
        while (weaponName.compareTo("end") != 0)
        {
            weaponRange= getInteger(sc,"Please enter the Range of the Weapon (0-10):");
            weaponDamage=getInteger(sc,"Please enter the Damage of the Weapon:");
            weaponWeight= getDouble(sc,"Please enter the Weight of the Weapon (in pounds):");
            weaponCost=getDouble(sc,"Please enter the Cost of the Weapon:");
            Weapon w = new Weapon(weaponName.toLowerCase(), weaponRange, weaponDamage, weaponWeight, weaponCost);
            quantity=getInteger(sc,"Please enter the quantity in stock:");
            h.put(w,quantity);
            System.out.print("Please enter the NAME of another Weapon ('end' to quit):");
            weaponName = sc.next();
        }
    }



    public static void showRoomMenu(ArrayManager ht,Player p){
        System.out.println("WELCOME TO THE SHOWROOM!!!!");
        ht.printTable();
        System.out.println("You have "+p.money+" money.");
        System.out.println("Please select a weapon to buy('end' to quit):");
    }

    public static void showRoom(ArrayManager ht, Player p,Scanner sc)
    {
        String choice;
        showRoomMenu(ht,p);
        choice=sc.next();
        while (choice.compareTo("end") != 0 && !p.inventoryFull())
        {
            ShopItem si = ht.get(choice.toLowerCase());
            if (si != null)
            {


                p.buy(si.item);
               // p.withdraw(si.item.cost);
                si.numberInStock--;

            }
            else
            {
                System.out.println(" ** "+choice+" not found!! **" );
            }
            showRoomMenu(ht,p);
            choice = sc.next();
        }
        System.out.println("");
    }

    public static void mainMenu(ArrayManager ht, Player p, Scanner sc)
    {
        int choice = 0;


        while (choice != 7 && !p.inventoryFull())
        {
            System.out.println("1) Add Items to the shop");
            System.out.println("2) Delete Items from the shop");
            System.out.println("3) Buy from the shop");
            System.out.println("4) View backpack");
            System.out.println("5) View Player");
            System.out.println("6) Delete Backpack item");
            System.out.println("7) Exit");
            choice= getInteger(sc,"Enter a int: ");


            switch (choice){
                case 1:
                    addWeapons(ht,sc);
                    break;
                case 2:
                    System.out.println("delete in shop");
                    break;
                case 3:

                    showRoom(ht, p, sc);
                    break;
                case 4:
                    System.out.println("View in Backpack:");
                    p.printBackpack();
                    System.out.println("Enter any character to continue");
                    String f = sc.next();
                    break;
                case 5:
                    System.out.println("View Character:");
                    p.printCharacter();
                    System.out.println("Enter any character to continue");
                    f = sc.next();
                    break;

                case 6:
                    String name;
                    int range, damage;


                    System.out.println("What is the name of the weapon");
                    name = sc.next();

                    System.out.println("What is the range of the weapon");
                    range = getInteger(sc,"Enter a Int: ");

                    System.out.println("What is the damage of the weapon");
                    damage = getInteger(sc, "Enter a Int: ");

                    p.removeBackpackItem(name.toLowerCase(),damage,range);
                    break;

            }}}











    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);


        String pname;
        WelcomeMenu();
        System.out.println("Please enter Player name:");
        pname=sc.next();
        Player pl= new Player(pname,45);



        ArrayManager ht= new ArrayManager(101);
        //addWeapons(ht,sc);
       // showRoom(ht, pl,sc);
        //pl.printCharacter();

        mainMenu(ht, pl, sc);

    }



}
