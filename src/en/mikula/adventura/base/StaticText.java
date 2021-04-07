package en.mikula.adventura.base;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class StaticText {
    /**
     * Renders starting text to user
     */
    public static void startingText() {
        String[] text = {
                "Alien",
                "Written by Marek Mikula"
        };
        System.out.println(String.join("\n", text));
    }

    /**
     * Renders ending text to user
     */
    public static void endingText() {
        String[] text = {
                "Díky",
                "Čau"
        };
        System.out.println(String.join("\n", text));
    }

}
