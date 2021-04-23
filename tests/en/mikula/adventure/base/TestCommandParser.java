package en.mikula.adventure.base;

import en.mikula.adventure.exceptions.EndOfFileException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.fail;

/**
 * @author Marek Mikula
 * @version 4/24/2021
 */
public class TestCommandParser {

    private CommandParser commandParser;

    @Before
    public void setup() throws FileNotFoundException {
        Game game = new Game(new String[]{});
        commandParser = new CommandParser(game);
    }

    @Test
    public void tryParseCommand() {
        // First try valid command
        try {
            commandParser.parseCommand("go 1");
        } catch (EndOfFileException | RuntimeException exception) {
            fail();
        }

        // Now try invalid command
        try {
            commandParser.parseCommand("invalid command");
        } catch (EndOfFileException | RuntimeException exception) {
            return;
        }

        fail();
    }

}
