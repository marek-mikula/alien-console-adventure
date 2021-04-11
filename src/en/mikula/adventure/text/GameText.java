package en.mikula.adventure.text;

/**
 * Class used to store static texts outside of the Game
 * class so the main game class won't be bothered with
 * these long methods
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class GameText {

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
                "You are one of the main control technics on the Nostromo ship owned by space-mining company Weyland-Yutani. The Nostromo serves a as mother ship for miners who work on the planet LV178 not too far to Nostromo. There are two groups of miners, the first one is on the planet working, the second is resting on the mother ship. Every month there is a change between these two groups. You are waking up after a long day shift on the mother ship Nostromo. Something is not right. You've been woken up by an emergency siren and a smell of burnt plastic. You should go to command bridge and find out what is going on.",
                "Use 'help' command to list all available commands. Good luck."
        };
        System.out.println(String.join("\n", text));
    }

    /**
     * Renders ending text to user
     */
    public static void endingText() {
        String[] text = {
                "The end",
                "Thanks for playing, Marek Mikula"
        };
        System.out.println(String.join("\n", text));
    }

}
