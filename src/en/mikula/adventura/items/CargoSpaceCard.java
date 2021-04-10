package en.mikula.adventura.items;

/**
 * @author Marek Mikula
 * @version 4/10/2021
 */
public class CargoSpaceCard extends Item {

    @Override
    public String getName() {
        return "Cargo space card";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_7;
    }

}
