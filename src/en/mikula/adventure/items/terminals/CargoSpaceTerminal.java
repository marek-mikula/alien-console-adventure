package en.mikula.adventure.items.terminals;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.items.Diary;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.rooms.RoomCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class CargoSpaceTerminal extends Terminal {

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
    protected List<String> getOptions() {
        List<String> options = new ArrayList<>();

        options.add("Enter code to storage room");
        options.add("Close terminal");

        return options;
    }

    @Override
    protected void handleInteraction(int optionCode) {
        switch (optionCode) {
            case 0: // code input
                String line = game.getInput().readLine();
                if (line != null && line.equals(Diary.STORAGE_CODE)) {
                    System.out.println("Password was correct! The door to storage room has opened!");
                    (game.getMap().getRoom(RoomCode.ROOM_4).getNext(RoomCode.ROOM_5.getNumber())).setIsLocked(false);
                } else {
                    System.out.println("The password is incorrect.");
                }
                break;
            case 1: // close console
                active = false;
                break;
            default:
                this.undefinedOptionSelected();
        }
    }
}
