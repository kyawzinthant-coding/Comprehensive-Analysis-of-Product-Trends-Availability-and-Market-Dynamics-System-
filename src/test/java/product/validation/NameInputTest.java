package product.validation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameInputTest {

    NameInput nameInput;
    InputStream inputStream;

    @BeforeEach
    void setUp() {
        nameInput = new NameInput(new Scanner(System.in));
        inputStream = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(inputStream);
    }

    @Test
    @DisplayName("Test valid input Name")
    void validInputName() {
        String input = "Macbook";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        nameInput = new NameInput(new Scanner(System.in));
        String result = nameInput.input();
        assertEquals("Macbook", result);
    }

    @Test
    @DisplayName("Test valid input Name")
    void InvalidInputName() {
        String input = "macbook";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        nameInput = new NameInput(new Scanner(System.in));
        String result = nameInput.input();
        assertEquals("Macbook", result);
    }
}