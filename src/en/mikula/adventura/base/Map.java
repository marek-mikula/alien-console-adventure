package en.mikula.adventura.base;

import en.mikula.adventura.rooms.Room;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Map {

    private Room currentRoom;

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

}
