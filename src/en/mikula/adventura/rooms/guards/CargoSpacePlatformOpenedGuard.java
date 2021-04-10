package en.mikula.adventura.rooms.guards;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.rooms.CargoSpace;
import en.mikula.adventura.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 4/10/2021
 */
public class CargoSpacePlatformOpenedGuard implements RoomGuard {

    private final Game game;

    public CargoSpacePlatformOpenedGuard(Game game) {
        this.game = game;
    }

    @Override
    public boolean passed() {
        return !(((CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4)).isRampOpened());
    }

    @Override
    public String errorMessage() {
        return "You can't enter the cargo space if the platform is opened! First close the platform!";
    }

}
