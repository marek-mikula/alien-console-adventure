package en.mikula.adventura.rooms;

import en.mikula.adventura.base.Game;

/**
 * @author Marek Mikula
 * @version 4/10/2021
 */
public class Ventilation extends Room {

    public Ventilation(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Ventilation";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_7;
    }

}
