package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.rooms.RoomCode;

/**
 * Shows the map of the game with the current location
 * highlighted
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

    public String help() {
        return "Shows the map of the game";
    }

    public String run(String... args) {
        String[] numbers = new String[RoomCode.values().length];

        int currentRoomNumber = game.getMap().getCurrentRoom().getRoomCode().getNumber();

        // Loop trough all the room codes and highlight current room using ANSI escape codes
        for (RoomCode roomCode: RoomCode.values()) {
            if (currentRoomNumber == roomCode.getNumber()) {
                numbers[roomCode.getNumber()] = "\u001B[32m" + roomCode.getNumber() + "\u001B[0m";
            } else {
                numbers[roomCode.getNumber()] = "" + roomCode.getNumber();
            }
        }

        String map = String.join("\n", new String[]{
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
                "#┌-┐##########|##",
                "#|%s|----------┘##",
                "#└-┘#############",
                "#################",
        });

        return String.format(map,
                numbers[RoomCode.ROOM_4.getNumber()],
                numbers[RoomCode.ROOM_1.getNumber()],
                numbers[RoomCode.ROOM_0.getNumber()],
                numbers[RoomCode.ROOM_2.getNumber()],
                numbers[RoomCode.ROOM_6.getNumber()],
                numbers[RoomCode.ROOM_3.getNumber()],
                numbers[RoomCode.ROOM_5.getNumber()]
                );
    }

}
