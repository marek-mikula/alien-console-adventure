package en.mikula.adventura.base;

import en.mikula.adventura.items.Item;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marek Mikula
 * @version 4/10/2021
 */
public class Inventory {

    private final Set<Item> items = new HashSet<>();

    private final Game game;

    public Inventory(Game game) {
        this.game = game;
    }

    public boolean addItem(Item item) {
        return items.add(item);
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public Set<Item> getItems() {
        return items;
    }

    public Item getItem(int itemCode) {
        for (Item item : items) {
            if (item.getCode().getNumber() == itemCode) {
                return item;
            }
        }

        return null;
    }

}
