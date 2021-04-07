package en.mikula.adventura.factories;

import en.mikula.adventura.base.CommandList;
import en.mikula.adventura.base.Game;
import en.mikula.adventura.commands.HelpCommand;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class CommandListFactory {

    /**
     * Builds the command list
     *
     * @param game Game instance
     * @return Created command list
     */
    public static CommandList buildCommandList(Game game) {
        CommandList commandList = new CommandList();

        commandList.addCommand(new HelpCommand(game));

        return commandList;
    }

}
