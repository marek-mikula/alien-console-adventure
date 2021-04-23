package en.mikula.adventure.rooms.guards;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.rooms.Cabin;
import en.mikula.adventure.rooms.CargoSpace;
import en.mikula.adventure.rooms.Room;
import en.mikula.adventure.rooms.RoomCode;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Marek Mikula
 * @version 4/23/2021
 */
public class RoomGuardTest {

    private Game game;

    @Before
    public void setup() throws FileNotFoundException {
        game = new Game(new String[]{});
    }

    @Test
    public void testPassed() {
        CargoSpace cargoSpace = (CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4);

        RoomGuard guard = new CargoSpaceAlienGuard(game);

        assertTrue(cargoSpace.addGuard(guard));
        assertFalse(guard.passed());

        cargoSpace.setIsAlienHere(false);

        assertTrue(guard.passed());
    }

}
