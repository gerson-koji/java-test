package beginners;

import component.DecimalRounder;

import java.util.Scanner;

/**
 * Read three values (variables A, B and C), which are the three student's grades. Then, calculate the average, considering that grade A has weight 2, grade B has weight 3 and the grade C has weight 5. Consider that each grade can go from 0 to 10.0, always with one decimal place.
 * <p>
 * Input
 * The input file contains 3 values of floating points with one digit after the decimal point.
 * <p>
 * Output
 * Print MEDIA(average in Portuguese) according to the following example, with a blank space before and after the equal signal.
 */
public class Average2 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final double gradeA = scanner.nextDouble();
        final double gradeB = scanner.nextDouble();
        final double gradeC = scanner.nextDouble();
        final double average = StudentGradeAverageCalculator.calculate(gradeA, gradeB, gradeC);

        System.out.println("MEDIA = " + DecimalRounder.roundToHalfUp(average, 1));
    }

    static class StudentGradeAverageCalculator {
        private static final double WEIGHT_1 = 2;
        private static final double WEIGHT_2 = 3;
        private static final double WEIGHT_3 = 5;

        public static double calculate(final double gradeA, final double gradeB, final double gradeC) {
            return (gradeA * WEIGHT_1 + gradeB * WEIGHT_2 + gradeC * WEIGHT_3) / (WEIGHT_1 + WEIGHT_2 + WEIGHT_3);
        }
    }
}
