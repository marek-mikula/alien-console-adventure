package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;

/**
 * Ends the game
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class EndCommand implements Command {

    private final Game game;

    public EndCommand(Game game) {
        this.game = game;
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
