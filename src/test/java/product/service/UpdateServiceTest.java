package product.service;

import org.junit.jupiter.api.Test;
import product.Template.ProductCSVHandler;

import static org.junit.jupiter.api.Assertions.*;

class UpdateServiceTest {
    private static final String FILE_PATH = "Data/productDataset.csv";

    @Test
    void testProductUpdate(){

        String name = "New Product";
        String category = "1";
        String updatePrice ="200";
        String updatedStock ="500";
        String updatedAvailability ="1";

        String updateInput  = String.join("\n",name, category, updatePrice, updatedStock, updatedAvailability);

        System.setIn(new java.io.ByteArrayInputStream(updateInput.getBytes()));

        ProductCSVHandler updateService = new UpdateService(FILE_PATH);

        updateService.process();
    }
}