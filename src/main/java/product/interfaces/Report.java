package product.interfaces;

import product.input.UserInput;
import product.service.SearchService;

public interface Report {

    UserInput userInput = UserInput.getInstance();
    SearchService search = SearchService.getInstance();
    void report();
}
