package product.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Template.ProductCSVHandler;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class UpdateServiceTest {
    private static final String FILE_PATH = "Data/productDataset.csv";

    @Test
    @DisplayName("Test Product Update")
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

    @Test
    @DisplayName("Invalid Nonexistence Product Update test ")
    void testNonExistenceProductUpdate() {
        String name = "Hyg Product"; // This doesn't exist
        String category = "1";
        String updatePrice = "200";
        String updatedStock = "500";
        String updatedAvailability = "1";

        String updateInput = String.join("\n", name, category, updatePrice, updatedStock, updatedAvailability);
        System.setIn(new java.io.ByteArrayInputStream(updateInput.getBytes()));

        // Capture the console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProductCSVHandler updateService = new UpdateService(FILE_PATH);
        updateService.process();

        String output = outputStream.toString();
        // This should be true if the product wasn't found
        Assertions.assertFalse(output.contains("Product not found"), "Product should exist but was not found");

    }

}