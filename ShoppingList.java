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

... 
case ADD_ITEM: addItem();
 switch (month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
*/

import java.io.BufferedReader;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
import java.nio.file.Paths;

public class ShoppingList {
    static Scanner in = new Scanner(System.in);
    static String shopList[] = new String[10];
    static int position = 0;

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
        shopList[position] = in.next();
        System.out.println(shopList[position] + " was added, enter your next choice: ");
        position++;
    }

    public static void listItems() { //2
        for (int i = 0; i < position; i++) {
            System.out.println(shopList[i]);
        }
        System.out.println("Please, enter your next choice: ");
    }

    public static int countItems (String itemName){
        int count = 0;
        for (String i : shopList) {
            if (i != null && i.equals(itemName)) {
                count++;
            }
        }
        return count;
    }

    public static void deleteAnItem() {
        System.out.println("Enter the item you want to delete from the list: ");
        String item = in.next();
        switcher(item);
        System.out.println("Please, enter your next choice: ");
    }

    public static void delete1 (String itemName) {
        for (int i = 0; i < position; i++) {
            if (shopList[i].equals(itemName)) {
                shopList[i] = null;
            }
        }
        changePositionByOne();
        System.out.println(itemName + " was removed from the list.");
    }

    public static void deleteLast (String itemName){
        //finds the last corresponding item and deletes it, after that exits te loop
        for (int i = shopList.length-1; i > 0; i--) {
            if (shopList[i] != null && shopList[i].equals(itemName)) {
                shopList[i] = null;
                break;
            }
        }
        changePositionByOne();
        System.out.println(itemName + " was removed from the list.");
    }

    public static void deleteAll (String itemName) {
        //this one deletes every corresponding item
        for (int i = 0; i < shopList.length-1; i++) {
            if (shopList[i] != null && shopList[i].equals(itemName)) {
                shopList[i] = null;
                changePositionByOne();
            }
        }
        System.out.println("All " + itemName + " were removed from the list.");
    }

    public static void changePositionByOne() {
        for (int i = 0; i < position; i++) {
            if (shopList[i] == null && i+1 != position){
                shopList[i] = shopList[i+1];
                shopList[i+1] = null;
            }
        }
        position--;
    }

    public static void switcher(String itemName) { //3
        int amount = countItems(itemName);
        if (amount == 1) {
            delete1(itemName);
        }
        else if (amount > 1) {
            System.out.println("There is more than 1 element that corresponds to the name " + itemName);
            System.out.println("Do you want to delete only the last element with this name or all of them? Enter 1 for the first option and 2 for the second: ");
            int choice = in.nextInt();
            if (choice == 1) {
                deleteLast(itemName);
            }
            else if (choice == 2) {
                deleteAll(itemName);
            }
        }
        else {
            System.out.println("The item you have input does not correspond any item in the list.");
        }
    }

    public static void saveListToFile() { //4
        String text = Arrays.toString(shopList);
        try (
                PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get("shoppingList.txt"))))
        {
            writer.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadListFromFile() { //5
        String text; //List<String> list = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("shoppingList.txt")))
        {
            String line = null;
            while ((line = reader.readLine()) != null) {
               // list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
/*
* Scanner sc = new Scanner(new File("myNumbers"));
      while (sc.hasNextLong()) {
          long aLong = sc.nextLong();
      }*/
    }
}