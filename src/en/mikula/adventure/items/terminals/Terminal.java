package en.mikula.adventure.items.terminals;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.base.inputs.Input;
import en.mikula.adventure.items.Interactive;
import en.mikula.adventure.items.Item;
import en.mikula.adventure.text.AsciArt;

import java.util.List;

/**
 * Abstract class for all terminals so they
 * all share common functionality which is
 * showing options, reading user input and so on
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public abstract class Terminal extends Item implements Interactive {

    protected final Game game;

    /**
     * Specifies if the terminal is being used
     */
    protected boolean active = false;

    public Terminal(Game game) {
        this.game = game;
    }

    @Override
    public String interact() {
        active = true;

        // Show terminal starting screen
        this.startTerminal();

        while (active) {
            // List all options to player before every input
            this.listOptions();

            String line = this.game.getInput().readLine();

            if (line.isEmpty()) {
                System.out.println("You did not enter any option.");
                continue;
            }

            String[] options = line.split("[ \t]+");

            try {
                this.handleInteraction(Integer.parseInt(options[0]));
            } catch (NumberFormatException exception) {
                System.out.println("You entered an invalid option. Try again.");
            }
        }

        // Return closing text
        return "You closed the terminal.";
    }

    /**
     * Prints the invalid options message
     */
    protected void undefinedOptionSelected() {
        System.out.println("There is no such option.");
    }

    /**
     * Shows the start screen of the terminal
     */
    private void startTerminal() {
        System.out.println(AsciArt.companyLogoTerminalArt());
    }

    /**
     * Lists options of the terminal
     */
    private void listOptions() {
        System.out.println("What do you wanna do?");

        List<String> options = this.getOptions();

        for (int i = 0; i < options.size(); i++) {
            System.out.println("[" + i + "] " + options.get(i));
        }
    }

    /**
     * Gets the options for terminal where index is option
     * number and value is the label
     *
     * @return array of terminal options
     */
    protected abstract List<String> getOptions();

    /**
     * Handles the specific terminal option
     *
     * @param optionCode option code which user selected
     */
    protected abstract void handleInteraction(int optionCode);

}
