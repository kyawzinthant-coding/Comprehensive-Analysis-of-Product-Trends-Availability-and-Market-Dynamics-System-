package product.validation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameInputTest {


    private InputStream inputStream;
    private NameInput nameInput;
    private final Scanner scanner = new Scanner(System.in);

    @BeforeEach
    void setUp() {
        inputStream = System.in;
        nameInput = new NameInput(scanner);
    }

    @AfterEach
    void resetSystemInput() {
        System.setIn(inputStream);
    }

    @Test
    void testValidName(){
        String input = "Macbook Pro";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        String result = nameInput.input();
        assertEquals("Macbook Pro", result);
    }

    @AfterEach
    void tearDown() {

    }
}