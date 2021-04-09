package en.mikula.adventura.rooms;

import en.mikula.adventura.base.Game;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public abstract class Room {

    private final HashSet<RoomConnection> connections = new HashSet<>();

    private final Game game;

    public Room(Game game) {
        this.game = game;
    }

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

    public RoomConnection getNext(String roomName) {
        for (RoomConnection roomConnection : connections) {
            if (roomConnection.getNext().getName().equals(roomName)) {
                return roomConnection;
            }
        }

        return null;
    }

    public abstract String getName();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return room.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }

}
