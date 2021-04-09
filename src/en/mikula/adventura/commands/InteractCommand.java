package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.items.Interactive;
import en.mikula.adventura.items.Item;

/**
 * Interacts with an item
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class InteractCommand implements Command {

    private final Game game;

    public InteractCommand(Game game) {
        this.game = game;
    }

    public String signature() {
        return "interact";
    }

    public String help() {
        return "Interacts with an item";
    }

    public String run(String... args) {
        if (args.length == 0) {
            return "You haven't specified the item";
        }

        Item item = null;

        // Try to parse the int in first argument and pass it to the method
        try {
            item = game.getMap().getCurrentRoom().getItem(Integer.parseInt(args[0]));
        } catch (NumberFormatException exception) {
            return "You have to enter the number of an item as a first argument.";
        }

        if (item == null) {
            return "There is no such item in the room.";
        }

        if (!(item instanceof Interactive)) {
            return "You can't interact with this item.";
        }

        return ((Interactive) item).interact();
    }

}
