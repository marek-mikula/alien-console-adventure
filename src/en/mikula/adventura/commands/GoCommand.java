package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.rooms.Room;
import en.mikula.adventura.rooms.RoomConnection;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class GoCommand implements Command {

    private final Game game;

    public GoCommand(Game game) {
        this.game = game;
    }

    public String signature() {
        return "go";
    }

    public String help() {
        return "Moves Ellen to a different room";
    }

    public String run(String... args) {
        if (args.length == 0) {
            return "You haven't specified the room";
        }

        // Build the room name using all the arguments because of gaps between words
        String roomName = String.join(" ", args);

        RoomConnection next = game.getMap().getCurrentRoom().getNext(roomName);

        if (next == null) {
            return "This room does not exists or is not connected to current room.";
        }

        // Locked room
        if (next.isLocked()) {
            return "This room connection is locked!";
        }

        // Blocked room
        if (next.isBlocked()) {
            return "This room connection is blocked!";
        }

        Room nextRoom = next.getNext();

        game.getMap().setCurrentRoom(nextRoom);

        return "You entered room [" + nextRoom.getName() + "]";
    }

}
