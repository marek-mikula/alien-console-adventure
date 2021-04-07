package en.mikula.adventura.commands;

import en.mikula.adventura.base.CommandList;
import en.mikula.adventura.base.Game;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class HelpCommand extends Command {

    public HelpCommand(Game game, CommandList commandList) {
        super(game, commandList);
    }

    public String signature() {
        return "help";
    }

    public String help() {
        return "Shows list of possible commands";
    }

    /**
     * Shows all available commands
     *
     * @param args array of params which user entered
     * @return list of all available commands
     */
    public String run(String... args) {
        StringBuilder response = new StringBuilder("Available commands:");

        for (Command command : commandList.getCommands().values()) {
            response.append("\n").append("[").append(command.signature()).append("] - ").append(command.help());
        }

        return response.toString();
    }

}
