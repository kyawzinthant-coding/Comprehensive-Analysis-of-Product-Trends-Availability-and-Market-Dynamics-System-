package product.validation;

import product.interfaces.Input;

public class ColorInput implements Input {
    @Override
    public String input() {
        System.out.print("Enter color: ");
        String color =sc.nextLine();
        if(!color.matches("^[A-Z][a-zA-Z]*$")){
            System.out.println("Invalid input. Enter again.");
            return input();
        }

        return color;

    }
}
