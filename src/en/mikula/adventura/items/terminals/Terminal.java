package en.mikula.adventura.items.terminals;

import en.mikula.adventura.base.Game;
import en.mikula.adventura.items.Interactive;
import en.mikula.adventura.items.Item;
import en.mikula.adventura.text.AsciArt;

import java.util.Map;
import java.util.Scanner;

/**
 * Abstract class for all terminals so they
 * all share common functionality
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public abstract class Terminal extends Item implements Interactive {

    private final Scanner scanner;

    protected final Game game;

    /**
     * Specifies if the terminal is still being used
     */
    protected boolean active = false;

    public Terminal(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String interact() {
        active = true;
        this.startTerminal();

        while (active) {
            this.listOptions();

            String line = this.readLine();

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

        return this.closeTerminal();
    }

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
        for (Map.Entry<Integer, String> entry : this.getOptions().entrySet()) {
            Integer optionNumber = entry.getKey();
            String optionLabel = entry.getValue();

            System.out.println("[" + optionNumber + "] " + optionLabel);
        }
    }

    private String closeTerminal() {
        return "You closed the terminal.";
    }

    /**
     * Reads input from user using Scanner
     *
     * @return read string
     */
    protected String readLine() {
        System.out.print("> ");
        return scanner.nextLine();
    }

    /**
     * Gets the options for terminal where index is option
     * number and value is the label
     *
     * @return array of terminal options
     */
    protected abstract Map<Integer, String> getOptions();

    /**
     * Handles the specific terminal option
     *
     * @param optionCode option code which user selected
     */
    protected abstract void handleInteraction(int optionCode);

}
