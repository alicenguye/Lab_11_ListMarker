import java.util.Scanner;
import java.util.ArrayList;
public class Main
{
    public static void main(String[] args) {
        ArrayList<String> itemList = new ArrayList<>();
        // create a new scanner
        Scanner in = new Scanner(System.in);
        // declaration of variable
        boolean done = false;
        String itemChoice = "";

        do { 
            itemChoice = displayMenu(in, itemList);
            switch (itemChoice)
            {
               // starting a case for user to choose
                case "A":
                    addItem(in, itemList); 
                    break;
                case "D":
                    deleteItem(in, itemList); 
                    break;
                case "P":
                    displayItem(itemList); 
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to exit")) 
                    {
                        done = true;
                    }
                    break;
            }
        } while (!done);
    }

    // created a new public static class
    public static void addItem(Scanner in, ArrayList itemList)
    {
        String itemAdd = SafeInput.getNonZeroLenString(in, "Type then press enter to add.");
        itemList.add(itemAdd);
    }

    // created a new public static class
    public static void deleteItem(Scanner in, ArrayList itemList)
    {
        // declaration variable in SafeInput
        int itemDelete = SafeInput.getRangedInt(in, "Type list number then enter to delete an item.", 1, itemList.size());
        itemList.remove(itemDelete - 1);
    }

    // created a new public static class
    public static void displayItem(ArrayList itemList)
    {
        for (int i = 0; i < itemList.size(); i++) // start looping
        {
            System.out.println(itemList.get(i)); // output
        }
    }

    // created a new public static class
    private static String displayMenu(Scanner in, ArrayList itemList)
    {
        if (itemList.isEmpty()) // if it empty
        {
            System.out.println("Empty List");
        }
        else // if there is something in the list
        {
            System.out.println("Current list:"); // output
            for (int i = 0; i < itemList.size(); i++) // start looping
            {
                System.out.printf("    %d. %s\n", i + 1 , itemList.get(i)); // output
            }
        }
        return SafeInput.getRegExString(in, "Type then enter to select:\n    A: Add\n    D: Delete\n    P: Print\n    Q: Quit\n", "[AaDdPpQq]").toUpperCase(); // this is what will output
    }
}
