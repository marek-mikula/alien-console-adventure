package en.mikula.adventura.base;

import en.mikula.adventura.factories.MapFactory;
import en.mikula.adventura.text.GameText;

/**
 * Main game class which handles the main
 * while loop
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class Game {

    private final InputReader inputReader;

    private final Map map;

    private final Inventory inventory;

    private boolean hasEnded = false;

    public Game() {
        inputReader = new InputReader(this);
        map = MapFactory.buildMap(this);
        inventory = new Inventory();
    }

    public void start() {
        GameText.startingText();

        while (!hasEnded) {
            try {
                System.out.println(this.inputReader.readCommand());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        GameText.endingText();
    }

    public void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }

    public Map getMap() {
        return map;
    }

    public Inventory getInventory() {
        return inventory;
    }

}
