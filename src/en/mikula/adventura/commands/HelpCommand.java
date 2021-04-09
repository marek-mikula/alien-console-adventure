package en.mikula.adventura.commands;

import en.mikula.adventura.base.CommandList;

/**
 * Shows all available commands with their signature
 * and help text
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class HelpCommand implements Command {

    private final CommandList commandList;

    public HelpCommand(CommandList commandList) {
        this.commandList = commandList;
    }

    public String signature() {
        return "help";
    }

    public String help() {
        return "Shows list of possible commands";
    }

    public String run(String... args) {
        StringBuilder response = new StringBuilder("Available commands:");

        for (Command command : commandList.getCommands().values()) {
            response.append("\n").append("[").append(command.signature()).append("] - ").append(command.help());
        }

        return response.toString();
    }

}
