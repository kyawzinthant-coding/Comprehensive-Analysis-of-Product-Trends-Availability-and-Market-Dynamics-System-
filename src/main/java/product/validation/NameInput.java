package product.validation;

import product.interfaces.Input;

import java.util.Scanner;

public class NameInput implements Input {
    private final Scanner sc;

    public NameInput(Scanner sc) {
        this.sc = sc;
    }
    @Override
    public String input() {
        System.out.print("Enter Name: ");
        String name =sc.nextLine();
        if(!name.matches("^[A-Z][\\s\\S]{1,40}$")){
            System.out.println("Invalid name. Enter again.");
            return input();
        }

        return name;
    }


    public String input ( Scanner sc ) {
        System.out.print("Enter Name: ");
        String name =sc.nextLine();
        if(!name.matches("^[A-Z][\\s\\S]{1,40}$")){
            System.out.println("Invalid name. Enter again.");
            return input();
        }

        return name;
    }

}

