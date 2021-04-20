package en.mikula.adventure.exceptions;

/**
 * @author Marek Mikula
 * @version 4/20/2021
 */
public class EndOfTheFileException extends RuntimeException {

    public EndOfTheFileException(String message) {
        super(message);
    }

}
