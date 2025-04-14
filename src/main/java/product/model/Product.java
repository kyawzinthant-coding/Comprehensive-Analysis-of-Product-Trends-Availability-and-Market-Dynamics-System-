package product.model;

public class Product {

    private String name;
    private String description;
    private String brand;
    private String category;
    private int price;
    private String currency;
    private int stock;
    private String color;
    private String size;
    private String availability;
    private int internalID;


    public Product(String name, String description, String brand, String category, int price, String currency, int stock, String color, String size, String availability, int internalID) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.currency = currency;
        this.stock = stock;
        this.color = color;
        this.size = size;
        this.availability = availability;
        this.internalID = internalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getInternalID() {
        return internalID;
    }

    public void setInternalID(int internalID) {
        this.internalID = internalID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", stock=" + stock +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", availability='" + availability + '\'' +
                ", internalID=" + internalID +
                '}';
    }

    public String toCSV() {
        return String.join(",",
                name, description, brand, category, String.valueOf(price), currency,
                String.valueOf(stock), color, size, availability, String.valueOf(internalID));
    }

}
