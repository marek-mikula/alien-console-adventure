package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.rooms.RoomCode;
import en.mikula.adventura.rooms.RoomConnection;

/**
 * Shows the map of the game with the current highlighted
 * room and available exits
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class MapCommand implements Command {

    private final Game game;

    public MapCommand(Game game) {
        this.game = game;
    }

    public String signature() {
        return "map";
    }

    public String fullSignature() {
        return this.signature();
    }

    public String help() {
        return "Shows the map of the game, current room and possible exits.";
    }

    public String run(String... args) {
        String[] numbers = new String[RoomCode.values().length];

        RoomCode currentRoomCode = game.getMap().getCurrentRoom().getRoomCode();

        // Loop trough all the room codes and highlight current room using ANSI escape codes
        for (RoomCode roomCode: RoomCode.values()) {
            if (currentRoomCode.equals(roomCode)) {
                numbers[roomCode.getNumber()] = "\u001B[32m" + roomCode.getNumber() + "\u001B[0m";
            } else {
                numbers[roomCode.getNumber()] = "" + roomCode.getNumber();
            }
        }

        StringBuilder map = new StringBuilder(String.join("\n", new String[]{
                "#################",
                "#┌-┐###┌-┐###┌-┐#",
                "#|%s|---|%s|---|%s|#",
                "#└-┘###└-┘###└-┘#",
                "##|#####|##\\#####",
                "##|####┌-┐###┌-┐#",
                "##|####|%s|###|%s|#",
                "##|####└-┘###└-┘#",
                "##|#####|#####|##",
                "##|####┌-┐####|##",
                "##|####|%s|####|##",
                "##|####└-┘####|##",
                "##|###########|##",
                "#┌-┐#########┌-┐#",
                "#|%s|---------|%s|#",
                "#└-┘#########└-┘#",
                "#################",
        }));

        map.append("\nExits:");

        // Append list of available exits
        for (RoomConnection roomConnection : game.getMap().getCurrentRoom().getConnections()) {
            map.append("\n").append("[").append(roomConnection.getNext().getRoomCode().getNumber()).append("]").append(" ").append(roomConnection.getNext().getName());
        }

        return String.format(map.toString(),
                numbers[RoomCode.ROOM_4.getNumber()],
                numbers[RoomCode.ROOM_1.getNumber()],
                numbers[RoomCode.ROOM_0.getNumber()],
                numbers[RoomCode.ROOM_2.getNumber()],
                numbers[RoomCode.ROOM_6.getNumber()],
                numbers[RoomCode.ROOM_3.getNumber()],
                numbers[RoomCode.ROOM_5.getNumber()],
                numbers[RoomCode.ROOM_7.getNumber()]
                );
    }

}
