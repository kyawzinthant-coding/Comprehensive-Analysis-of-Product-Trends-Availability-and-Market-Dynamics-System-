package product.factory;

import product.input.UserInput;
import product.model.Product;

public class ProductFactory {
    public static Product createProductWithPartial(String name, String category, UserInput userInput, int id) {
        String description = userInput.getDescription();
        String brand = userInput.getBrand();
        String price = userInput.getPrice();
        String stock = userInput.getStock();
        String color = userInput.getColor();
        String size = userInput.getSize();
        String availability = userInput.getAvailability();

        return new Product(
                name,
                description,
                brand,
                category,
                Integer.parseInt(price),
                "USD",
                Integer.parseInt(stock),
                color,
                size,
                availability,
                id
        );
    }
}
