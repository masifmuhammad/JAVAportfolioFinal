package Portfolio.Practical_20;

import java.util.Scanner;


// TODO remember to do commenting on recursive function and rest of code //
public class SierpinskiCarpet {

    // Create a 2D character array to represent the carpet
    static char[][] carpet;

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to input a size for the Sierpinski carpet
        System.out.print("Enter a size for the Sierpinski carpet (or q to quit): ");
        String input = sc.nextLine();

        // Keep asking the user for input until they enter 'q'
        while (!input.equals("q")) {
            // Parse the input as an integer
            int size = Integer.parseInt(input);

            // Initialize the carpet array with spaces
            carpet = new char[3 * size][3 * size];
            for (int i = 0; i < 3 * size; i++) {
                for (int j = 0; j < 3 * size; j++) {
                    carpet[i][j] = ' ';
                }
            }

            // Call the recursive function to generate the Sierpinski carpet
            generateCarpet(carpet, 0, 0, 3 * size);

            // Print the resulting carpet to the console
            for (int i = 0; i < 3 * size; i++) {
                for (int j = 0; j < 3 * size; j++) {
                    System.out.print(carpet[i][j] + " ");
                }
                System.out.println();
            }

            // Ask the user for another input
            System.out.print("Enter a size for the Sierpinski carpet (or q to quit): ");
            input = sc.nextLine();
        }
    }

    // Recursive function to generate the Sierpinski carpet
    public static void generateCarpet(char[][] carpet, int x, int y, int n) {
        // Base case: if the size of the sub-carpet is 1, set the character at position (x, y) to '*'
        if (n == 1) {
            carpet[x][y] = '*';
            return;
        }

        // Recursively generate the eight sub-carpets
        generateCarpet(carpet, x, y, n / 3);
        generateCarpet(carpet, x, y + n / 3, n / 3);
        generateCarpet(carpet, x, y + 2 * n / 3, n / 3);
        generateCarpet(carpet, x + n / 3, y, n / 3);
        generateCarpet(carpet, x + n / 3, y + 2 * n / 3, n / 3);
        generateCarpet(carpet, x + 2 * n / 3, y, n / 3);
        generateCarpet(carpet, x + 2 * n / 3, y + n / 3, n / 3);
        generateCarpet(carpet, x + 2 * n / 3, y + 2 * n / 3, n / 3);
    }
}

