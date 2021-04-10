package en.mikula.adventura.items.terminals;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.items.ItemCode;
import en.mikula.adventura.rooms.CargoSpace;
import en.mikula.adventura.rooms.RoomCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class CargoSpaceControlTerminal extends Terminal {

    private final int OPTION_0 = 0;
    private final int OPTION_1 = 1;
    private final int OPTION_2 = 2;

    public CargoSpaceControlTerminal(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Cargo space control terminal";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_3;
    }

    @Override
    protected Map<Integer, String> getOptions() {
        Map<Integer, String> options = new HashMap<>();

        CargoSpace cargoSpace = (CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4);

        if (cargoSpace.isRampOpened()) {
            options.put(OPTION_1, "Close cargo platform");
        } else {
            options.put(OPTION_0, "Open cargo platform");
        }

        options.put(OPTION_2, "Close terminal");

        return options;
    }

    @Override
    protected void handleInteraction(int optionCode) {
        switch (optionCode) {
            case OPTION_0:
                CargoSpace cargoSpace = (CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4);

                cargoSpace.setIsRampOpened(true);
                System.out.println("The ramp of the cargo space has been opened!");

                if (cargoSpace.isAlienHere()) {
                    cargoSpace.setIsAlienHere(false);
                    System.out.println("The monsters in the cargo space should be now gone!");
                }
                break;
            case OPTION_1:
                ((CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4)).setIsRampOpened(false);
                System.out.println("The ramp of the cargo space has been closed!");
                break;
            case OPTION_2:
                active = false;
                break;
            default:
                this.undefinedOptionSelected();
        }
    }

}
