package en.mikula.adventura.base;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class Game {

    private final InputReader inputReader;

    private boolean hasEnded = false;

    public Game() {
        this.inputReader = new InputReader(this);
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

        StaticText.endingText();
    }

    public void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }

}
