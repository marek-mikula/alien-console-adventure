package en.mikula.adventura.rooms;

import en.mikula.adventura.base.Game;

import java.util.HashSet;

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

    public boolean addConnection(RoomConnection roomConnection) {
        return connections.add(roomConnection);
    }

}
