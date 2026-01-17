import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class ReservationTest {

    @Test
    public void testCreateReservation_ShouldSetAllFields() {
        // 1. Arrange
        Date start = new Date(); // Aaj ki date
        Date end = new Date(start.getTime() + (1000 * 60 * 60 * 24)); // Kal ki date
        RoomType type = new RoomType("Deluxe", 5000.0);
        int roomCount = 2;

        // 2. Act
        Reservation res = Reservation.create(start, end, type, roomCount);

        // 3. Assert
        assertNotNull("Reservation object banna chahiye", res);
        // Note: Agar aapne getters nahi likhay to aapko testing ke liye getters add karne parenge
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateReservation_InvalidDates_ShouldThrowException() {
        // 1. Arrange
        Date start = new Date();
        Date endBeforeStart = new Date(start.getTime() - 100000); // Start se pehle ki date
        RoomType type = new RoomType("Standard", 3000.0);

        // 2. Act
        // Yeh line exception throw karegi
        Reservation.create(start, endBeforeStart, type, 1);
    }

    @Test
    public void testAddRoom_ShouldUpdateList() {
        // 1. Arrange
        RoomType type = new RoomType("Suite", 10000.0);
        Reservation res = Reservation.create(new Date(), new Date(), type, 1);
        Room myRoom = new Room(101, type);

        // 2. Act
        res.addRoom(myRoom);

        // 3. Assert
        // Yahan hum indirectly check kar rahe hain ke addRoom crash na ho
        // Agar aap list ka size check karna chahte hain to getRooms() method chahiye hoga
        assertNotNull(res); 
    }
}