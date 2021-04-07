package en.mikula.adventura.base;

import en.mikula.adventura.factories.CommandListFactory;

import java.util.Arrays;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class CommandParser {

    private CommandList commandList;

    public CommandParser(Game game) {
        commandList = CommandListFactory.buildCommandList(game);
    }

    /**
     * Parses the line, checks if a command is valid
     * and runs the command with some arguments
     *
     * @param line String
     * @return String
     */
    public String parseCommand(String line) {
        String[] words = line.split("[ \t]+");

        String signature = words[0];

        if (!commandList.isValidCommand(signature)) {
            throw new IllegalArgumentException("Command [" + signature + "] is invalid. Try another one!");
        }

        if (words.length < 2) {
            return commandList.getCommand(signature).run();
        }

        return commandList.getCommand(signature).run(Arrays.copyOfRange(words, 1, words.length));
    }

}
