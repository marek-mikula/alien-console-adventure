package en.mikula.adventura.items;

import java.util.Objects;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public abstract class Item {

    public abstract String getName();

    public abstract ItemCode getCode();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item room = (Item) o;
        return room.getCode().getNumber() == this.getCode().getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCode().getNumber());
    }

}
