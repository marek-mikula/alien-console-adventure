package en.mikula.adventura.base;

import en.mikula.adventura.rooms.Room;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Map {

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

}
