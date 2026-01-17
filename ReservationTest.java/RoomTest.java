import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTest {

    @Test
    public void testRoomCreation_ShouldSetNumberAndType() {
        // 1. Arrange
        int expectedNumber = 101;
        RoomType expectedType = new RoomType("Deluxe", 5000.0);

        // 2. Act
        Room room = new Room(expectedNumber, expectedType);

        // 3. Assert
        assertNotNull("Room object null nahi hona chahiye", room);
        // Note: Agar aapne getters banaye hain to yahan values check kar sakte hain
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoomCreation_InvalidNumber_ShouldThrowException() {
        // 1. Arrange
        int invalidNumber = 0;
        RoomType type = new RoomType("Standard", 3000.0);

        // 2. Act
        new Room(invalidNumber, type);
    }

    @Test(expected = NullPointerException.class)
    public void testRoomCreation_NullType_ShouldThrowException() {
        // 1. Arrange
        int number = 102;

        // 2. Act
        new Room(number, null);
    }

    @Test
    public void testCreateGuest_ShouldExecuteSuccessfully() {
        // 1. Arrange
        RoomType type = new RoomType("Suite", 10000.0);
        Room room = new Room(201, type);
        String guestName = "Zeeshan";
        String guestAddress = "Karachi, Pakistan";

        // 2. Act & Assert
        // Chunke createGuest void hai aur sirf print kar raha hai, 
        // hum check kar rahe hain ke ye crash na ho.
        room.createGuest(guestName, guestAddress);
    }
}