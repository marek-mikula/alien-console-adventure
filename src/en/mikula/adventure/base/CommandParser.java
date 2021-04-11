package en.mikula.adventure.base;

import en.mikula.adventure.factories.CommandListFactory;

import java.util.Arrays;

/**
 * Class used for parsing user input strings to
 * commands
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
     * and runs the command with all arguments from user
     *
     * @param line line that user entered
     * @return the result of the command
     */
    public String parseCommand(String line) {
        // User entered empty string
        if (line.isEmpty()) {
            throw new IllegalArgumentException("You did not enter any command!");
        }

        // Split the line by tabs or spaces
        String[] words = line.split("[ \t]+");

        // The first item of the array should be the signature of the command
        String signature = words[0];

        // Throw exception if the command is not valid
        if (!commandList.isValidCommand(signature)) {
            throw new IllegalArgumentException("Command [" + signature + "] is invalid. Try another one!");
        }

        return commandList.getCommand(signature).run(
                // Obtain only the subarray of arguments from the whole array
                Arrays.copyOfRange(words, 1, words.length)
        );
    }
}