package en.mikula.adventura.commands;

import en.mikula.adventura.base.CommandList;
import en.mikula.adventura.base.Game;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public abstract class Command {

    protected final Game game;

    protected final CommandList commandList;

    public Command(Game game, CommandList commandList) {
        this.game = game;
        this.commandList = commandList;
    }

    /**
     * Gets the command signature
     *
     * @return String
     */
    public abstract String signature();

    /**
     * Gets the help message for command
     *
     * @return help message
     */
    public abstract String help();

    /**
     * Method which handles the current command
     *
     * @param args array of params which user entered
     * @return string
     */
    public abstract String run(String... args);

}
