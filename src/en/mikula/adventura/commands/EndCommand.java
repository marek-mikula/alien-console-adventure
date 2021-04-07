package en.mikula.adventura.commands;

import en.mikula.adventura.base.CommandList;
import en.mikula.adventura.base.Game;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class EndCommand extends Command {

    public EndCommand(Game game, CommandList commandList) {
        super(game, commandList);
    }

    public String signature() {
        return "end";
    }

    public String help() {
        return "Ends the game";
    }

    public String run(String... args) {
        game.setHasEnded(true);
        return "The game has ended.";
    }

}
