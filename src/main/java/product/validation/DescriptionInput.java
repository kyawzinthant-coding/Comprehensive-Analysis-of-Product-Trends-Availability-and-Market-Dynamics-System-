package product.validation;

import product.interfaces.Input;

public class DescriptionInput implements Input {

    @Override
    public String input() {
        System.out.print("Enter Description: ");
        String description =sc.nextLine();
        if(!description.matches("^[A-Z][\\s\\S]{1,60}$")){
            System.out.println("Invalid description. Enter again.");
            return input();
        }

        return description;

    }
}
