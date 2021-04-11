package en.mikula.adventure.rooms;

/**
 * @author Marek Mikula
 * @version 4/10/2021
 */
public class Ventilation extends Room {

    @Override
    public String getName() {
        return "Ventilation";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_6;
    }

}
