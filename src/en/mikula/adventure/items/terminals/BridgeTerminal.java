package en.mikula.adventure.items.terminals;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.items.ItemCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class BridgeTerminal extends Terminal {

    public BridgeTerminal(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Main bridge terminal";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_1;
    }

    @Override
    protected List<String> getOptions() {
        List<String> options = new ArrayList<>();

        options.add("Show last diary entry"); // option 0
        options.add("Show status of escape modules"); // option 1
        options.add("Close terminal"); // option 2

        return options;
    }

    @Override
    protected void handleInteraction(int optionCode) {
        switch (optionCode) {
            case 0: // last diary entry
                System.out.println("18.02.2159 01:16 - The miners should be there by like one hour. There were supposed to be some ill miners as the shift leader stated that something jumped on their heads while working in the mine. At least they got it off their heads and they are on their way to Nostromo. But I am really worried about them because they were not responding for the last couple hours of the flight...");
                System.out.println("18.02.2159 03:16 - The ship just arrived, no one is responding. We'll go to check the ship out. Ryan");
                break;
            case 1: // status of escape modules
                System.out.println("Number of escape modules used: 36");
                System.out.println("Number of escape modules left: 1");
                break;
            case 2: // close terminal
                active = false;
                break;
            default:
                this.undefinedOptionSelected();
        }
    }
}
