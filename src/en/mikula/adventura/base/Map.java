package en.mikula.adventura.base;

import en.mikula.adventura.rooms.Room;
import en.mikula.adventura.rooms.RoomCode;

import java.util.HashSet;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Map {

    private final HashSet<Room> rooms = new HashSet<>();

    private Room currentRoom;

    private Room previousRoom;

    public void changeCurrentRoom(Room room) {
        previousRoom = currentRoom;
        currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public boolean addRoom(Room room) {
        return rooms.add(room);
    }

    public Room getRoom(RoomCode roomCode) {
        for (Room room: rooms) {
            if (room.getRoomCode().getNumber() == roomCode.getNumber()) {
                return room;
            }
        }

        return null;
    }

}
