package en.mikula.adventura.commands;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.rooms.RoomConnection;

/**
 * Shows the current room name and possible
 * exits
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class WhereCommand implements Command {

    private final Game game;

    public WhereCommand(Game game) {
        this.game = game;
    }

    public String signature() {
        return "where";
    }

    public String help() {
        return "Tells the current room and shows possible exists";
    }

    public String run(String... args) {
        StringBuilder response = new StringBuilder("Current room: ").append(game.getMap().getCurrentRoom().getName()).append("\nExits:");

        for (RoomConnection roomConnection : game.getMap().getCurrentRoom().getConnections()) {
            response.append("\n").append("[").append(roomConnection.getNext().getRoomCode().getNumber()).append("]").append(" ").append(roomConnection.getNext().getName());
        }

        return response.toString();
    }

}
