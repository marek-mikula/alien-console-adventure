package en.mikula.adventure.items.terminals;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.items.Diary;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.rooms.RoomCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class CargoSpaceTerminal extends Terminal {

    private final int OPTION_0 = 0;
    private final int OPTION_1 = 1;

    public CargoSpaceTerminal(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Cargo space terminal";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_8;
    }

    @Override
    protected Map<Integer, String> getOptions() {
        Map<Integer, String> options = new HashMap<>();

        options.put(OPTION_0, "Enter code to storage room");
        options.put(OPTION_1, "Close terminal");

        return options;
    }

    @Override
    protected void handleInteraction(int optionCode) {
        switch (optionCode) {
            case OPTION_0:
                if (this.readLine().equals(Diary.STORAGE_CODE)) {
                    System.out.println("Password was correct! The door to storage room has opened!");
                    (game.getMap().getRoom(RoomCode.ROOM_4).getNext(RoomCode.ROOM_5.getNumber())).setIsLocked(false);
                } else {
                    System.out.println("The password is incorrect.");
                }
                break;
            case OPTION_1:
                active = false;
                break;
            default:
                this.undefinedOptionSelected();
        }
    }
}
