package en.mikula.adventura.base;

import en.mikula.adventura.rooms.Room;
import en.mikula.adventura.rooms.RoomCode;

import java.util.HashSet;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Map {

    /**
     * List of all rooms
     */
    private final HashSet<Room> rooms = new HashSet<>();

    /**
     * Current room reference
     */
    private Room currentRoom;

    /**
     * Previous room reference
     */
    private Room previousRoom;

    /**
     * Gets the current room
     *
     * @return current room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Gets the previous room
     *
     * @return previous room
     */
    public Room getPreviousRoom() {
        return previousRoom;
    }

    /**
     * Adds room to the list
     *
     * @param room to be added
     * @return boolean if successfully added
     */
    public boolean addRoom(Room room) {
        return rooms.add(room);
    }

    /**
     * Changes the current room
     *
     * @param room new room
     */
    public void changeCurrentRoom(Room room) {
        previousRoom = currentRoom;
        currentRoom = room;
    }

    /**
     * Gets the room by given room code enum
     *
     * @param roomCode enum reference
     * @return room or null
     */
    public Room getRoom(RoomCode roomCode) {
        for (Room room : rooms) {
            if (room.getRoomCode().equals(roomCode)) {
                return room;
            }
        }

        return null;
    }

}
