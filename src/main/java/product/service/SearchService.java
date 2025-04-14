package product.service;

import product.model.Product;

import java.util.LinkedList;

public class SearchService {
    private static SearchService instance;
    private SearchService(){}

    public static SearchService getInstance(){
        if (instance == null) {
            instance = new SearchService();
        }
        return instance;
    }

    public int searchByName_and_Category(LinkedList<Product> productList, String name, String category){

        int idx=0;
        for (Product product: productList){
            if (product.getName().equalsIgnoreCase(name.trim()) && product.getCategory().equalsIgnoreCase(category)){
                return idx;
            }
            idx++;
        }
        return -1;

    }

}
