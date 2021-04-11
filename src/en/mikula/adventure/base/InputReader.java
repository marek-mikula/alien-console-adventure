package en.mikula.adventure.base;

import java.util.Scanner;

/**
 * Reads input from user command line
 *
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
     * @return parsed command
     */
    public String readCommand() {
        return commandParser.parseCommand(readLine());
    }

    /**
     * Reads one line from user
     *
     * @return read string
     */
    private String readLine() {
        System.out.print("> ");
        return scanner.nextLine();
    }

}
