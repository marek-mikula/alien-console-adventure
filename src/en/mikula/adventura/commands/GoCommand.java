package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.rooms.Room;
import en.mikula.adventura.rooms.RoomConnection;
import en.mikula.adventura.rooms.guards.RoomGuard;

/**
 * Goes to a specific room by its number
 *
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

    public String fullSignature() {
        return this.signature() + " {roomNumber|'back'}";
    }

    public String help() {
        return "Moves Ellen to a different room. Use room number or 'back' keyword!";
    }

    public String run(String... args) {
        if (args.length == 0) {
            return "You haven't specified the room number.";
        }

        RoomConnection next;

        // Try to parse the int in first argument and pass it to the method
        try {
            next = game.getMap().getCurrentRoom().getNext(Integer.parseInt(args[0]));
        } catch (NumberFormatException exception) {
            // User used the BACK keyword to go to previous room
            if (args[0].equals("back")) {
                Room previousRoom = game.getMap().getPreviousRoom();

                if (previousRoom == null) {
                    return "There is no previous position!";
                }

                next = game.getMap().getCurrentRoom().getNext(
                        previousRoom.getRoomCode().getNumber()
                );
            } else {
                return "You have to enter the number of a room as a first argument.";
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

        // Loop trough the guards of the next room and see if they pass
        for (RoomGuard guard: nextRoom.getGuards()) {
            if (!guard.passed()) {
                return guard.errorMessage();
            }
        }

        // Change current room to the next room
        game.getMap().changeCurrentRoom(nextRoom);

        return "You entered the room [" + nextRoom.getName() + "].";
    }

}
