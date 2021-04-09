package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class WhereCommand implements Command {

    private final Game game;

    public WhereCommand(Game game) {
        this.game = game;
    }

    public String signature() {
        return "where";
    }

    public String help() {
        return "Tells the current location";
    }

    public String run(String... args) {
        return game.getMap().getCurrentRoom().getName();
    }

}
