package en.mikula.adventura.factories;

import en.mikula.adventura.base.CommandList;
import en.mikula.adventura.base.Game;
import en.mikula.adventura.commands.*;

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
        commandList.addCommand(new WhereCommand(game));
        commandList.addCommand(new GoCommand(game));
        commandList.addCommand(new SearchCommand(game));
        commandList.addCommand(new MapCommand(game));
        commandList.addCommand(new InteractCommand(game));
        commandList.addCommand(new PickCommand(game));
        commandList.addCommand(new DropCommand(game));
        commandList.addCommand(new ItemsCommand(game));

        return commandList;
    }

}
