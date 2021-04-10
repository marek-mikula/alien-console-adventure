package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.items.Item;

import java.util.HashSet;

/**
 * Searches the current room showing all
 * available items
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class SearchCommand implements Command {

    private final Game game;

    public SearchCommand(Game game) {
        this.game = game;
    }

    public String signature() {
        return "search";
    }

    public String fullSignature() {
        return this.signature();
    }

    public String help() {
        return "Searches the current room and shows list of available items.";
    }

    public String run(String... args) {
        HashSet<Item> items = game.getMap().getCurrentRoom().getItems();

        if (items.isEmpty()) {
            return "There are not items in the current room.";
        }

        StringBuilder itemList = new StringBuilder("Available items:");

        for (Item item : items) {
            itemList.append("\n").append("[").append(item.getCode().getNumber()).append("] ").append(item.getName());
        }

        return itemList.toString();
    }

}
