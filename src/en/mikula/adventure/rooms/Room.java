package en.mikula.adventure.rooms;

import en.mikula.adventure.items.Item;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.rooms.guards.RoomGuard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * Abstract class for all rooms
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public abstract class Room {

    private final HashSet<RoomConnection> connections = new HashSet<>();

    private final HashSet<Item> items = new HashSet<>();

    private final List<RoomGuard> guards = new ArrayList<>();

    /**
     * Adds a new connection to the set
     *
     * @param roomConnection specifies the landing room
     * @return boolean if added, otherwise false
     */
    public boolean addConnection(RoomConnection roomConnection) {
        return connections.add(roomConnection);
    }

    /**
     * @return the set of all connections
     */
    public HashSet<RoomConnection> getConnections() {
        return connections;
    }

    /**
     * Gets the next connection if any
     *
     * @param roomCode the room code which should correspond
     *                 with the code of the next room
     * @return RoomConnection or null if not found
     * @see RoomCode
     */
    public RoomConnection getNext(int roomCode) {
        for (RoomConnection roomConnection : connections) {
            if (roomConnection.getNext().getRoomCode().getNumber() == roomCode) {
                return roomConnection;
            }
        }

        return null;
    }

    public boolean addItem(Item item) {
        return items.add(item);
    }

    public HashSet<Item> getItems() {
        return items;
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    /**
     * Gets the item by item code
     *
     * @param itemCode integer item code
     * @return item if any
     * @see ItemCode
     */
    public Item getItem(int itemCode) {
        for (Item item : items) {
            if (item.getCode().getNumber() == itemCode) {
                return item;
            }
        }

        return null;
    }

    public boolean addGuard(RoomGuard guard) {
        return guards.add(guard);
    }

    public List<RoomGuard> getGuards() {
        return guards;
    }

    /**
     * @return room name
     */
    public abstract String getName();

    /**
     * @return room code
     */
    public abstract RoomCode getRoomCode();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return room.getRoomCode().equals(this.getRoomCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getRoomCode().getNumber());
    }

}
