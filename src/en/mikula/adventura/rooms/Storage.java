package en.mikula.adventura.rooms;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Storage extends Room {

    @Override
    public String getName() {
        return "Storage room";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_5;
    }

}
