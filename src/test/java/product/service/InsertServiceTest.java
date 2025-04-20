package product.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Template.ProductCSVHandler;

class InsertServiceTest {

    private static final String FILE_PATH = "Data/productDataset.csv";

    @Test
    @DisplayName("Valid Insert Product Test")
    void validInsertProductTest() {

        String name = "New Product";
        String category = "1";
        String brand = "New Brand";
        String description = "New Description";
        String price = "300";

        String stock = "10";
        String color = "Black";
        String size = "9";
        String availability = "1";

        String input  = String.join("\n",name, category,description, brand , price, stock , color , size, availability);

        System.out.println(input);

        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        ProductCSVHandler insertService = new InsertService(FILE_PATH);

        insertService.process();


    }


}