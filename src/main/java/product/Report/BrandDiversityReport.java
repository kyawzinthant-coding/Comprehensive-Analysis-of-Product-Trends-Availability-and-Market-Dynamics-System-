package product.Report;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import product.interfaces.Report;
import product.model.Product;

import java.util.*;

public class BrandDiversityReport implements Report {

    LinkedList<Product> productList;

    public BrandDiversityReport(LinkedList<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void report() {
        HashMap<String, HashSet> map =new HashMap<>();
        for (Product product : productList) {
            String category = product.getCategory();
            String brand = product.getBrand();

            if (!map.containsKey(category)) {
                map.put(category, new HashSet<>());
            }
            map.get(category).add(brand);
        }
        AsciiTable table =new AsciiTable();
        table.addRule();
        table.addRow(Arrays.asList("Category Name","Number of Brands"));
        table.addRule();
        for(Map.Entry<String,HashSet> entry: map.entrySet()){
            table.addRow(Arrays.asList(entry.getKey(),entry.getValue().size()));
            table.addRule();
        }
        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());

    }
}
