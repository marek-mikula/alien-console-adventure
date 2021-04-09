package en.mikula.adventura.items;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class BridgeTerminal implements Item, Interactive {

    @Override
    public String getName() {
        return "Main bridge terminal";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_1;
    }

    @Override
    public String interact() {
        System.out.println("Interactive");

        return " ";
    }
}
