import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class ReserverPayerTest {

    @Test
    public void testCreateReserverPayer_ShouldSetCorrectDetails() {
        // 1. Arrange
        String expectedId = "P-101";
        String expectedCard = "1234-5678-9012";

        // 2. Act
        ReserverPayer payer = ReserverPayer.create(expectedId, expectedCard);

        // 3. Assert
        assertNotNull("Payer object null nahi hona chahiye", payer);
        assertEquals(expectedId, payer.getId());
        assertEquals(expectedCard, payer.getCreditCardDetails());
    }

    @Test
    public void testMakeReservation_ShouldLinkReservationToPayer() {
        // 1. Arrange
        ReserverPayer payer = ReserverPayer.create("P-101", "1234-5678");
        // Mocking/Creating a simple Reservation object (Assuming Reservation class exists)
        Reservation mockRes = new Reservation(new Date().getTime() + (1000 * 60 * 60 * 24)); 

        // 2. Act
        payer.makeReservation(mockRes);

        // 3. Assert
        assertNotNull("Reservation link honi chahiye", payer.getReservation());
        assertEquals(mockRes, payer.getReservation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_WithNullId_ShouldThrowException() {
        // 1. Arrange & 2. Act
        // Null ID ke saath create karne par exception aani chahiye
        ReserverPayer.create(null, "1234-5678");

        // 3. Assert handle by expected annotation
    }
}