package beginners;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleProductTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @DisplayName("Calculate the sum of the values ")
    @ParameterizedTest(name = "{0} and {1} should return {2}")
    @CsvSource({
            "3, 9, 27",
            "-30, 10, -300",
            "0, 0, 0",
            "0, 9, 0"
    })
    public void shouldCalculateProduct(final String valueA, final String valueB, final String expectedResult) {
        try {
            final String inputValues = new StringJoiner("\n").add(valueA).add(valueB).toString();
            System.setIn(new ByteArrayInputStream(inputValues.getBytes()));

            SimpleProduct.main(new String[]{});

            assertEquals("PROD = " + expectedResult + "\n", outContent.toString());
        } finally {
            System.setIn(System.in);
        }
    }

}
