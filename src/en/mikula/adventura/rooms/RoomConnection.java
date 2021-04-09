package en.mikula.adventura.rooms;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class RoomConnection {

    private final Room to;

    private boolean isLocked = false;

    private boolean isBlocked = false;

    public RoomConnection(Room to) {
        this.to = to;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

}
