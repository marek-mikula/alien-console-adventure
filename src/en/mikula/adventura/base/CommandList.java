package en.mikula.adventura.base;

import en.mikula.adventura.commands.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class CommandList {

    private Map<String, Command> commands = new HashMap();

    /**
     * Adds new command to map
     *
     * @param command command instance to add
     */
    public void addCommand(Command command) {
        commands.put(command.signature(), command);
    }

    /**
     * Checks if a signature key exists in the map
     *
     * @param signature the signature of the command
     * @return true if the signature is valid, otherwise false
     */
    public boolean isValidCommand(String signature) {
        return commands.containsKey(signature);
    }

    /**
     * Gets the command by given signature if in the list
     *
     * @param signature the signature of the command
     * @return command instance or null
     */
    public Command getCommand(String signature) {
        return commands.getOrDefault(signature, null);
    }

}
