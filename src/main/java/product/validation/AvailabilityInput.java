package product.validation;

import product.interfaces.Input;

import java.util.Scanner;

public class AvailabilityInput implements Input {

    private final Scanner sc;

    public AvailabilityInput(Scanner sc) {
        this.sc = sc;
    }

    private enum AvailabilityStatus {
        IN_STOCK("In stock", "in_stock"),
        OUT_OF_STOCK("Out of stock", "out_of_stock"),
        LIMITED_STOCK("Limited stock", "limited_stock"),
        BACKORDER("Backorder", "backorder"),
        PRE_ORDER("Preorder", "pre_order"),
        DISCONTINUED("Discontinued", "discontinued");

        private final String displayName;
        private final String value;

        AvailabilityStatus(String displayName, String value) {
            this.displayName = displayName;
            this.value = value;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getValue() {
            return value;
        }
    }

    @Override
    public String input() {
        displayOptions();
        return getValidInput();
    }

    private void displayOptions() {
        System.out.println("Available options:");
        for (int i = 0; i < AvailabilityStatus.values().length; i++) {
            System.out.printf("%d. %s%n", 
                i + 1, 
                AvailabilityStatus.values()[i].getDisplayName());
        }
        System.out.print("Choose an option (1-" + AvailabilityStatus.values().length + "): ");
    }

    private String getValidInput() {
        while (true) {
            String input = sc.nextLine().trim();
            
            try {
                int option = Integer.parseInt(input);
                if (option >= 1 && option <= AvailabilityStatus.values().length) {
                    return AvailabilityStatus.values()[option - 1].getValue();
                }
            } catch (NumberFormatException ignored) {
                // Handle non-numeric input
            }
            
            System.out.printf("Invalid input. Please enter a number between 1 and %d: ", 
                AvailabilityStatus.values().length);
        }
    }
}
