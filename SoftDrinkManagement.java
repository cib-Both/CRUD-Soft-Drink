import java.util.ArrayList;
import java.util.Scanner;

public class SoftDrinkManagement {
  private static ArrayList<SoftDrink> softDrinks = new ArrayList<>();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    listofSoftDrinks();
    int choice;
    do {
        System.out.println("\n\t <===== MENU =====>");
        System.out.println("\t1: Display list of drink");
        System.out.println("\t2: Search for the drink");
        System.out.println("\t3: Add new drink");
        System.out.println("\t4: Update drink");
        System.out.println("\t5: Delete drink from list");
        System.out.println("\t6: Exit");

        System.out.print("\tEnter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                displaySoftDrinks();
                break;
            case 2:
                searchName();
                break;
            case 3:
                addNewSoftDrink();
                break;
            case 4:
                updateSoftDrink();
                break;
            case 5:
                deleteSoftDrink();
                break;
            case 6:
                System.out.println("\tExiting....");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 6);
}
// The list
private static void listofSoftDrinks() {
    softDrinks.add(new SoftDrink("Coca Cola", 1.50, 20 , 12 , 6 , 2027));
    softDrinks.add(new SoftDrink("Pepsi", 1.40, 15 , 30 , 12 , 2027));
    softDrinks.add(new SoftDrink("Sprite", 1.25, 25 , 1 , 9 , 2027));
}

// Display list
private static void displaySoftDrinks() {
    System.out.println("\n       [ Soft Drinks List ] ");
    for (SoftDrink softDrink : softDrinks) {
        System.out.println(" Name : " + softDrink.getName() + " , Price : $" + softDrink.getPrice() + " , Quantity : " + softDrink.getQuantity() + " , Expire date : " + softDrink.getDay() + "/" + softDrink.getMonth() + "/" + softDrink.getYear());
    }
}

// Search for drink
private static void searchName() {
    System.out.print("Enter name of the soft drink to search: ");
    String name = scanner.nextLine();
    
    for (SoftDrink softDrink : softDrinks) {
        if (softDrink.getName().equalsIgnoreCase(name)) {
            System.out.println("\n       [ Soft Drink Found ] ");
            System.out.println(" Name : " + softDrink.getName() + " , Price : $" + softDrink.getPrice() + " , Quantity : " + softDrink.getQuantity() + " , Expire date : " + softDrink.getDay() + "/" + softDrink.getMonth() + "/" + softDrink.getYear());
            return;
        }
    }
    System.out.println("Soft drink not found!!!");
}


// Add drink in the list
private static void addNewSoftDrink() {
    System.out.print("Enter name of the soft drink: ");
    String name = scanner.nextLine();
    System.out.print("Enter price of the soft drink: ");
    double price = scanner.nextDouble();
    System.out.print("Enter quantity of the soft drink: ");
    int quantity = scanner.nextInt();
    System.out.print("Add Expire date \n");
    System.out.print("Enter day: ");
    int day = scanner.nextInt();
    System.out.print("Enter month: ");
    int month = scanner.nextInt();
    System.out.print("Enter year: ");
    int year = scanner.nextInt();

    softDrinks.add(new SoftDrink(name, price, quantity, day, month, year));
    System.out.println("\t<____Soft drink added successfully____>");
}

//Update drink in the list
private static void updateSoftDrink() {
    System.out.print("Enter name of the soft drink to update: ");
    String name = scanner.nextLine();

    for (SoftDrink softDrink : softDrinks) {
        if (softDrink.getName().equalsIgnoreCase(name)) {
            System.out.print("Enter new price of the soft drink: ");
            double price = scanner.nextDouble();
            softDrink.setPrice(price);
            System.out.print("Enter new quantity of the soft drink: ");
            int quantity = scanner.nextInt();
            softDrink.setQuantity(quantity);
            System.out.print("Update Expire date \n");
            System.out.print("Enter day: ");
            int day = scanner.nextInt();
            softDrink.setDay(day);
            System.out.print("Enter month: ");
            int month = scanner.nextInt();
            softDrink.setMonth(month);
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            softDrink.setYear(year);
            System.out.println("\t<____Soft drink updated successfully>____>");
            return;
        }
    }
    System.out.println("Soft drink not found!!!");
}

// Delete drink in the list
private static void deleteSoftDrink() {
    System.out.print("Enter name of the soft drink to delete: ");
    String name = scanner.nextLine();
    boolean found = false;

    // Iterate through the list backwards to safely remove elements
    for (int i = softDrinks.size() - 1; i >= 0; i--) {
        SoftDrink softDrink = softDrinks.get(i);
        if (softDrink.getName().equalsIgnoreCase(name)) {
            softDrinks.remove(i);
            System.out.println("\t<____Soft drink '" + name + "' deleted successfully____>");
            found = true;
        }
    }

    if (!found) {
        System.out.println("Soft drink not found!!!");
    }
}
}

