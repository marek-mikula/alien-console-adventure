package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.rooms.Room;
import en.mikula.adventura.rooms.RoomConnection;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class GoCommand implements Command {

    private final String BACK_KEYWORD = "back";

    private final Game game;

    public GoCommand(Game game) {
        this.game = game;
    }

    public String signature() {
        return "go";
    }

    public String help() {
        return "Moves Ellen to a different room. Use room number instead the label!";
    }

    public String run(String... args) {
        if (args.length == 0) {
            return "You haven't specified the room";
        }

        RoomConnection next = null;

        // Try to parse the int in first argument and pass it to the method
        try {
            next = game.getMap().getCurrentRoom().getNext(Integer.parseInt(args[0]));
        } catch (NumberFormatException exception) {
            // User used the BACK keyword to go to previous room
            if (args[0].equals(this.BACK_KEYWORD)) {
                Room previousRoom = game.getMap().getPreviousRoom();

                if (previousRoom == null) {
                    return "There is no previous position!";
                }

                next = game.getMap().getCurrentRoom().getNext(
                        previousRoom.getRoomCode().getNumber()
                );
            } else {
                return "You have to enter the number of the room as a first argument.";
            }
        }

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

        game.getMap().changeCurrentRoom(nextRoom);

        return "You entered room [" + nextRoom.getName() + "]";
    }

}
