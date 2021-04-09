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
                "written by Marek Mikula",
                "subject: Ellen Ripley",
                "year: 2159",
                "location: mother ship Nostromo, planet LV178",
                "You are waking up after a long day shift as a control technic on the mother ship Nostromo. Something is not right. " +
                        "You've been woken up by an emergency siren and a smell of burnt plastic. You need to check out what's going on.",
                "Use 'help' command to list all available commands. Good luck."
        };
        System.out.println(String.join("\n", text));
    }

    /**
     * Renders ending text to user
     */
    public static void endingText(long time) {

        System.out.println(time);

        String[] text = {
                "Díky",
                "Čau",
                "Čas: " + (time / 1000)
        };
        System.out.println(String.join("\n", text));
    }

}