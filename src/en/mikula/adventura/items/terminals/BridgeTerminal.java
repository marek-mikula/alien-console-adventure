package en.mikula.adventura.items.terminals;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.items.ItemCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class BridgeTerminal extends Terminal {

    private final int OPTION_0 = 0;
    private final int OPTION_1 = 1;

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
    protected Map<Integer, String> getOptions() {
        Map<Integer, String> options = new HashMap<>();

        options.put(OPTION_0, "Show status of escape modules");
        options.put(OPTION_1, "Close terminal");

        return options;
    }

    @Override
    protected void handleInteraction(int optionCode) {
        switch (optionCode) {
            case OPTION_0:
                System.out.println("Number of escape modules used: 36\n" + "Number of escape modules left: 1");
                break;
            case OPTION_1:
                active = false;
                break;
            default:
                this.undefinedOptionSelected();
        }
    }
}
