package en.mikula.adventure.items.terminals.escapeModuleSector;

import en.mikula.adventure.base.Game;
import en.mikula.adventure.items.EscapeModule;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.items.terminals.TerminalOption;
import en.mikula.adventure.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 17/5/21
 */
public class GetEscapeModuleReadyOption implements TerminalOption {

    private final Game game;

    public GetEscapeModuleReadyOption(Game game) {
        this.game = game;
    }

    @Override
    public int getNumber() {
        return 1;
    }

    @Override
    public String getText() {
        return "Get the escape module ready";
    }

    @Override
    public void handle() {
        ((EscapeModule) game.getMap().getRoom(RoomCode.ROOM_7).getItem(ItemCode.ITEM_6.getNumber())).setIsModuleReady(true);
    }

    @Override
    public Boolean shouldList() {
        return !((EscapeModule) game.getMap().getRoom(RoomCode.ROOM_7).getItem(ItemCode.ITEM_6.getNumber())).isModuleReady();
    }
}
