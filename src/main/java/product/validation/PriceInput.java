package product.validation;

import product.interfaces.Input;

public class PriceInput implements Input {
    @Override
    public String input() {
        System.out.print("Enter price (1-1000): ");
        String price =sc.nextLine();
        if(!price.matches("^(1000|[1-9][0-9]{0,2})$")){
            System.out.println("Invalid or over the price limit. Enter again.");
            return input();
        }

        return price;

    }
}
