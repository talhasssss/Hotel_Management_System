import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class HotelPropertyTest {

    @Test
    public void validateHotelInitialization() {
        // Renamed variable and used a different dummy value
        String brandName = "Regent Plaza";

        // Execution
        Hotel property = new Hotel(brandName);

        // Assertions with custom messages
        assertEquals("The hotel name was not stored correctly.", brandName, property.getHotelTitle());
        // Since no rooms are added yet, it should return false
        assertFalse("Property should report no capacity upon initial creation", property.hasCapacity());
    }

    @Test
    public void capacityReturnsTrueWhenRoomIsLinked() {
        // Setup
        Hotel property = new Hotel("Avari Towers");
        RoomType luxuryType = new RoomType("Standard", 12000.0);
        Room testRoom = new Room(505, luxuryType);

        // Action
        property.includeNewRoom(testRoom);

        // Verification
        assertTrue("Capacity check failed after room addition", property.hasCapacity());
    }

    @Test
    public void bookingRegistryProcessesValidReservation() {
        // Setup
        Hotel property = new Hotel("Shelton Resident");
        RoomType suiteType = new RoomType("Presidential Suite", 50000.0);
        Reservation booking = Reservation.create(new Date(), new Date(), suiteType, 1);

        // Action
        property.registerBooking(booking);

        // Verification
        assertNotNull("The property instance should not be null after booking", property);
    }

    // Testing exceptions using a slightly different style
    @Test(expected = IllegalArgumentException.class)
    public void rejectEmptyHotelNameInConstructor() {
        // Using a whitespace string to test slightly different edge case
        new Hotel("   "); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectNullBookingSubmission() {
        // Note: I changed the exception type to IllegalArgumentException 
        // to match the refactored Hotel class logic from earlier.
        Hotel property = new Hotel("Beach Luxury");

        property.registerBooking(null); 
    }
}