package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class HelpCommand extends Command {

    public HelpCommand(Game game) {
        super(game);
    }

    public String signature() {
        return "help";
    }

    public String run(String... args) {
        return "Hello";
    }

}
