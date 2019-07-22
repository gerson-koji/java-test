package beginners;

import java.util.Scanner;

/**
 * Read four integer values named A, B, C and D. Calculate and print the difference of product A and B by the product of C and D (A * B - C * D).
 * <p>
 * Input
 * The input file contains 4 integer values.
 * <p>
 * Output
 * Print DIFERENCA (DIFFERENCE in Portuguese) with all the capital letters, according to the following example, with a blank space before and after the equal signal.
 */
public class Difference {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();
        final int d = scanner.nextInt();
        final int difference = calculateDifference(a, b, c, d);

        System.out.println("DIFERENCA = " + difference);
    }

    private static int calculateDifference(final int a, final int b, final int c, final int d) {
        return a * b - c * d;
    }
}
