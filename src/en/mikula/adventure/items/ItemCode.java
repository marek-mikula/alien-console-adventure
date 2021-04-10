package en.mikula.adventure.items;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public enum ItemCode {
    ITEM_0(0), // Ellen Ripley's diary
    ITEM_1(1), // Bridge terminal
    ITEM_2(2), // Commander's body
    ITEM_3(3), // Cargo space terminal
    ITEM_4(4), // Screwdriver
    ITEM_5(5), // Escape module terminal
    ITEM_6(6), // Escape module
    ITEM_7(7), // Cargo space card
    ITEM_8(8); // Cargo space terminal

    private final int number;

    private ItemCode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
