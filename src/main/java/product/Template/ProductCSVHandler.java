package product.Template;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import product.model.Product;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public abstract class ProductCSVHandler {

    protected LinkedList<Product> productList = new LinkedList<>();
    protected final String filePath;

    public ProductCSVHandler(String filePath) {
        this.filePath = filePath;
    }

    public final void process() {
        readCSV();
        operate(productList);
        writeCSV();
    }

    private void readCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            while ((row = reader.readNext()) != null) {
                productList.add(new Product(
                        row[0], row[1], row[2], row[3], Integer.parseInt(row[4]),
                        row[5], Integer.parseInt(row[6]), row[7], row[8], row[9], Integer.parseInt(row[10])
                ));
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Product p : productList) {
                writer.println(p.toCSV());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract void operate(LinkedList<Product> products);



}
