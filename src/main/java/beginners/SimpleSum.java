package beginners;

import java.util.Scanner;

/**
 * Read two integer values, in this case, the variables A and B. After this, calculate the sum between them and assign it to the variable SOMA. Write the value of this variable.
 * <p>
 * Input
 * The input file contains 2 integer numbers.
 * <p>
 * Output
 * Print the variable SOMA with all the capital letters, with a blank space before and after the equal signal followed by the corresponding value to the sum of A and B. Like all the problems, don't forget to print the end of line, otherwise you will receive "Presentation Error"
 */
public class SimpleSum {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int valueA = scanner.nextInt();
        final int valueB = scanner.nextInt();
        final int sumValue = valueA + valueB;

        System.out.println("SOMA = " + sumValue);
    }
}
