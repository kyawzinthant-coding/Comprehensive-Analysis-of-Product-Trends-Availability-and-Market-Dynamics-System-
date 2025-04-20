package product.input;

import product.interfaces.Input;
import product.validation.*;

import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

public class UserInput {
    private static UserInput instance;

    private final Map<InputType, Input> inputs;

    public enum InputType {
        NAME("Product Name"),
        DESCRIPTION("Product Description"),
        BRAND("Brand"),
        CATEGORY("Category"),
        PRICE("Price"),
        STOCK("Stock"),
        COLOR("Color"),
        SIZE("Size"),
        AVAILABILITY("Availability Status");

        private final String displayName;

        InputType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    private final Scanner scanner;

    private UserInput(Scanner scanner) {
        this.scanner = scanner;
        inputs = new EnumMap<>(InputType.class);
        initializeInputs();
    }

    private void initializeInputs() {
        inputs.put(InputType.NAME, new NameInput(scanner));
        inputs.put(InputType.DESCRIPTION, new DescriptionInput(scanner));
        inputs.put(InputType.BRAND, new BrandInput(scanner));
        inputs.put(InputType.CATEGORY, new CategoryInput(scanner));
        inputs.put(InputType.PRICE, new PriceInput(scanner));
        inputs.put(InputType.STOCK, new StockInput(scanner));
        inputs.put(InputType.COLOR, new ColorInput(scanner));
        inputs.put(InputType.SIZE, new SizeInput(scanner));
        inputs.put(InputType.AVAILABILITY, new AvailabilityInput(scanner));
    }

    public static UserInput getInstance(Scanner scanner) {
        if (instance == null) {
            instance = new UserInput(scanner);
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    public String getInput(InputType type) {
        Input input = inputs.get(type);
        if (input == null) {
            throw new IllegalArgumentException("Invalid input type: " + type);
        }
        return input.input();
    }

    public String getName()            { return getInput(InputType.NAME); }
    public String getDescription()     { return getInput(InputType.DESCRIPTION); }
    public String getBrand()           { return getInput(InputType.BRAND); }
    public String getCategory()        { return getInput(InputType.CATEGORY); }
    public String getPrice()           { return getInput(InputType.PRICE); }
    public String getStock()           { return getInput(InputType.STOCK); }
    public String getColor()           { return getInput(InputType.COLOR); }
    public String getSize()            { return getInput(InputType.SIZE); }
    public String getAvailability()    { return getInput(InputType.AVAILABILITY); }
}
