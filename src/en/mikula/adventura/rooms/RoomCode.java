package en.mikula.adventura.rooms;

/**
 * Room codes enum
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public enum RoomCode {
    ROOM_0(0), // Ellen Ripley's cabin
    ROOM_1(1), // Bridge
    ROOM_2(2), // Cafeteria
    ROOM_3(3), // Cargo space control room
    ROOM_4(4), // Cargo space
    ROOM_5(5), // Storage
    ROOM_6(6), // Escape module sector
    ROOM_7(7); // Ventilation

    private final int number;

    private RoomCode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
