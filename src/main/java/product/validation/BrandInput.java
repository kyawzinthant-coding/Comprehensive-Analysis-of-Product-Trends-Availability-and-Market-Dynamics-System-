package product.validation;

import product.interfaces.Input;

import java.util.Scanner;

public class BrandInput implements Input {

    private final  Scanner sc ;

    public BrandInput(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public String input() {
        System.out.print("Enter Brand: ");
        String brand =sc.nextLine();
        if(!brand.matches("^[A-Z][\\s\\S]{1,40}$")){
            System.out.println("Invalid brand. Enter again.");
            return input();
        }

        return brand;

    }
}
