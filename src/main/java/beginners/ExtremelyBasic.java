package beginners;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Read 2 variables, named A and B and make the sum of these two variables, assigning its result to the variable X. Print X as shown below. Print endline after the result otherwise you will get “Presentation Error”.
 * <p>
 * Input
 * The input file will contain 2 integer numbers.
 * <p>
 * Output
 * Print the letter X (uppercase) with a blank space before and after the equal signal followed by the value of X, according to the following example.
 * <p>
 * Obs.: don't forget the endline after all.
 */
public class ExtremelyBasic {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final BigInteger valueA = scanner.nextBigInteger();
        final BigInteger valueB = scanner.nextBigInteger();

        System.out.println("X = " + valueA.add(valueB).intValue());
    }
}
