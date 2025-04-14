package product.Report;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import product.interfaces.Report;
import product.model.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortedCategoryCountReport implements Report {

    LinkedList<Product> productList;

    public SortedCategoryCountReport(LinkedList<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void report() {
        String category = userInput.getCategory();
        LinkedList<Product> forReport = new LinkedList<>();

        for ( Product p : productList){
            if (p.getCategory().equalsIgnoreCase(category)){
                forReport.add(p);
            }
        }

        forReport.sort(Collections.reverseOrder(Comparator.comparing(Product::getPrice)));

        System.out.println("________Products of "+category+" category________");
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow(Arrays.asList("Name", "Description", "Brand", "Category", "Price", "Currency", "Stock", "Color", "Size", "Availability", "InternalID"
        ));
        table.addRule();
        for (Product product: forReport){
            table.addRow(Arrays.asList(product.getName(), product.getDescription(), product.getBrand(),
                    product.getCategory(), product.getPrice(), product.getCurrency(),
                    product.getStock(), product.getColor(), product.getSize(),
                    product.getAvailability(),product.getInternalID()));
            table.addRule();
        }

        table.setTextAlignment(TextAlignment.CENTER);
        CWC_LongestLine cwc=new CWC_LongestLine();
        cwc.add(0,15);
        cwc.add(0,15);
        cwc.add(0,15);
        cwc.add(0,15);
        cwc.add(0,15);
        cwc.add(0,15);
        cwc.add(0,15);
        cwc.add(0,15);
        cwc.add(0,15);
        cwc.add(0,15);
        cwc.add(0,15);
        table.getRenderer().setCWC(cwc);
        System.out.println(table.render());
    }
}
