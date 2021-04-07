package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public abstract class Command {

    protected final Game game;

    public Command(Game game) {
        this.game = game;
    }

    /**
     * Returns the command signature
     *
     * @return String
     */
    public abstract String signature();

    /**
     * Method which handles the current command
     *
     * @param args array of params which user entered
     * @return string
     */
    public abstract String run(String... args);

}
