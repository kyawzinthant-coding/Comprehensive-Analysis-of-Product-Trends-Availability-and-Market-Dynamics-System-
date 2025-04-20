package product.interfaces;

import product.input.UserInput;
import product.service.SearchService;

import java.util.Scanner;

public interface Report {

    UserInput userInput = UserInput.getInstance(new Scanner(System.in));
    SearchService search = SearchService.getInstance();
    void report();
}
