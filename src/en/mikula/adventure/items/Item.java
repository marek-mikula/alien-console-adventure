package en.mikula.adventure.items;

import java.util.Objects;

/**
 * Common abstract class for all items
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public abstract class Item {

    /**
     * Gets the name of the item used for
     * item list etc.
     *
     * @return string name of an item
     */
    public abstract String getName();

    /**
     * Gets the code enum of an item
     *
     * @return item code enum
     */
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
        return room.getCode().equals(this.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCode().getNumber());
    }

}
