package en.mikula.adventura.factories;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.base.Map;
import en.mikula.adventura.items.*;
import en.mikula.adventura.items.terminals.BridgeTerminal;
import en.mikula.adventura.items.terminals.CargoSpaceControlTerminal;
import en.mikula.adventura.items.terminals.CargoSpaceTerminal;
import en.mikula.adventura.items.terminals.EscapeModuleSectorTerminal;
import en.mikula.adventura.rooms.*;
import en.mikula.adventura.rooms.guards.CargoSpaceAlienGuard;

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
        Map map = new Map();

        Room bridge = new Bridge();
        Room cabin = new Cabin();
        Room cafeteria = new Cafeteria();
        Room cargoSpace = new CargoSpace();
        Room cargoSpaceControl = new CargoSpaceControl();
        Room escapeModuleSector = new EscapeModuleSector();
        Room storage = new Storage();
        Room ventilation = new Ventilation();

        // Add guards

        cargoSpace.addGuard(new CargoSpaceAlienGuard(game));

        // Add items to the rooms

        cabin.addItem(new Diary());
        cafeteria.addItem(new CommandersBody(game));
        bridge.addItem(new BridgeTerminal(game));
        cargoSpaceControl.addItem(new CargoSpaceControlTerminal(game));
        cargoSpace.addItem(new Screwdriver(game));
        cargoSpace.addItem(new CargoSpaceTerminal(game));
        escapeModuleSector.addItem(new EscapeModuleSectorTerminal(game));
        escapeModuleSector.addItem(new EscapeModule(game));

        // Create connections between rooms

        cabin.addConnection(new RoomConnection(bridge));

        bridge.addConnection(new RoomConnection(cabin));
        bridge.addConnection(new RoomConnection(escapeModuleSector).setIsBlocked(true));
        bridge.addConnection(new RoomConnection(cafeteria));
        bridge.addConnection(new RoomConnection(cargoSpace).setIsLocked(true));

        escapeModuleSector.addConnection(new RoomConnection(ventilation));
        escapeModuleSector.addConnection(new RoomConnection(bridge).setIsBlocked(true));

        cafeteria.addConnection(new RoomConnection(bridge));
        cafeteria.addConnection(new RoomConnection(cargoSpaceControl));

        cargoSpaceControl.addConnection(new RoomConnection(cafeteria));

        cargoSpace.addConnection(new RoomConnection(bridge));
        cargoSpace.addConnection(new RoomConnection(storage).setIsLocked(true));

        storage.addConnection(new RoomConnection(cargoSpace));
        storage.addConnection(new RoomConnection(ventilation).setIsLocked(true));

        ventilation.addConnection(new RoomConnection(storage));
        ventilation.addConnection(new RoomConnection(escapeModuleSector));

        // Add rooms to the set

        map.addRoom(bridge);
        map.addRoom(cabin);
        map.addRoom(cafeteria);
        map.addRoom(cargoSpace);
        map.addRoom(cargoSpaceControl);
        map.addRoom(escapeModuleSector);
        map.addRoom(storage);
        map.addRoom(ventilation);

        // Set default room
        map.changeCurrentRoom(cabin);

        return map;
    }

}
