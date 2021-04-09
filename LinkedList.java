public class LinkedList {

    private Node start;

    public LinkedList(){
        start = null;
    }

    public void displayList()
    {
        Node node;
        if (start == null)
        {
            System.out.println("_____");
            return;
        }
        node = start;
        while (node != null)
        {
            System.out.println(node.info + " ");
            node = node.link;
        }
        System.out.println();
    }
    // display list has ended

    public Weapon weaponSearch(String x){

        Node node = start;
        while (node != null)
        {
            if(node.info.getWeaponName().compareTo(x) == 0 )
                break;
            node = node.link;
        }
        if(node == null)
        {
            System.out.println(x + "Have not been found");
            return null;
        }
        else
            return node.info;

    }
    public void insertFront( Weapon data)
    {
        Node temp = new Node(data);
        temp.link = start;
        start = temp;
    }

    public void deleteNode(String x)
    {
        if(start == null){
            System.out.println("Value " + x + " not present \n");
            return;
        }

        // deleting the first node
        if (start.info.getWeaponName().compareTo(x) ==0)
        {
            start = start.link;
            return;
        }

        // deletion of in between or at the end
        Node node = start;

        while (node.info != null)
        {
            if (node.link.info.getWeaponName().compareTo(x) == 0)
            {
                break;
            }
            node = node.link;
        }
        if (node.link == null)
            System.out.println("Value " + x + " not present /n");
        else
            node.link = node.link.link;

    }



}
