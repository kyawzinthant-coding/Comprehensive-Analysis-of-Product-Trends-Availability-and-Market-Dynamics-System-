package product.menu;

import java.util.Scanner;

public class Menu {

    private static Menu instance;
    static Scanner sc=new Scanner(System.in);

    public Menu() {
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    private static void displayMenu(){
        System.out.println("1. Insert a product to existing dataset");
        System.out.println("2. Update a product from existing dataset");
        System.out.println("3. Delete a product from existing dataset");
        System.out.println("4. Reports");
        System.out.println("5. Exit");
    }

    private static String getMenuNo(){
        System.out.print("Option: ");
        String input=sc.nextLine();
        if (!input.matches("[1-5]")) {
            System.out.println("Invalid option. Enter valid option");
            input = getMenuNo();
        }
        return input;
    }

    public void menu(String filePath){
        String input;
        do {
            displayMenu();
            input = getMenuNo();
            switch (input) {
                case "1":
                    // Call insert controller
                    break;
                case "2":
                    // Call update controller
                    break;
                case "3":
                    // Call delete controller
                    break;
                case "4":
                    // Call report controller
                    break;
                case "5":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        } while (!input.equals("5"));
    }

}
