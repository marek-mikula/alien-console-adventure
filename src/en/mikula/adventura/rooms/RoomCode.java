package en.mikula.adventura.rooms;

/**
 * Room codes enum
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public enum RoomCode {
    ROOM_0(0), ROOM_1(1), ROOM_2(2), ROOM_3(3), ROOM_4(4), ROOM_5(5), ROOM_6(6);

    private final int number;

    private RoomCode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
