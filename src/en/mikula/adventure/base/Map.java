package en.mikula.adventure.base;

import en.mikula.adventure.rooms.Room;
import en.mikula.adventure.rooms.RoomCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Map {

    /**
     * Default starting room constant
     */
    public static RoomCode STARTING_ROOM = RoomCode.ROOM_0;

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
     * Array of previous rooms
     */
    private LinkedList<Room> previousRooms = new LinkedList<>();

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
        return previousRooms.removeLast();
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
    public void changeCurrentRoom(Room room, boolean shouldAddToPrevious) {
        if (shouldAddToPrevious) {
            previousRooms.add(currentRoom);
        }

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
