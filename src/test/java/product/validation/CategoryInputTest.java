package product.validation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryInputTest {

    private InputStream inputStream;
    private CategoryInput categoryInput;

    @BeforeEach
    void setUp() {
        inputStream = System.in;
        categoryInput  = new CategoryInput(new Scanner(System.in));
    }

    @AfterEach
    void restSystemInput() {
        System.setIn(inputStream);
    }

    @Test
    @DisplayName("Test valid input Category")
    void testValidCategory() {
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        categoryInput = new CategoryInput(new Scanner(System.in));
        String result = categoryInput.input();

        assertEquals("Makeup", result);
    }

    @Test
    @DisplayName("Test invalid input Category (non-numeric input")
    void testInValidCategory() {
        String input = "abc";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        categoryInput = new CategoryInput(new Scanner(System.in));
        String result = categoryInput.input();

        assertEquals("Makeup", result);
    }

    @Test
    @DisplayName("Test invalid input Category range ( Out of range ) ")
    void testInValidCategoryRange() {
        String input = "35";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        categoryInput = new CategoryInput(new Scanner(System.in));
        String result = categoryInput.input();

        assertEquals("Makeup", result);
    }


}