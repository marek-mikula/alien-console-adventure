package en.mikula.adventure.base.inputs;

import java.util.Scanner;

/**
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
        System.out.print("> ");
        return scanner.nextLine();
    }
}
