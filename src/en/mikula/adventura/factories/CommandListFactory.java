package en.mikula.adventura.factories;

import en.mikula.adventura.base.CommandList;
import en.mikula.adventura.base.Game;
import en.mikula.adventura.commands.EndCommand;
import en.mikula.adventura.commands.HelpCommand;

/**
 * Builds the command list
 * 
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class CommandListFactory {

    /**
     * Builds the command list and fills it
     * with valid commands
     *
     * @param game game instance
     * @return created command list
     */
    public static CommandList buildCommandList(Game game) {
        CommandList commandList = new CommandList();

        commandList.addCommand(new HelpCommand(commandList));
        commandList.addCommand(new EndCommand(game));

        return commandList;
    }

}
