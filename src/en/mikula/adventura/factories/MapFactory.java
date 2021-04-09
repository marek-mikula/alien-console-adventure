package en.mikula.adventura.factories;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.base.Map;
import en.mikula.adventura.items.*;
import en.mikula.adventura.rooms.*;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class MapFactory {

    /**
     * Build the rooms and their connections
     *
     * @param game game instance
     * @return built map
     */
    public static Map buildMap(Game game) {
        Room bridge = new Bridge(game);
        Room cabin = new Cabin(game);
        Room cafeteria = new Cafeteria(game);
        Room cargoSpace = new CargoSpace(game);
        Room cargoSpaceControl = new CargoSpaceControl(game);
        Room escapeModuleSector = new EscapeModuleSector(game);
        Room storage = new Storage(game);

        // Add items to the rooms

        cabin.addItem(new Diary());
        cafeteria.addItem(new CommandersBody());
        bridge.addItem(new BridgeTerminal());
        cargoSpaceControl.addItem(new CargoSpaceControlTerminal());
        cargoSpace.addItem(new Screwdriver());
        escapeModuleSector.addItem(new EscapeModuleSectorTerminal());

        // Create connections between rooms

        cabin.addConnection(new RoomConnection(bridge));

        bridge.addConnection(new RoomConnection(cabin));
        bridge.addConnection(new RoomConnection(escapeModuleSector).setIsBlocked(true));
        bridge.addConnection(new RoomConnection(cafeteria));
        bridge.addConnection(new RoomConnection(cargoSpace).setIsLocked(true));

        escapeModuleSector.addConnection(new RoomConnection(storage));
        escapeModuleSector.addConnection(new RoomConnection(bridge));

        cafeteria.addConnection(new RoomConnection(bridge));
        cafeteria.addConnection(new RoomConnection(cargoSpaceControl));

        cargoSpaceControl.addConnection(new RoomConnection(cafeteria));

        cargoSpace.addConnection(new RoomConnection(bridge));
        cargoSpace.addConnection(new RoomConnection(storage).setIsLocked(true));

        storage.addConnection(new RoomConnection(cargoSpace));
        storage.addConnection(new RoomConnection(escapeModuleSector));

        Map map = new Map();
        // TODO change
        map.changeCurrentRoom(bridge);

        return map;
    }

}
