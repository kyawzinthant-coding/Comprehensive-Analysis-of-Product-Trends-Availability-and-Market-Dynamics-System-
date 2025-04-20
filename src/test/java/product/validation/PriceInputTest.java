package product.validation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class PriceInputTest {

    PriceInput priceInput;
    InputStream inputStream;
    @BeforeEach
    void setUp() {
        priceInput = new PriceInput(new Scanner(System.in));
        inputStream = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(inputStream);
    }

    @Test
    @DisplayName("Test price input")
    void input() {
        ByteArrayInputStream testInput = new ByteArrayInputStream("1000\n".getBytes());
        System.setIn(testInput);

        priceInput = new PriceInput(new Scanner(System.in));

        String result = priceInput.input();
        assert result.equals("1000");
    }
}