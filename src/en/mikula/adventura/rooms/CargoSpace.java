package en.mikula.adventura.rooms;

import en.mikula.adventura.base.Game;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class CargoSpace extends Room {

    private boolean isRampOpened = false;

    public CargoSpace(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Cargo space";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_4;
    }

    public void setIsRampOpened(boolean isRampOpened) {
        this.isRampOpened = isRampOpened;
    }

    public boolean isRampOpened() {
        return isRampOpened;
    }

}
