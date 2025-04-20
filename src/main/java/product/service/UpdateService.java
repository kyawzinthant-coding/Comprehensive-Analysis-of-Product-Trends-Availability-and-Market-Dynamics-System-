package product.service;

import product.Template.ProductCSVHandler;
import product.model.Product;
import java.util.LinkedList;
import java.util.Scanner;

public class UpdateService extends ProductCSVHandler {
    private Scanner scanner;

    public UpdateService(String filePath) {
        super(filePath);
        this.scanner = new Scanner(System.in);
    }

    @Override
    protected void operate(LinkedList<Product> products) {
        String name = userInput.getName();
        String category = userInput.getCategory();

        int index = search.searchByName_and_Category(products, name, category);
        if (index < 0) {
            System.out.println("Product not found");
            return;
        }

        Product product = products.get(index);
        System.out.println("Update Product  ( Price ,Stock , Availability )");

        System.out.println("Current Price" + product.getPrice());
        product.setPrice(Integer.parseInt(userInput.getPrice()));

        System.out.println("Current Stock" + product.getStock());
        product.setStock(Integer.parseInt(userInput.getStock()));


        System.out.println("Current Availability" + product.getAvailability());
        product.setAvailability(userInput.getAvailability());

//        while (continueUpdating) {
//            System.out.println("\nCurrent Product Details:");
//            System.out.println(product.toString());
//            System.out.println("\nWhat would you like to update?");
//            System.out.println("1. Name (Current: " + product.getName() + ")");
//            System.out.println("2. Description (Current: " + product.getDescription() + ")");
//            System.out.println("3. Brand (Current: " + product.getBrand() + ")");
//            System.out.println("4. Price (Current: " + product.getPrice() + ")");
//            System.out.println("5. Currency (Current: " + product.getCurrency() + ")");
//            System.out.println("6. Stock (Current: " + product.getStock() + ")");
//            System.out.println("7. Color (Current: " + product.getColor() + ")");
//            System.out.println("8. Size (Current: " + product.getSize() + ")");
//            System.out.println("9. Availability (Current: " + product.getAvailability() + ")");
//            System.out.println("0. Save and Exit");
//
//            System.out.print("\nEnter your choice (0-9): ");
//            String choice = scanner.nextLine();
//
//            switch (choice) {
//                case "1":
//                    System.out.print("Enter new name: ");
//                    product.setName(scanner.nextLine());
//                    break;
//                case "2":
//                    System.out.print("Enter new description: ");
//                    product.setDescription(scanner.nextLine());
//                    break;
//                case "3":
//                    System.out.print("Enter new brand: ");
//                    product.setBrand(scanner.nextLine());
//                    break;
//                case "4":
//                    System.out.print("Enter new price: ");
//                    try {
//                        product.setPrice(Integer.parseInt(scanner.nextLine()));
//                    } catch (NumberFormatException e) {
//                        System.out.println("Invalid price format. Please enter a number.");
//                    }
//                    break;
//                case "5":
//                    System.out.print("Enter new currency: ");
//                    product.setCurrency(scanner.nextLine());
//                    break;
//                case "6":
//                    System.out.print("Enter new stock: ");
//                    try {
//                        product.setStock(Integer.parseInt(scanner.nextLine()));
//                    } catch (NumberFormatException e) {
//                        System.out.println("Invalid stock format. Please enter a number.");
//                    }
//                    break;
//                case "7":
//                    System.out.print("Enter new color: ");
//                    product.setColor(scanner.nextLine());
//                    break;
//                case "8":
//                    System.out.print("Enter new size: ");
//                    product.setSize(scanner.nextLine());
//                    break;
//                case "9":
//                    System.out.print("Enter new availability: ");
//                    product.setAvailability(scanner.nextLine());
//                    break;
//                case "0":
//                    continueUpdating = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }

        System.out.println("Product updated successfully!");
    }

}
