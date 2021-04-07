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
     * @param command Command instance to add
     */
    public void addCommand(Command command) {
        commands.put(command.signature(), command);
    }

    /**
     * @param signature The signature of the command
     * @return true if the signature is valid
     */
    public boolean isValidCommand(String signature) {
        return commands.containsKey(signature);
    }

    /**
     * Gets the command by given signature
     *
     * @param signature The signature of the command
     * @return Command instance if exists, otherwise null
     */
    public Command getCommand(String signature) {
        return commands.getOrDefault(signature, null);
    }

}
