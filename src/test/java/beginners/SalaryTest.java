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

public class SalaryTest {

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

    @DisplayName("Calculate the salary ")
    @ParameterizedTest(name = "Employee {0}, worked hours: {1}, receive per hour: {2}; Total Salary: {3}")
    @CsvSource({
            "25, 100, 5.50, 550.00",
            "1, 200, 20.50, 4100.00",
            "6, 145, 15.55, 2254.75"
    })
    public void shouldCalculateAverage(final String employeeId, final String workedHour, final String receivePerHour, final String expectedSalary) {
        try {
            final String inputValues = new StringJoiner("\n").add(employeeId).add(workedHour).add(receivePerHour).toString();
            System.setIn(new ByteArrayInputStream(inputValues.getBytes()));

            Salary.main(new String[]{});

            assertEquals("NUMBER = " + employeeId + "\nSALARY = U$ " + expectedSalary + "\n", outContent.toString());
        } finally {
            System.setIn(System.in);
        }
    }
}
