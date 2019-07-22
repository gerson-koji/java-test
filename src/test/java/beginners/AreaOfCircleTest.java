package beginners;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static beginners.AreaOfCircle.CircleAreaCalculator.calculate;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Circle area input and output tests
 */
public class AreaOfCircleTest {

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

    @DisplayName("Calculate the area of circle with radius as ")
    @ParameterizedTest(name = "{0} should return {1}")
    @CsvSource({
            "2.00, 12.5664",
            "100.64, 31819.3103",
            "150.00, 70685.7750",
            "0, 0.0000",
            "1.00, 3.1416"
    })
    public void shouldCalculateTheCircleArea(final String radius, final String expectedResult) {
        try {
            System.setIn(new ByteArrayInputStream(radius.getBytes()));

            AreaOfCircle.main(new String[]{});

            assertEquals("A=" + expectedResult + "\n", outContent.toString());
        } finally {
            System.setIn(System.in);
        }
    }

    /**
     * Circle Area Calculation Test
     * <p>
     * This test is duplicated test from above one, but this is just an example of how should we test the circle area
     * calculation based with no input and output checks.
     */
    static class CircleAreaCalculatorTest {

        @Test
        public void shouldCalculateArea() {
            // Given I have the radius value as 2
            final double radius = 2D;

            // When executed the circle calculation
            double calculatedCircleArea = calculate(radius);

            // Then expect that returns the area 12.56636
            assertEquals(12.56636D, calculatedCircleArea);
        }
    }
}
