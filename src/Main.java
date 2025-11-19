import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner pipe = new Scanner(System.in);

    public static void main(String[] args) {
        String menuChoice = "";
        boolean done = false;
        do {
            displayListWithNumbers();
            displayMenu();
            menuChoice = SafeInput.getRegExString(pipe, "Enter the command [A, D, I, P, Q]: ", "[AaDdIiPpQq]").toUpperCase();
            switch (menuChoice) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    done = quitProgram();
                    break;
            }
        } while (!done);
    }

    private static void addItem() {
        String newItem = SafeInput.getNonZeroLenString(pipe, "Enter the item to add to the list: ");
        list.add(newItem);
    }

    private static void deleteItem() {
        if (list.size() == 0) {
            System.out.println("There are no items to delete");
            return;
        }
        displayListWithNumbers();
        int itemNumToDelete = SafeInput.getRangedInt(pipe, "Enter the number of the item to delete: ", 1, list.size());
        int indexToDelete = itemNumToDelete - 1;
        String deletedItem = list.remove(indexToDelete);
        System.out.println("The item has been deleted: " + deletedItem);
    }

    private static void insertItem() {
        if (list.size() == 0) {
            System.out.println("The list is empty, adding item to #1");
            addItem();
            return;
        }
        int maxLocation = list.size() + 1;
        displayListWithNumbers();
        int locationToInsert = SafeInput.getRangedInt(pipe, "Enter the number to insert the item (1 to " + maxLocation + "): ", 1, maxLocation);
        String newItem = SafeInput.getNonZeroLenString(pipe, "Enter the item to insert: ");
        int indexToInsert = locationToInsert - 1;
        list.add(indexToInsert, newItem);
        System.out.println("The item has been inserted: " + newItem);
    }

    private static void printList() {
        System.out.println("---Current List---");
        displayListWithNumbers();
    }

    private static boolean quitProgram() {
        boolean confirmation = SafeInput.getYNConfirm(pipe, "Are you sure you want to quit? (Y/N): ");
        if (confirmation) {
            System.out.println("Quitting program");
            return true;
        } else {
            System.out.println("Back to the menu");
            return false;
        }
    }

    private static void displayMenu() {
        System.out.println("Menu Options:");
        System.out.println("A - Add Item");
        System.out.println("D - Delete Item");
        System.out.println("I - Insert Item");
        System.out.println("P - Print List");
        System.out.println("Q - Quit");
    }

    private static void displayListWithNumbers() {
        if (list.size() == 0) {
            System.out.println("There are no items to display");
            return;
        }
        System.out.println("---Current List (" + list.size() + "items)---");
        for (int i = 0; i < list.size(); i++) {
            // Corrected to print the 1-based number (i + 1) and the item
            System.out.println((i + 1) + ": " + list.get(i));
        }
    }
}



