package beginners;

import component.DecimalRounder;

import java.util.Scanner;

/**
 * Read two floating points' values of double precision A and B, corresponding to two student's grades. After this, calculate the student's average, considering that grade A has weight 3.5 and B has weight 7.5. Each grade can be from zero to ten, always with one digit after the decimal point. Don’t forget to print the end of line after the result, otherwise you will receive “Presentation Error”. Don’t forget the space before and after the equal sign.
 * <p>
 * Input
 * The input file contains 2 floating points' values with one digit after the decimal point.
 * <p>
 * Output
 * Print MEDIA(average in Portuguese) according to the following example, with 5 digits after the decimal point and with a blank space before and after the equal signal.
 */
public class Average1 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final double gradeA = scanner.nextDouble();
        final double gradeB = scanner.nextDouble();
        final double average = StudentGradeAverageCalculator.calculate(gradeA, gradeB);

        System.out.println("MEDIA = " + DecimalRounder.roundToHalfUp(average, 5));
    }

    static class StudentGradeAverageCalculator {
        private static final double WEIGHT_1 = 3.5;
        private static final double WEIGHT_2 = 7.5;

        public static double calculate(final double gradeA, final double gradeB) {
            return (gradeA * WEIGHT_1 + gradeB * WEIGHT_2) / (WEIGHT_1 + WEIGHT_2);
        }
    }
}
