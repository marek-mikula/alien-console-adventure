package en.mikula.adventura.base;

/**
 * @author Marek Mikula
 * @version 4/7/2021
 */
public class Timer {

    private final long start;

    public Timer() {
        start = System.currentTimeMillis();
    }

    public long stopTimer() {
        return System.currentTimeMillis() - start;
    }

}
