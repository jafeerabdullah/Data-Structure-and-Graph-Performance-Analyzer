/*
 * CIT300 - Data Structures and Algorithms
 * Data Structure and Graph Performance Analyzer
 *
 * Purpose: Shared application integration and input validation
 */
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    // Reading whole lines avoids the nextInt()/nextLine() newline problem.
    public int readInt() {
        return readInt("Enter a value: ");
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = readLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException error) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public int readMenuChoice(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum choice cannot exceed maximum choice.");
        }
        while (true) {
            int choice = readInt("Enter your choice: ");
            if (choice >= min && choice <= max) {
                return choice;
            }
            System.out.println("Please enter a choice between " + min + " and " + max + ".");
        }
    }

    public String readString() {
        return readString("Enter a name: ");
    }

    public String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = readLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty. Please enter a value.");
        }
    }

    private String readLine() {
        if (!scanner.hasNextLine()) {
            throw new NoSuchElementException("Input ended.");
        }
        return scanner.nextLine();
    }
}
