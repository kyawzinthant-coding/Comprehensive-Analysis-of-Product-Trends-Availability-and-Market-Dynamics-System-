package product.validation;

import product.interfaces.Input;

import java.util.Scanner;

public class DescriptionInput implements Input {

    private  final  Scanner sc ;

    public DescriptionInput(Scanner sc) {
        this.sc = sc;
    }

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
