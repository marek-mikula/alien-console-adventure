package en.mikula.adventura.rooms;

import en.mikula.adventura.base.Game;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Storage extends Room {

    public Storage(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Storage room";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_5;
    }

}
