package product.validation;

import java.util.Scanner;

public class CategoryInput implements Input {

    private static final String[] CATEGORIES = {
        "Makeup", "Camping & Hiking", "Books & Stationery", "Men's Clothing",
        "Skincare", "Furniture", "Health & Wellness", "Cleaning Supplies",
        "Laptops & Computers", "Automotive", "Smartphones", "Bedding & Bath",
        "Shoes & Footwear", "Fitness Equipment", "Home & Kitchen", "Cameras & Accessories",
        "Beauty & Personal Care", "Toys & Games", "Smartwatches", "Haircare",
        "Accessories (Bags, Hats, Belts)", "Cycling", "Headphones & Earbuds", "Women's Clothing",
        "Office Supplies", "Kitchen Appliances", "Sports & Outdoors", "Kids' Clothing",
        "Fishing & Hunting", "Grooming Tools", "Fragrances", "Home Decor",
        "Team Sports", "Clothing & Apparel"
    };

    private static final int COLUMNS = 3;
    private static final String INPUT_PROMPT = "Choose one of the above categories (1-%d): ";
    private static final String ERROR_MESSAGE = "Invalid option. Please enter a number between 1 and %d: ";

    private static final Scanner sc = new Scanner(System.in);

    @Override
    public String input() {
        displayCategories();
        return getValidCategory();
    }

    private void displayCategories() {
        int maxLength = calculateMaxLength();
        
        for (int i = 0; i < CATEGORIES.length; i += COLUMNS) {
            printCategoryRow(i, maxLength);
        }
        
        System.out.printf(INPUT_PROMPT, CATEGORIES.length);
    }

    private int calculateMaxLength() {
        return java.util.Arrays.stream(CATEGORIES)
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    private void printCategoryRow(int index, int maxLength) {
        StringBuilder row = new StringBuilder();
        
        // Add first category
        row.append(String.format("%2d. %-" + maxLength + "s    ", 
            index + 1, CATEGORIES[index]));
            
        // Add second category if exists
        if (index + 1 < CATEGORIES.length) {
            row.append(String.format("%2d. %-" + maxLength + "s    ", 
                index + 2, CATEGORIES[index + 1]));
                
            // Add third category if exists
            if (index + 2 < CATEGORIES.length) {
                row.append(String.format("%2d. %s", 
                    index + 3, CATEGORIES[index + 2]));
            }
        }
        
        System.out.println(row);
    }

    private String getValidCategory() {
        while (true) {
            String input = sc.nextLine().trim();
            
            try {
                int option = Integer.parseInt(input);
                if (isValidOption(option)) {
                    return CATEGORIES[option - 1];
                }
            } catch (NumberFormatException ignored) {
                // Handle non-numeric input
            }
            
            System.out.printf(ERROR_MESSAGE, CATEGORIES.length);
        }
    }

    private boolean isValidOption(int option) {
        return option >= 1 && option <= CATEGORIES.length;
    }

    public static void main(String[] args) {
        CategoryInput categoryInput = new CategoryInput();
        String category = categoryInput.input();
        System.out.println("Selected category: " + category);
    }
}
