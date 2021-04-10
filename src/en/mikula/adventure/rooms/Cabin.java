package en.mikula.adventure.rooms;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Cabin extends Room {

    @Override
    public String getName() {
        return "Ellen Ripley's cabin";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_0;
    }

}
