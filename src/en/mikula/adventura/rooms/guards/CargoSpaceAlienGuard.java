package en.mikula.adventura.rooms.guards;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.rooms.CargoSpace;
import en.mikula.adventura.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 4/10/2021
 */
public class CargoSpaceAlienGuard implements RoomGuard {

    private final Game game;

    public CargoSpaceAlienGuard(Game game) {
        this.game = game;
    }

    @Override
    public boolean passed() {
        return !(((CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4)).isAlienHere());
    }

    @Override
    public String errorMessage() {
        return "As you enter the cargo space room. You can see group of hideous creatures. Maybe you could open the ramp to get rid of them! But now the path is not safe!";
    }

}
