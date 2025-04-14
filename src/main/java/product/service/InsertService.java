package product.service;

import product.Template.ProductCSVHandler;
import product.model.Product;

import java.util.LinkedList;

public class InsertService extends ProductCSVHandler {
    public InsertService(String filePath) {
        super(filePath);
    }

    @Override
    protected void operate(LinkedList<Product> products) {


        int ID = (int) (Math.random() * 99) + 1;
        String name = userInput.getName();
        String category = userInput.getCategory();

        if (search.searchByName_and_Category(productList,name,category)>=0){
            System.out.println("Product already exists");
            operate(productList);
            return;
        }

        String description = userInput.getDescription();
        String brand = userInput.getBrand();
        String price = userInput.getPrice();
        String stock = userInput.getStock();
        String color = userInput.getColor();
        String size = userInput.getSize();
        String availability = userInput.getAvailability();


        Product newProduct = new Product(name, description, brand, category, Integer.parseInt(price), "USD", Integer.parseInt(stock), color, size, availability, ID);
        products.add(newProduct);

        System.out.println("✅ Product inserted successfully!");
    }

}
