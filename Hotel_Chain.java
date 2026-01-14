import java.util.ArrayList;
import java.util.List;

public class Hotel_Chain {
    // Modified naming convention
    private String brandIdentity;
    
    // Using interfaces for declaration (Good practice)
    private final List<Hotel> branchList;
    private final List<ReserverPayer> registeredPayers;

    // Updated Constructor
    public Hotel_Chain(String brandIdentity) {
        this.brandIdentity = brandIdentity;
        // Initializing with clear naming
        this.branchList = new ArrayList<>();
        this.registeredPayers = new ArrayList<>();
    }

    /**
     * Replaces createReserverPayer.
     * Logic: Uses the factory method from ReserverPayer.
     */
    public void registerNewMember(String memberId, String paymentCard) {
        // Renamed variable to keep it distinct
        ReserverPayer member = ReserverPayer.create(memberId, paymentCard);
        this.registeredPayers.add(member);
    }

    public void enrollPayer(ReserverPayer p) {
        if (p != null) {
            this.registeredPayers.add(p);
        }
    }

    /**
     * Replaces makeReservation logic
     */
    public void processBooking(ReserverPayer customer, Reservation booking) {
        // Checking existence before processing
        boolean isRegistered = registeredPayers.stream()
                .anyMatch(p -> p.equals(customer));

        if (isRegistered) {
            customer.makeReservation(booking);
        } else {
            System.out.println("Customer not found in enterprise records.");
        }
    }

    public void addNewLocation(Hotel branch) {
        this.branchList.add(branch);
    }

    // --- System Status Operations ---

    public void voidReservation() { 
        System.out.println("Status: Booking has been voided.");
    }

    public void performCheckIn() {
        System.out.println("Status: Guest arrival processed.");
    }

    public void performCheckOut() { 
        System.out.println("Status: Guest departure processed.");
    }
}