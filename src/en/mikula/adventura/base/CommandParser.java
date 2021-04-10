package en.mikula.adventura.base;

import en.mikula.adventura.factories.CommandListFactory;

import java.util.Arrays;

/**
 * Parses the commands from user input
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class CommandParser {

    private final CommandList commandList;

    public CommandParser(Game game) {
        commandList = CommandListFactory.buildCommandList(game);
    }

    /**
     * Parses the line, checks if a command is valid
     * and runs the command with some arguments
     *
     * @param line line that user entered
     * @return the result of the command
     */
    public String parseCommand(String line) {
        // User entered empty string
        if (line.isEmpty()) {
            throw new IllegalArgumentException("You did not enter any command!");
        }

        String[] words = line.split("[ \t]+");

        String signature = words[0];

        // Throw exception if the command is not valid
        if (!commandList.isValidCommand(signature)) {
            throw new IllegalArgumentException("Command [" + signature + "] is invalid. Try another one!");
        }

        // There is only 1 word in the array, no params added
        if (words.length < 2) {
            return commandList.getCommand(signature).run();
        }

        return commandList.getCommand(signature).run(Arrays.copyOfRange(words, 1, words.length));
    }

    public CommandList getCommandList() {
        return commandList;
    }
}
