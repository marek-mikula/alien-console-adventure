package en.mikula.adventura.items;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.rooms.EscapeModuleSector;
import en.mikula.adventura.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class EscapeModule extends Item implements Interactive {

    private final Game game;

    public EscapeModule(Game game) {
        this.game = game;
    }

    @Override
    public String getName() {
        return "Escape module";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_6;
    }

    @Override
    public String interact() {
        EscapeModuleSector cargoSpace = (EscapeModuleSector) game.getMap().getRoom(RoomCode.ROOM_6);

        if (!cargoSpace.isModuleReady()) {
            return "The module is not ready to go. You have to prepare the module trough the terminal.";
        }

        game.setHasEnded(true);
        return "You successfully escaped the ship!";
    }
}