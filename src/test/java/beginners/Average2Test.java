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

public class Average2Test {

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

    @DisplayName("Calculate the students average: ")
    @ParameterizedTest(name = "Student A has {0}, B has {1} and C {2}. Average is {3}")
    @CsvSource({
            "5.0, 6.0, 7.0, 6.3",
            "5.0, 10.0, 10.0, 9.0",
            "10.0, 10.0, 5.0, 7.5"
    })
    public void shouldCalculateAverage(final String gradeA, final String gradeB, final String gradeC, final String expectedResult) {
        try {
            final String inputValues = new StringJoiner("\n").add(gradeA).add(gradeB).add(gradeC).toString();
            System.setIn(new ByteArrayInputStream(inputValues.getBytes()));

            Average2.main(new String[]{});

            assertEquals("MEDIA = " + expectedResult + "\n", outContent.toString());
        } finally {
            System.setIn(System.in);
        }
    }
}
