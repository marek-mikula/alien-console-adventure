package en.mikula.adventure.items.terminals.bridge;

import en.mikula.adventure.items.terminals.TerminalOption;

/**
 * @author Marek Mikula
 * @version 17/5/21
 */
public class ShowStatusOfEscapeModulesOption implements TerminalOption {

    public int getNumber() {
        return 2;
    }

    public String getText() {
        return "Show status of escape modules";
    }

    public void handle() {
        System.out.println("Number of escape modules used: 76");
        System.out.println("Number of escape modules left: 1");
    }

}
