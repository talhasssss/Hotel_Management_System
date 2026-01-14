import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class HotelTest {

    @Test
    public void validateHotelInitialization() {
        
        String brandName = "Regent Plaza";

        
        Hotel property = new Hotel(brandName);

       
        assertEquals("The hotel name was not stored correctly.", brandName, property.getHotelTitle());
        
        assertFalse("Property should report no capacity upon initial creation", property.hasCapacity());
    }

    @Test
    public void capacityReturnsTrueWhenRoomIsLinked() {
        
        Hotel property = new Hotel("Avari Towers");
        RoomType luxuryType = new RoomType("Standard", 12000.0);
        Room testRoom = new Room(505, luxuryType);

        
        property.includeNewRoom(testRoom);

       
        assertTrue("Capacity check failed after room addition", property.hasCapacity());
    }

    @Test
    public void bookingRegistryProcessesValidReservation() {
        
        Hotel property = new Hotel("Shelton Resident");
        RoomType suiteType = new RoomType("Presidential Suite", 50000.0);
        Reservation booking = Reservation.create(new Date(), new Date(), suiteType, 1);

        
        property.registerBooking(booking);

       
        assertNotNull("The property instance should not be null after booking", property);
    }

    
    @Test(expected = IllegalArgumentException.class)
    public void rejectEmptyHotelNameInConstructor() {
        
        new Hotel("   "); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectNullBookingSubmission() {
        
        Hotel property = new Hotel("Beach Luxury");

        property.registerBooking(null); 
    }
}