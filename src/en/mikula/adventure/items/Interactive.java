package en.mikula.adventure.items;

import en.mikula.adventure.exceptions.EndOfFileException;

/**
 * Common item interface which allows
 * player to interact with an item
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public interface Interactive {

    /**
     * Main method which specifies how the
     * interaction is being done with the
     * item
     *
     * @return string text to show to user
     * @throws EndOfFileException if we hit end of the file while
     *                            interacting with an item
     */
    public String interact() throws EndOfFileException;

}
