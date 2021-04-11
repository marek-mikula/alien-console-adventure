package en.mikula.adventure.items.terminals;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.rooms.EscapeModuleSector;
import en.mikula.adventure.rooms.RoomCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class EscapeModuleSectorTerminal extends Terminal {

    public EscapeModuleSectorTerminal(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Escape module sector terminal";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_5;
    }

    @Override
    protected List<String> getOptions() {
        List<String> options = new ArrayList<>();

        EscapeModuleSector cargoSpace = (EscapeModuleSector) game.getMap().getRoom(RoomCode.ROOM_7);

        if (!cargoSpace.isModuleReady()) {
            options.add("Get the escape module ready");
        }

        options.add("Close terminal");

        return options;
    }

    @Override
    protected void handleInteraction(int optionCode) {
        switch (optionCode) {
            case 0: // prepare escape module
                ((EscapeModuleSector) game.getMap().getRoom(RoomCode.ROOM_7)).setIsModuleReady(true);
                System.out.println("Escape module is ready to go!");
                break;
            case 1:
                active = false;
                break;
            default:
                this.undefinedOptionSelected();
        }
    }

}
