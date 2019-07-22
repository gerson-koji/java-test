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
import java.util.StringJoiner;

import static beginners.Average1.StudentGradeAverageCalculator.calculate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Average1Test {

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

    @DisplayName("Calculate students average: ")
    @ParameterizedTest(name = "Student A grade is {0} with weight 3.5 and student B is {1} with weight 7.5 and average is {2}")
    @CsvSource({
            "5.0, 7.1, 6.43182",
            "0.0, 7.1, 4.84091",
            "10.0, 10.0, 10.00000",
            "5.5, 4.6, 4.88636"
    })
    public void shouldCalculateAverage(final String gradeA, final String gradeB, final String expectedResult) {
        try {
            final String inputValues = new StringJoiner("\n").add(gradeA).add(gradeB).toString();
            System.setIn(new ByteArrayInputStream(inputValues.getBytes()));

            Average1.main(new String[]{});

            assertEquals("MEDIA = " + expectedResult + "\n", outContent.toString());
        } finally {
            System.setIn(System.in);
        }
    }

    /**
     * Student Grade Average Calculator Test
     * <p>
     * This test is duplicated test from above one, but this is just an example of how should we test the student grande
     * calculation based with no input and output checks.
     */
    static class StudentGradeAverageCalculatorTest {
        @Test
        public void shouldCalculateStudentGradeAverage() {
            // Given the student A grade is 5
            // And the student B grade is 7.1
            final double studentGradeA = 5D;
            final double studentGradeB = 7.1D;

            // When calculate the student average
            final double studentAverageGrade = calculate(studentGradeA, studentGradeB);

            // Then student average is 6.431818181818182
            assertEquals(studentAverageGrade, 6.431818181818182D);
        }
    }
}
