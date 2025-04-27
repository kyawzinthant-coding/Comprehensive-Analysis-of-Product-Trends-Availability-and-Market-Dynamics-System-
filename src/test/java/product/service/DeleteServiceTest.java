package product.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Template.ProductCSVHandler;

class DeleteServiceTest {

    private static final String FILE_PATH = "Data/productDataset.csv";

    @Test
    @DisplayName("Test Delete Product")
    void testDeleteProduct() {
        String name = "New Product"; // existed product
        String category = "1"; //

        String deleteInput = String.join("\n", name, category);

        System.setIn(new java.io.ByteArrayInputStream(deleteInput.getBytes()));
        ProductCSVHandler deleteService = new DeleteService(FILE_PATH);
        deleteService.process();
    }

    @Test
    @DisplayName("Test Non Existed Product")
    void testNonExistedProduct() {
        String name = "Non Existed"; // existed product
        String category = "9"; //

        String deleteInput = String.join("\n", name, category);

        System.setIn(new java.io.ByteArrayInputStream(deleteInput.getBytes()));
        ProductCSVHandler deleteService = new DeleteService(FILE_PATH);
        deleteService.process();
    }
}