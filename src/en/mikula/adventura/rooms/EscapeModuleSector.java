package en.mikula.adventura.rooms;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class EscapeModuleSector extends Room {

    private boolean isModuleReady = false;

    @Override
    public String getName() {
        return "Escape module sector";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_6;
    }

    public void setIsModuleReady(boolean isModuleReady) {
        this.isModuleReady = isModuleReady;
    }

    public boolean isModuleReady() {
        return isModuleReady;
    }

}
