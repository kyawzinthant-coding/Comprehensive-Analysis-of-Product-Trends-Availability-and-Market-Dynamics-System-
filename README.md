
# 🛍️ Product Management System

A Java console-based Product Management System that supports CRUD operations and generates insightful reports on product data stored in a CSV file. The system follows SOLID principles and demonstrates various design patterns.

## 📦 Features

- Insert, Update, Delete, and Search for products
- Validate user input using custom validation classes
- Generate reports:
  - Products in a selected category sorted by price
  - Total products in each category
  - Count of different brands per category
- CSV read/write support
- Clean modular architecture using OOP principles

## 📁 Project Structure

```
product/
├── App.java                     # Entry point and main menu
├── Template/
│   └── ProductCSVHandler.java   # Template method for CSV operations
├── factory/
│   ├── ProductFactory.java      # Factory for creating Product with validated inputs
│   └── ReportFactory.java       # Factory for generating different reports
├── interfaces/
│   ├── Input.java               # Interface for input validation strategy
│   └── Report.java              # Interface for report generation
├── input/
│   └── UserInput.java           # Aggregates all input getters
├── model/
│   └── Product.java             # Product data class
├── menu/
│   └── Menu.java                # Menu logic
├── Report/
│   ├── BrandDiversityReport.java
│   ├── SelectedProductSortReport.java
│   └── SortedCategoryCountReport.java
├── service/
│   ├── InsertService.java
│   ├── UpdateService.java
│   ├── DeleteService.java
│   └── SearchService.java
├── validation/                 # All user input validation strategies
```

## 🧠 Design Patterns Used

### ✅ Creational Patterns

**1. Factory Pattern**
- `ProductFactory`: Creates validated `Product` objects.
- `ReportFactory`: Returns a specific `Report` implementation based on user input.

### ✅ Structural Patterns

**1. Facade Pattern**
- `ProductCSVHandler.process()`: Simplifies CSV I/O logic into one call.

### ✅ Behavioral Patterns

**1. Template Method Pattern**
- `ProductCSVHandler`: Defines a skeleton for CSV handling logic; subclasses override `operate()`.

**2. Strategy Pattern (Partial)**
- Input validation classes (`NameInput`, `PriceInput`, etc.) implement the `Input` interface and encapsulate logic.

## 🧪 How to Run

1. Compile the project using your IDE or `javac` from CLI.
2. Run `App.java` to start the menu-based console interface.
3. Choose operations and follow the prompts.

## 👨‍💻 Author

- Kyaw Zin Thant

---
