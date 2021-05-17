package en.mikula.adventure.base;

import en.mikula.adventure.base.inputs.Input;
import en.mikula.adventure.factories.MapFactory;
import en.mikula.adventure.text.GameText;

/**
 * Main game class which handles the main
 * while loop
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class Game {

    private final CommandReader commandReader;

    private final Map map;

    private final Inventory inventory;

    private boolean hasEnded = false;

    public Game() {
        commandReader = new CommandReader(this);
        map = MapFactory.buildMap(this);
        inventory = new Inventory();
    }

    /**
     * Main method which handles the main
     * while loop
     */
    public void start() {
        GameText.startingText();

        while (!hasEnded) {
            try {
                System.out.println(commandReader.readCommand());
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }

        GameText.endingText();
    }

    /**
     * Sets the state if game ended
     *
     * @param hasEnded state
     */
    public void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }

    /**
     * @return map
     */
    public Map getMap() {
        return map;
    }

    /**
     * @return inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Allows other components to use input reader
     *
     * @return current input implementation
     */
    public Input getInput() {
        return commandReader.getInput();
    }

}
