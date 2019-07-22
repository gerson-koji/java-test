package beginners;

import component.DecimalRounder;

import java.util.Scanner;

/**
 * The formula to calculate the area of a circumference is defined as A = π . R2. Considering to this problem that π = 3.14159:
 * <p>
 * Calculate the area using the formula given in the problem description.
 * <p>
 * Input
 * The input contains a value of floating point (double precision), that is the variable R.
 * <p>
 * Output
 * Present the message "A=" followed by the value of the variable, as in the example bellow, with four places after the decimal point.
 * Use all double precision variables. Like all the problems, don't forget to print the end of line after the result, otherwise you will receive "Presentation Error".
 */
public class AreaOfCircle {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final double radius = scanner.nextDouble();
        final double circleArea = CircleAreaCalculator.calculate(radius);

        System.out.println("A=" + DecimalRounder.roundToHalfUp(circleArea, 4));
    }

    static class CircleAreaCalculator {
        private static final double PI = 3.14159;

        public static double calculate(final double radius) {
            return PI * Math.pow(radius, 2);
        }
    }

}
