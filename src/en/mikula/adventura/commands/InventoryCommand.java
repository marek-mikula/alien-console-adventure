package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.items.Item;

import java.util.HashSet;
import java.util.Set;

/**
 * Lists all items in the inventory
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class InventoryCommand implements Command {

    private final Game game;

    public InventoryCommand(Game game) {
        this.game = game;
    }

    public String signature() {
        return "inventory";
    }

    public String fullSignature() {
        return this.signature();
    }

    public String help() {
        return "Lists all items in the inventory.";
    }

    public String run(String... args) {
        Set<Item> items = game.getInventory().getItems();

        if (items.isEmpty()) {
            return "You don't have any items in the inventory.";
        }

        StringBuilder itemList = new StringBuilder("Inventory:");

        for (Item item : items) {
            itemList.append("\n").append("[").append(item.getCode().getNumber()).append("] ").append(item.getName());
        }

        return itemList.toString();
    }

}
