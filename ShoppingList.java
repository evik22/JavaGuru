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

import java.util.Scanner;

public class ShoppingList {
    static Scanner in = new Scanner(System.in);
    static String shopList[] = new String[10];
    static int position = 0; //to save products position in an array

    public static void main(String[] args) {

        System.out.println("This is a shopping list application. Enter your choice:");
        System.out.println("1 - add an item");
        System.out.println("2 - list items");
        System.out.println("3 - delete an item");
        System.out.println("4 - save list to file");
        System.out.println("5 - load list from file");
        System.out.println("6 - exit");

        int current;
        while ((current = in.nextInt()) != 0) { //1 - add an item
            if (current == 1) {
                System.out.println("Enter item to add: ");
                String item = in.nextLine();
                addAnItem(item);
                position++;
            }
            else if (current == 2) {
                listItems();
            }
        }

    }

    public static void addAnItem(String newItem) { //1

        shopList[position] = newItem;
    }

    public static void listItems() { //2
        for (int i = 0; i < shopList.length; i++) {
            if (!(shopList[i].equals(" "))) {
                System.out.println(shopList[i]);
            }
        }
    }

    public void deleteAnItem(String itemName) {

    }
    public static void saveListToFile() {

    }
    public static void loadListFromFile() {
/*
* Scanner sc = new Scanner(new File("myNumbers"));
      while (sc.hasNextLong()) {
          long aLong = sc.nextLong();
      }*/
    }
}
