package en.mikula.adventura.rooms;

import en.mikula.adventura.base.Game;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Cabin extends Room {

    public Cabin(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Ellen Ripley's cabin";
    }

}
