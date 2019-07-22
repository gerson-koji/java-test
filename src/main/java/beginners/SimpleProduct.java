package beginners;

import java.util.Scanner;

/**
 * Read two integer values. After this, calculate the product between them and store the result in a variable named PROD. Print the result like the example below. Do not forget to print the end of line after the result, otherwise you will receive “Presentation Error”.
 * <p>
 * Input
 * The input file contains 2 integer numbers.
 * <p>
 * Output
 * Print PROD according to the following example, with a blank space before and after the equal signal.
 */
public class SimpleProduct {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int valueA = scanner.nextInt();
        final int valueB = scanner.nextInt();
        final int productValue = valueA * valueB;

        System.out.println("PROD = " + productValue);
    }
}
