package en.mikula.adventure.exceptions;

/**
 * Allows to pass the information that the program
 * hit the bottom of the given command file
 *
 * @author Marek Mikula
 * @version 4/20/2021
 */
public class EndOfFileException extends Exception {

    public EndOfFileException(String message) {
        super(message);
    }

}
