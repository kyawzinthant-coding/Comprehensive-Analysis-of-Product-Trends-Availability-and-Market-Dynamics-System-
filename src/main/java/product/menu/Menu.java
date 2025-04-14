package product.menu;

import product.factory.ReportFactory;
import product.service.DeleteService;
import product.service.InsertService;
import product.service.UpdateService;

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
                    new InsertService(filePath).process();
                    break;
                case "2":
                    new UpdateService(filePath).process();
                    break;
                case "3":
                    new DeleteService(filePath).process();
                    break;
                case "4":
                    ReportFactory reportFactory = new ReportFactory();
                    reportFactory.getReport(filePath).report();
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
