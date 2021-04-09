package en.mikula.adventura.rooms;

import en.mikula.adventura.base.Game;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class CargoSpaceControl extends Room {

    public CargoSpaceControl(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Cargo space control room";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_3;
    }

}
