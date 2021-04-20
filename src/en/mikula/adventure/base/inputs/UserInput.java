package en.mikula.adventure.base.inputs;

import java.util.Scanner;

/**
 * Reads input from user
 *
 * @author Marek Mikula
 * @version 4/20/2021
 */
public class UserInput implements Input {

    private final Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
