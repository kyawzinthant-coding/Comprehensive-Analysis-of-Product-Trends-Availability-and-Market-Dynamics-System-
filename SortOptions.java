public void sortData(String type, boolean asc, boolean useCase1, boolean useCase2, boolean useCase3) {
    // sorting logic
}

public class SortOptions {
    String type;
    boolean ascending;
    boolean useAdvancedFilter;
    boolean enableLogging;
}

public void sortData(SortOptions options) {
    // use options for sorting logic
}

// loop through the list
for (int i = 0; i < items.size(); i++) {
    System.out.println(items.get(i));
}


// Display each item in the shopping cart
for (int i = 0; i < items.size(); i++) {
    System.out.println(items.get(i));
}


public void process(){
System.out.println("Start");
   System.out.println("Processing...");
    System.out.println("End");
}

public void process() {
    System.out.println("Start");
    System.out.println("Processing...");
    System.out.println("End");
}


public void filterA(List<String> data) {
    for (String item : data) {
        if (item.startsWith("A")) {
            System.out.println(item);
        }
    }
}

public void filterB(List<String> data) {
    for (String item : data) {
        if (item.startsWith("B")) {
            System.out.println(item);
        }
    }
}


public void filterByPrefix(List<String> data, String prefix) {
    for (String item : data) {
        if (item.startsWith(prefix)) {
            System.out.println(item);
        }
    }
}

int result=calculate();if(result>0){System.out.println("Success");}else{System.out.println("Failure");}

int result = calculate();

if (result > 0) {
    System.out.println("Success");
} else {
    System.out.println("Failure");
}
