package product.validation;

import product.interfaces.Input;

public class SizeInput implements Input {

    private static final String[] SIZE_OPTIONS = {
        "XS", "S", "M", "L", "XL", "XXL",
        "Small", "Medium", "Large", "Extra Large",
        "cm", "in", "mm"
    };
    private static final int MEASUREMENT_UNIT_START_INDEX = 10;

    @Override
    public String input() {
        displaySizeOptions();
        int selectedOption = getValidOptionFromUser();
        return processSelectedOption(selectedOption);
    }

    private void displaySizeOptions() {
        for (int i = 0; i < SIZE_OPTIONS.length; i++) {
            System.out.printf("%d. %s%n", i + 1, SIZE_OPTIONS[i]);
        }
        System.out.print("Choose a size above: ");
    }

    private int getValidOptionFromUser() {
        while (true) {
            String input = sc.nextLine();
            if (isValidInput(input)) {
                return Integer.parseInt(input);
            }
            System.out.print("Invalid input. Please enter a number between 1 and " + SIZE_OPTIONS.length + ": ");
        }
    }

    private boolean isValidInput(String input) {
        return input.matches("^(1[0-3]|[1-9])$");
    }

    private String processSelectedOption(int option) {
        if (option <= 0 || option > SIZE_OPTIONS.length) {
            throw new IllegalArgumentException("Invalid option selected");
        }

        if (option <= MEASUREMENT_UNIT_START_INDEX) {
            return SIZE_OPTIONS[option - 1];
        } else {
            return String.format("%s %s", lengthAndWidth(), SIZE_OPTIONS[option - 1]);
        }
    }

    private String lengthAndWidth() {
        System.out.print("Enter length: ");
        String length = sc.nextLine();
        System.out.print("Enter width: ");
        String width = sc.nextLine();
        if (!width.matches("^(1000|[1-9][0-9]{0,2})$") || !length.matches("^(1000|[1-9][0-9]{0,2})$")){
            System.out.println("Invalid input. Please try again");
            return lengthAndWidth();
        }
        return length + "x" + width;
    }

}
