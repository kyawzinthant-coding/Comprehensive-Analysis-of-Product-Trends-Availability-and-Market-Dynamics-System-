package product.service;

import product.Template.ProductCSVHandler;
import product.model.Product;

import java.util.LinkedList;

public class DeleteService extends ProductCSVHandler {

    public DeleteService(String filePath) {
        super(filePath);
    }

    @Override
    protected void operate(LinkedList<Product> products) {
        String name= userInput.getName();
        String category= userInput.getCategory();
        int idx=search.searchByName_and_Category(products,name,category);
        if (idx<0){
            System.out.println("Product does not exist");
            operate(products);
            return;
        }
        productList.remove(idx);
        System.out.println("Product deleted successfully");
        System.out.println(productList.size());
    }

}
