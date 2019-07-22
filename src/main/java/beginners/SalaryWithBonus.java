package beginners;

import java.util.Scanner;

/**
 * Make a program that reads a seller's name, his/her fixed salary and the sale's total made by himself/herself in the month (in money). Considering that this seller receives 15% over all products sold, write the final salary (total) of this seller at the end of the month , with two decimal places.
 * <p>
 * - Don’t forget to print the line's end after the result, otherwise you will receive “Presentation Error”.
 * <p>
 * - Don’t forget the blank spaces.
 * <p>
 * Input
 * The input file contains a text (employee's first name), and two double precision values, that are the seller's salary and the total value sold by him/her.
 * <p>
 * Output
 * Print the seller's total salary, according to the given example.
 */
public class SalaryWithBonus {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // Obtain the employee name
        scanner.next();

        final double salary = scanner.nextDouble();
        final double totalValueSold = scanner.nextDouble();
        final double totalSalary = EmployeeSalaryCalculator.calculate(salary, totalValueSold);

        System.out.printf("TOTAL = R$ %.2f\n", totalSalary);
    }

    static class EmployeeSalaryCalculator {

        private static final int PRODUCT_SOLD_BONUS_PERCENTAGE = 15;

        public static double calculate(final double salary, final double totalValueSold) {
            return salary + totalValueSold * PRODUCT_SOLD_BONUS_PERCENTAGE / 100;
        }
    }
}
