package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.items.Item;
import en.mikula.adventura.items.Pickable;

/**
 * Drops and item
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class DropCommand implements Command {

    private final Game game;

    public DropCommand(Game game) {
        this.game = game;
    }

    public String signature() {
        return "drop";
    }

    public String help() {
        return "Drops an item. Use the item number.";
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

        game.getMap().getCurrentRoom().addItem(item);
        game.getInventory().removeItem(item);

        return "You dropped an item [" + item.getName() + "].";
    }

}
