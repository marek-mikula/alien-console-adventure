package en.mikula.adventura.items;

import en.mikula.adventura.base.Game;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class CommandersBody extends Item implements Interactive {

    private boolean bodySearched = false;

    private final Game game;

    public CommandersBody(Game game) {
        this.game = game;
    }

    @Override
    public String getName() {
        return "Commanding officer's body";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_2;
    }

    public String interact() {
        if (bodySearched) {
            return "You already searched the body.";
        }

        this.bodySearched = true;

        CargoSpaceCard cargoSpaceCard = new CargoSpaceCard();

        game.getInventory().addItem(cargoSpaceCard);

        return "You obtained [" + cargoSpaceCard.getName() + "].";
    }

}
