package en.mikula.adventure.items.terminals;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.rooms.EscapeModuleSector;
import en.mikula.adventure.rooms.RoomCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class EscapeModuleSectorTerminal extends Terminal {

    private final int OPTION_0 = 0;
    private final int OPTION_1 = 1;

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
    protected Map<Integer, String> getOptions() {
        Map<Integer, String> options = new HashMap<>();

        EscapeModuleSector cargoSpace = (EscapeModuleSector) game.getMap().getRoom(RoomCode.ROOM_7);

        if (!cargoSpace.isModuleReady()) {
            options.put(OPTION_0, "Get the escape module ready");
        }

        options.put(OPTION_1, "Close terminal");

        return options;
    }

    @Override
    protected void handleInteraction(int optionCode) {
        switch (optionCode) {
            case OPTION_0:
                ((EscapeModuleSector) game.getMap().getRoom(RoomCode.ROOM_7)).setIsModuleReady(true);
                System.out.println("Escape module is ready to go!");
                break;
            case OPTION_1:
                active = false;
                break;
            default:
                this.undefinedOptionSelected();
        }
    }

}
