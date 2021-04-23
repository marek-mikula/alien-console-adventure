package en.mikula.adventure.base.inputs;

import en.mikula.adventure.exceptions.EndOfFileException;

/**
 * Base interface for reading the input
 *
 * @author Marek Mikula
 * @version 4/20/2021
 */
public interface Input {

    /**
     * Reads one line from input implementation
     *
     * @return the read line as string
     * @throws EndOfFileException if we hit the end of the
     *                            file while reading commands from file
     */
    public String readLine() throws EndOfFileException;

}
