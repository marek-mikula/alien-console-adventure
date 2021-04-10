package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.items.Item;
import en.mikula.adventura.items.Usable;

/**
 * Drops and item
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class UseCommand implements Command {

    private final Game game;

    public UseCommand(Game game) {
        this.game = game;
    }

    public String signature() {
        return "use";
    }

    public String help() {
        return "Use and item from an inventory. Use the item number as a first argument.";
    }

    public String run(String... args) {
        if (args.length == 0) {
            return "You haven't specified the item number.";
        }

        Item item;

        // Try to parse the int in first argument and pass it to the method
        try {
            item = game.getInventory().getItem(Integer.parseInt(args[0]));
        } catch (NumberFormatException exception) {
            return "You have to enter the number of an item as a first argument.";
        }

        if (item == null) {
            return "There is no such item in the inventory.";
        }

        if (!(item instanceof Usable)) {
            return "You can't use this item.";
        }

        return ((Usable) item).use();
    }

}
