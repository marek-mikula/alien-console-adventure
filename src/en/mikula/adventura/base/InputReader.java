package en.mikula.adventura.base;

import java.util.Scanner;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class InputReader {

    private final Scanner scanner;

    private final CommandParser commandParser;

    public InputReader(Game game) {
        this.scanner = new Scanner(System.in);
        this.commandParser = new CommandParser(game);
    }

    /**
     * Reads one line from user and pass it to
     * command parser.
     *
     * @return Command
     */
    public String readCommand() {
        return commandParser.parseCommand(this.readLine());
    }

    /**
     * Reads input from user using Scanner
     *
     * @return String
     */
    private String readLine() {
        System.out.print("> ");
        return scanner.nextLine();
    }

}