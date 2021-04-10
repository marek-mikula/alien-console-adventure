package en.mikula.adventura.base;

import en.mikula.adventura.factories.MapFactory;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class Game {

    private final InputReader inputReader;

    private final Timer timer;

    private final Map map;

    private final Inventory inventory;

    private boolean hasEnded = false;

    public Game() {
        inputReader = new InputReader(this);
        timer = new Timer();
        map = MapFactory.buildMap(this);
        inventory = new Inventory(this);
    }

    public void start() {
        StaticText.startingText();

        while (!hasEnded) {
            try {
                System.out.println(this.inputReader.readCommand());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        StaticText.endingText(timer.stopTimer());
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
