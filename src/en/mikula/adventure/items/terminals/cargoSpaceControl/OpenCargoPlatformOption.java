package en.mikula.adventure.items.terminals.cargoSpaceControl;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.items.terminals.TerminalOption;
import en.mikula.adventure.rooms.CargoSpace;
import en.mikula.adventure.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 17/5/21
 */
public class OpenCargoPlatformOption implements TerminalOption {

    private final Game game;

    public OpenCargoPlatformOption(Game game) {
        this.game = game;
    }

    public int getNumber() {
        return 2;
    }

    public String getText() {
        return "Open cargo platform";
    }

    public void handle() {
        CargoSpace cargoSpace = (CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4);

        cargoSpace.setIsRampOpened(true);
        System.out.println("The ramp in the cargo space room has been opened!");

        // Check if aliens are still there, if so, remove them!
        if (cargoSpace.isAlienHere()) {
            cargoSpace.setIsAlienHere(false);
            System.out.println("The monsters in the cargo space should be now gone!");
        }
    }

    @Override
    public Boolean shouldList() {
        return !((CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4)).isRampOpened();
    }
}
