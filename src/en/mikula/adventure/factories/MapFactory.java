package en.mikula.adventure.factories;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.base.Map;
import en.mikula.adventure.items.*;
import en.mikula.adventure.items.terminals.BridgeTerminal;
import en.mikula.adventure.items.terminals.CargoSpaceControlTerminal;
import en.mikula.adventure.items.terminals.CargoSpaceTerminal;
import en.mikula.adventure.items.terminals.EscapeModuleSectorTerminal;
import en.mikula.adventure.rooms.*;
import en.mikula.adventure.rooms.guards.CargoSpaceAlienGuard;
import en.mikula.adventure.rooms.guards.CargoSpacePlatformOpenedGuard;

/**
 * Factory used to build the map
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class MapFactory {

    /**
     * Builds the rooms filled with guards, items
     * and their connections
     *
     * Sets the default room to cabin
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
        cargoSpace.addGuard(new CargoSpacePlatformOpenedGuard(game));

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
        bridge.addConnection(new RoomConnection(cafeteria));
        bridge.addConnection(new RoomConnection(cargoSpace).setIsLocked(true));

        escapeModuleSector.addConnection(new RoomConnection(ventilation));
        escapeModuleSector.addConnection(new RoomConnection(cafeteria).setIsBlocked(true));

        cafeteria.addConnection(new RoomConnection(bridge));
        cafeteria.addConnection(new RoomConnection(cargoSpaceControl));
        cafeteria.addConnection(new RoomConnection(escapeModuleSector).setIsBlocked(true));

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
