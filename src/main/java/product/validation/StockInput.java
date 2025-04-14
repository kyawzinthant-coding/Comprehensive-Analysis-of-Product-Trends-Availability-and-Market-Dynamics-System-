package product.validation;

import product.interfaces.Input;

public class StockInput implements Input {

    public String input() {
        System.out.print("Enter stock (1-1000): ");
        String stock =sc.nextLine();
        if(!stock.matches("^(1000|[1-9][0-9]{0,2})$")){
            System.out.println("Invalid or over the stock limit. Enter again.");
            return input();
        }

        return stock;

    }
}
