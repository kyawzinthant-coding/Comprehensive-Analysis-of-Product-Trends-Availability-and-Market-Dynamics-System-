package product;

import product.menu.Menu;

public class App {
    public static void main(String[] args) {

        String csv = "Data/productDataset.csv";
        Menu menu = Menu.getInstance();
        menu.menu(csv);
    }
}
