package en.mikula.adventure.base;

import en.mikula.adventure.base.inputs.Input;
import en.mikula.adventure.base.inputs.UserInput;

/**
 * Reads command from given input
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class CommandReader {

    private final Input input;

    private final CommandParser commandParser;

    public CommandReader(Game game) {
        commandParser = new CommandParser(game);
        input = new UserInput();
    }

    /**
     * Reads one line from user and pass it to
     * command parser.
     *
     * @return parsed command
     */
    public String readCommand() {
        System.out.print("> "); // Print trailing character before command
        return commandParser.parseCommand(input.readLine());
    }

    /**
     * @return current input implementation
     */
    public Input getInput() {
        return input;
    }

}
