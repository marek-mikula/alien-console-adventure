package en.mikula.adventura.rooms;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoomConnection roomConnection = (RoomConnection) o;
        return Objects.equals(to, roomConnection.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to);
    }
}
