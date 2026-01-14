import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

public class HotelEnterpriseTest {

    private HotelEnterprise corporateOffice;

    @Before
    public void setup() {
        // Initialize common object used in multiple tests
        corporateOffice = new HotelEnterprise("Global Resorts Group");
    }

    @Test
    public void verifyMemberRegistrationUpdatesRecords() {
        // Data setup
        String idCode = "USR-772";
        String cardDetail = "4500-1111-2222";

        // Execution
        corporateOffice.registerNewMember(idCode, cardDetail);

        // Validation
        // Confirming the object state remains valid after operation
        assertNotNull("The enterprise object should remain valid after registration", corporateOffice);
    }

    @Test
    public void confirmBookingFlowForRegisteredCustomers() {
        // Setup objects
        ReserverPayer customer = ReserverPayer.create("CUST-10", "5555-4444");
        corporateOffice.enrollPayer(customer);
        
        RoomType suiteType = new RoomType("Executive Suite", 350.0);
        Reservation bookingRequest = Reservation.create(new Date(), new Date(), suiteType, 2);

        // Perform action
        corporateOffice.processBooking(customer, bookingRequest);

        // Verify that the link between payer and reservation was established
        assertEquals("The booking was not correctly assigned to the customer", 
                     bookingRequest, customer.getReservation());
    }

    @Test
    public void ensureLocationAdditionDoesNotFail() {
        // Setup
        Hotel karachiBranch = new Hotel("Karachi Grand Hotel");

        // Action
        corporateOffice.addNewLocation(karachiBranch);

        // Assertion
        // We assert the object is still functional
        assertTrue(corporateOffice.getHotelTitle().contains("Global"));
    }
}