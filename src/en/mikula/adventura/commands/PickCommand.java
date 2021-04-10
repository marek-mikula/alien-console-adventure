package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.items.Item;
import en.mikula.adventura.items.Pickable;

/**
 * Picks and item in the current room
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class PickCommand implements Command {

    private final Game game;

    public PickCommand(Game game) {
        this.game = game;
    }

    public String signature() {
        return "pick";
    }

    @Override
    public String fullSignature() {
        return this.signature() + " {itemNumber}";
    }

    public String help() {
        return "Picks an item in the current room.";
    }

    public String run(String... args) {
        if (args.length == 0) {
            return "You haven't specified the item number.";
        }

        Item item;

        // Try to parse the int in first argument and pass it to the method
        try {
            item = game.getMap().getCurrentRoom().getItem(Integer.parseInt(args[0]));
        } catch (NumberFormatException exception) {
            return "You have to enter the number of an item as a first argument.";
        }

        if (item == null) {
            return "There is no such item in the room.";
        }

        if (!(item instanceof Pickable)) {
            return "You can't pick this item.";
        }

        // Remove the item from the current room
        game.getMap().getCurrentRoom().removeItem(item);

        // Put the item in the inventory
        game.getInventory().addItem(item);

        return "You picked the item [" + item.getName() + "].";
    }

}
