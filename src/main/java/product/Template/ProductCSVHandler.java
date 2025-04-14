package product.Template;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import product.input.UserInput;
import product.model.Product;
import product.service.SearchService;

import java.io.*;
import java.util.LinkedList;

public abstract class ProductCSVHandler {

    protected LinkedList<Product> productList = new LinkedList<>();
    protected final String filePath;
    protected static UserInput userInput = UserInput.getInstance();
    protected static SearchService search = SearchService.getInstance();

    public ProductCSVHandler(String filePath) {
        this.filePath = filePath;
    }

    public final void process() {
        System.out.println(productList);
        readCSV();
        operate(productList);
        writeCSV();
    }

    private void readCSV(){
        FileReader fr = null;
        try {
            fr = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CSVReader csvReader = new CSVReader(fr);
        String[] str;
        while (true) {
            try {
                if ((str = csvReader.readNext()) == null) break;
            } catch (IOException | CsvValidationException e) {
                throw new RuntimeException(e);
            }

            productList.add(new Product(
                    str[0],                    // name
                    str[1],                    // description
                    str[2],                    // brand
                    str[3],                    // category
                    Integer.parseInt(str[4]),   // price (Fixed)
                    str[5],                    // currency
                    Integer.parseInt(str[6]),   // stock (Fixed)
                    str[7],                    // color
                    str[8],                    // size
                    str[9],                    // availability
                    Integer.parseInt(str[10])   // internalID
            ));

        }
        try {
            csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fr.close();
        } catch (IOException e) {
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
