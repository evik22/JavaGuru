package JavaGuru;
/*
Create a console shopping list application. Use a string array with a counter to store number of elements used. A sample dialog with the program could look like follows:

This is a shopping list application. Enter your choice:
1 - add an item
2 - list items
3 - delete an item
4 - save list to file
5 - load list from file
6 - exit
>1
Enter item to add: milk
milk added, enter your choice
>9
wrong choice, here are available choices:
1 - add an item
2 - list items
3 - delete an item
4 - save list to file
5 - load list from file
6 - exit
>1
Enter item to add: bread
bread added, enter your choice
>2
milk
bread
>6
Good buy!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class ShoppingListCollections {
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> shopList = new ArrayList<>();

    public final static int ADD_ITEM = 1;
    public final static int LIST_ITEMS = 2;
    public final static int DELETE_ITEM = 3;
    public final static int SAVE_LIST = 4;
    public final static int LOAD_LIST = 5;
    public final static int EXIT = 6;

    public static void main(String[] args) {

        System.out.println("This is a shopping list application. Enter your choice:");
        System.out.println(ADD_ITEM + " - add an item");
        System.out.println(LIST_ITEMS + " - list items");
        System.out.println(DELETE_ITEM + " - delete an item");
        System.out.println(SAVE_LIST + " - save list to file");
        System.out.println(LOAD_LIST + " - load list from file");
        System.out.println(EXIT + " - exit");

        int current;
        while ((current = in.nextInt()) != 6) {
            switch (current) {
                case ADD_ITEM: addAnItem();
                    break;
                case LIST_ITEMS: listItems();
                    break;
                case DELETE_ITEM: deleteAnItem();
                    break;
                case SAVE_LIST: saveListToFile();
                    break;
                case LOAD_LIST: loadListFromFile();
                    break;
                default:
                    System.out.println("This is not an acceptable choice, please choose a number 1-6 to proceed with the process.");
            }
        }
        System.out.println("Good bye!");

    }

    public static void addAnItem() { //1
        System.out.println("Enter item to add: ");
        String item = in.next();
        shopList.add(item);
        System.out.println(item + " was added, enter your next choice: ");
    }

    public static void listItems() { //2
        for (int i = 0; i < shopList.size(); i++) {
            System.out.println(shopList.get(i));
        }
        System.out.println("Please, enter your next choice: ");
    }

    public static int countItems (String itemName){
        return Collections.frequency(shopList, itemName);
    }

    public static void deleteAnItem() {
        System.out.println("Enter the item you want to delete from the list: ");
        String item = in.next();
        switcher(item);
        System.out.println("Please, enter your next choice: ");
    }

    public static void delete1 (String itemName) {
        shopList.remove(itemName);
        System.out.println(itemName + " was removed from the list.");
    }

    public static void deleteAll (String itemName, int count) {
        //this one deletes every corresponding item
        for (int i = 0; i < count; i++) {
            shopList.remove(itemName);
        }
        System.out.println("All " + itemName + " items were removed from the list.");
    }

    public static void switcher(String itemName) { //3
        int amount = countItems(itemName);
        if (amount == 1) {
            delete1(itemName);
        }
        else if (amount > 1) {
            System.out.println("There is more than 1 element that corresponds to the name " + itemName);
            System.out.println("Do you want to delete only one element with this name or all of them? Enter 1 for the first option and 2 for the second: ");
            int choice = in.nextInt();
            if (choice == 1) {
                delete1(itemName);
            }
            else if (choice == 2) {
                deleteAll(itemName, amount);
            }
        }
        else {
            System.out.println("The item you have input does not correspond any item in the list.");
        }
    }

    public static void saveListToFile() { //4
        try ( PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get("shoppingList.txt"))))
        {
            for (String s : shopList){
                writer.println(s);
            }
            System.out.println("Shopping list was successfully saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadListFromFile() { //5
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("shoppingList.txt")))
        {
            String line;
            while ((line = reader.readLine()) != null) {
              shopList.add(line);
            }
            System.out.println("Shopping list was successfully loaded from file. ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
This is a shopping list application. Enter your choice:
1 - add an item
2 - list items
3 - delete an item
4 - save list to file
5 - load list from file
6 - exit
1
Enter item to add:
milk
milk was added, enter your next choice:
1
Enter item to add:
honey
honey was added, enter your next choice:
1
Enter item to add:
salt
salt was added, enter your next choice:
2
milk
honey
salt
Please, enter your next choice:
1
Enter item to add:
salt
salt was added, enter your next choice:
3
Enter the item you want to delete from the list:
salt
There is more than 1 element that corresponds to the name salt
Do you want to delete only one element with this name or all of them? Enter 1 for the first option and 2 for the second:
2
All salt items were removed from the list.
Please, enter your next choice:
2
milk
honey
Please, enter your next choice:
4
Shopping list was successfully saved.
3
Enter the item you want to delete from the list:
milk
milk was removed from the list.
Please, enter your next choice:
3
Enter the item you want to delete from the list:
honey
honey was removed from the list.
Please, enter your next choice:
2
Please, enter your next choice:
5
Shopping list was successfully loaded from file.
2
milk
honey
Please, enter your next choice:
6
Good bye!
 */
