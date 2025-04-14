package product.service;

import product.Template.ProductCSVHandler;
import product.factory.ProductFactory;
import product.model.Product;

import java.util.LinkedList;

public class InsertService extends ProductCSVHandler {
    public InsertService(String filePath) {
        super(filePath);
    }

    @Override
    protected void operate(LinkedList<Product> products) {


        String name = userInput.getName();
        String category = userInput.getCategory();


        if (search.searchByName_and_Category(productList,name,category)>=0){
            System.out.println("Product already exists");
            operate(productList);
            return;
        }

        int ID = (int) (Math.random() * 99) + 1;

        Product newProduct = ProductFactory.createProductWithPartial(name, category, userInput, ID);
        productList.add(newProduct);


        System.out.println("✅ Product inserted successfully!");
    }

    public static void main(String[] args) {
        InsertService insertService = new InsertService("Data/productDataset.csv");
        insertService.process();
    }
}
