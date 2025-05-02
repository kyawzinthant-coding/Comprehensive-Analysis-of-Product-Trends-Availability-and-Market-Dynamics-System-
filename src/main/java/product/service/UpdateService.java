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

        System.out.println("Product updated successfully!");
    }

}
