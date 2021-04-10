package en.mikula.adventure.rooms;

import java.util.Objects;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class RoomConnection {

    private final Room next;

    private boolean isLocked = false;

    private boolean isBlocked = false;

    public RoomConnection(Room next) {
        this.next = next;
    }

    public RoomConnection setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
        return this;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public RoomConnection setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
        return this;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public Room getNext() {
        return next;
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
        return next.equals(roomConnection.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(next);
    }
}
