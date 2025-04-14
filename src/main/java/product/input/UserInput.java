package product.input;

import product.interfaces.Input;
import product.validation.*;
import java.util.EnumMap;
import java.util.Map;

public class UserInput {
    private static volatile UserInput instance;
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

    private UserInput() {
        inputs = new EnumMap<>(InputType.class);
        initializeInputs();
    }

    private void initializeInputs() {
        inputs.put(InputType.NAME, new NameInput());
        inputs.put(InputType.DESCRIPTION, new DescriptionInput());
        inputs.put(InputType.BRAND, new BrandInput());
        inputs.put(InputType.CATEGORY, new CategoryInput());
        inputs.put(InputType.PRICE, new PriceInput());
        inputs.put(InputType.STOCK, new StockInput());
        inputs.put(InputType.COLOR, new ColorInput());
        inputs.put(InputType.SIZE, new SizeInput());
        inputs.put(InputType.AVAILABILITY, new AvailabilityInput());
    }

    public static UserInput getInstance() {
        if (instance == null) {
            synchronized (UserInput.class) {
                if (instance == null) {
                    instance = new UserInput();
                }
            }
        }
        return instance;
    }

    public String getInput(InputType type) {
        Input input = inputs.get(type);
        if (input == null) {
            throw new IllegalArgumentException("Invalid input type: " + type);
        }
        return input.input();
    }

    // Convenience methods for direct access
    public String getName() {
        return getInput(InputType.NAME);
    }

    public String getDescription() {
        return getInput(InputType.DESCRIPTION);
    }

    public String getBrand() {
        return getInput(InputType.BRAND);
    }

    public String getCategory() {
        return getInput(InputType.CATEGORY);
    }

    public String getPrice() {
        return getInput(InputType.PRICE);
    }

    public String getStock() {
        return getInput(InputType.STOCK);
    }

    public String getColor() {
        return getInput(InputType.COLOR);
    }

    public String getSize() {
        return getInput(InputType.SIZE);
    }

    public String getAvailability() {
        return getInput(InputType.AVAILABILITY);
    }

}
