package en.mikula.adventure.items.terminals;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.exceptions.EndOfFileException;
import en.mikula.adventure.items.Interactive;
import en.mikula.adventure.items.Item;
import en.mikula.adventure.text.AsciArt;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class for all terminals so they
 * all share common functionality which is
 * showing options, reading user input and so on
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public abstract class Terminal extends Item implements Interactive {

    private final Map<Integer, TerminalOption> optionMap = new HashMap<>();

    protected final Game game;

    /**
     * Specifies if the terminal is being used
     */
    protected boolean active = false;

    public Terminal(Game game) {
        this.game = game;

        // Put close option by default into map
        TerminalOption defaultCloseOption = new CloseTerminalOption(this);
        optionMap.put(defaultCloseOption.getNumber(), defaultCloseOption);
    }

    @Override
    public String interact() throws EndOfFileException {
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
                TerminalOption option = optionMap.get(Integer.parseInt(options[0]));

                // Don't let user select non existing option
                if (option == null || !option.shouldList()) {
                    System.out.println("There is no such option.");
                    continue;
                }

                option.handle();
            } catch (NumberFormatException exception) {
                System.out.println("You entered an invalid option. Try again.");
            }
        }

        // Return closing text
        return "You closed the terminal.";
    }

    /**
     * Adds one option to the map
     *
     * @param option to be added
     */
    public void addOption(TerminalOption option) {
        optionMap.put(option.getNumber(), option);
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

        optionMap.forEach((key, value) -> {
            if (!value.shouldList()) {
                return;
            }
            System.out.println("[" + value.getNumber() + "] " + value.getText());
        });
    }

    /**
     * Sets the terminal active state to false,
     * therefore if turns off the terminal
     */
    protected void turnOffTerminal() {
        active = false;
    }

}
