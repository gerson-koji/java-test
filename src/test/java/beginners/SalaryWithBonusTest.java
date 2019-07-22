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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryWithBonusTest {

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
    @ParameterizedTest(name = "Salary: {1}, Total value sold: {1}; Total salary to receive: {3}")
    @CsvSource({
            "500.00, 1230.30, 684.55",
            "700.00, 0.00, 700.00",
            "1700.00, 1230.50, 1884.58"
    })
    public void shouldCalculateAverage(final String salary, final String totalValueSold, final String expectedSalary) {
        try {
            final String inputValues = new StringJoiner("\n").add(UUID.randomUUID().toString()).add(salary).add(totalValueSold).toString();
            System.setIn(new ByteArrayInputStream(inputValues.getBytes()));

            SalaryWithBonus.main(new String[]{});

            assertEquals("TOTAL = R$ " + expectedSalary + "\n", outContent.toString());
        } finally {
            System.setIn(System.in);
        }
    }
}
