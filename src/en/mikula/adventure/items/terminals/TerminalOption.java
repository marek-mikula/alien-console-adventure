package en.mikula.adventure.items.terminals;

import en.mikula.adventure.exceptions.EndOfFileException;

/**
 * Base interface for terminal options
 *
 * @author Marek Mikula
 * @version 17/5/2021
 */
public interface TerminalOption {

    /**
     * Gets the number of the option
     *
     * @return option number as integer
     */
    public int getNumber();

    /**
     * Gets the option text that is displayed
     * next to the number when options are listed
     * to user
     *
     * @return option label as string
     */
    public String getText();

    /**
     * Handles the operation when the option
     * is selected
     *
     * @throws EndOfFileException can be thrown
     *                            if we read the commands from file
     */
    public void handle() throws EndOfFileException;

    /**
     * Returns boolean if the option should be listed
     * in the option list
     * Gives possibility to hide/show options by some
     * state
     *
     * @return the state
     */
    default Boolean shouldList() {
        return true;
    }

}
