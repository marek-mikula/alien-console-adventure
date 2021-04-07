package en.mikula.adventura.commands;

import en.mikula.adventura.base.CommandList;
import en.mikula.adventura.base.Game;

import java.util.Map;

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

    public String run(String... args) {
        System.out.println("Available commands:");

        Map<String, Command> commands = commandList.getCommands();

        String[] array = new String[commands.size()];

        int index = 0;
        for (Command command : commands.values()) {
            array[index++] = "[" + command.signature() + "] - " + command.help();
        }

        return String.join("\n", array);
    }

}
