package en.mikula.adventura.items;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class CommandersBody implements Item {

    @Override
    public String getName() {
        return "Commanding officer's body";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_2;
    }

}
