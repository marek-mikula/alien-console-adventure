package en.mikula.adventure.factories;

import en.mikula.adventure.base.CommandList;
import en.mikula.adventure.base.Game;
import en.mikula.adventure.commands.*;

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
        commandList.addCommand(new GoCommand(game));
        commandList.addCommand(new SearchCommand(game));
        commandList.addCommand(new MapCommand(game));
        commandList.addCommand(new InteractCommand(game));
        commandList.addCommand(new PickCommand(game));
        commandList.addCommand(new DropCommand(game));
        commandList.addCommand(new InventoryCommand(game));
        commandList.addCommand(new OpenCommand(game));

        return commandList;
    }

}
