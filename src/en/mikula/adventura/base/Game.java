package en.mikula.adventura.base;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class Game {

    private final InputReader inputReader;

    private final Timer timer;

    private final Player player;

    private boolean hasEnded = false;

    public Game() {
        inputReader = new InputReader(this);
        player = new Player(this);
        timer = new Timer();
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

}
