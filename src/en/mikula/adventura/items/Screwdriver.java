package en.mikula.adventura.items;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Screwdriver extends Item implements Pickable {

    @Override
    public String getName() {
        return "Screwdriver";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_4;
    }

}
