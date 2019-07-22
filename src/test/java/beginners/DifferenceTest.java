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

public class DifferenceTest {

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

    @DisplayName("Calculate the difference ")
    @ParameterizedTest(name = "{0} * {1} - {2} * {3} = {4}")
    @CsvSource({
            "5, 6, 7, 8, -26",
            "0, 0, 7, 8, -56",
            "5, 6, -7, 8, 86"
    })
    public void shouldCalculateAverage(final String a, final String b, final String c, final String d, final String expectedResult) {
        try {
            final String inputValues = new StringJoiner("\n").add(a).add(b).add(c).add(d).toString();
            System.setIn(new ByteArrayInputStream(inputValues.getBytes()));

            Difference.main(new String[]{});

            assertEquals("DIFERENCA = " + expectedResult + "\n", outContent.toString());
        } finally {
            System.setIn(System.in);
        }
    }
}
