package en.mikula.adventure.items.terminals;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.rooms.CargoSpace;
import en.mikula.adventure.rooms.RoomCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class CargoSpaceControlTerminal extends Terminal {

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
    protected List<String> getOptions() {
        List<String> options = new ArrayList<>();

        CargoSpace cargoSpace = (CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4);

        if (cargoSpace.isRampOpened()) {
            options.add("Close cargo platform");
        } else {
            options.add("Open cargo platform");
        }

        options.add("Close terminal");

        return options;
    }

    @Override
    protected void handleInteraction(int optionCode) {
        switch (optionCode) {
            case 0: // open/close cargo space ramp
                CargoSpace cargoSpace = (CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4);

                if (cargoSpace.isRampOpened()) {
                    cargoSpace.setIsRampOpened(false);
                    System.out.println("The ramp in the cargo space room has been closed!");
                } else {
                    cargoSpace.setIsRampOpened(true);
                    System.out.println("The ramp in the cargo space room has been opened!");

                    // Check if aliens are still there, if so, remove them!
                    if (cargoSpace.isAlienHere()) {
                        cargoSpace.setIsAlienHere(false);
                        System.out.println("The monsters in the cargo space should be now gone!");
                    }
                }
                break;
            case 1: // close terminal
                active = false;
                break;
            default:
                this.undefinedOptionSelected();
        }
    }

}
