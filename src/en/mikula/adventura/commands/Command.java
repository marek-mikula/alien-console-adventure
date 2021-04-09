package en.mikula.adventura.commands;

/**
 * @author Marek Mikula
 * @version 4/6/2021
 */
public interface Command {

    /**
     * Gets the command signature
     *
     * @return String
     */
    public String signature();

    /**
     * Gets the help message for command
     *
     * @return help message
     */
    public String help();

    /**
     * Method which handles the current command
     *
     * @param args array of params which user entered
     * @return output of the command
     */
    public String run(String... args);

}
