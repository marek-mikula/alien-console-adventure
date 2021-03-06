package en.mikula.adventure.items.terminals.cargoSpace;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.items.Diary;
import en.mikula.adventure.items.terminals.TerminalOption;
import en.mikula.adventure.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 17/5/21
 */
public class EnterCodeToStorageRoomOption implements TerminalOption {

    private final Game game;

    public EnterCodeToStorageRoomOption(Game game) {
        this.game = game;
    }

    public int getNumber() {
        return 1;
    }

    public String getText() {
        return "Enter password to storage room";
    }

    public void handle() {
        System.out.print("The password: ");

        String line = game.getInput().readLine();
        if (line != null && line.equals(Diary.STORAGE_CODE)) {
            System.out.println("Password was correct! The door to storage room has opened!");
            (game.getMap().getRoom(RoomCode.ROOM_4).getNext(RoomCode.ROOM_5.getNumber())).setIsLocked(false);
        } else {
            System.out.println("The password is incorrect.");
        }
    }

    @Override
    public Boolean shouldList() {
        return (game.getMap().getRoom(RoomCode.ROOM_4).getNext(RoomCode.ROOM_5.getNumber())).isLocked();
    }
}
