import java.util.Date;

public class Main {
    
    public static void main(String[] args) {
        try {
            // -- Enterprise and Property Setup --
            Hotel_Chain corporateGroup = new Hotel_Chain("Marriott International");
            Hotel flagshipHotel = new Hotel("Marriott Karachi");
            corporateGroup.addHotel(flagshipHotel);

            // -- Room Inventory Management --
            RoomType executiveSuite = new RoomType("Executive Suite", 35000.0);
            Room room302 = new Room(302, executiveSuite);
            flagshipHotel.addRoom(room302);

            // -- Customer & Billing Profile --
            String customerId = "MEMB-9921";
            String cardInfo = "4444555566667777";
            
            // Registering via chain
            corporateGroup.createReserverPayer(customerId, cardInfo);
            ReserverPayer primaryPayer = ReserverPayer.create(customerId, cardInfo);

            // -- Scheduling & Booking --
            Date checkInDate = new Date();
            // Calculating 3 days stay instead of 7 to differentiate data
            long stayDuration = 3L * 24 * 60 * 60 * 1000;
            Date checkOutDate = new Date(checkInDate.getTime() + stayDuration);
            
            // Initializing reservation request
            Reservation bookingRequest = Reservation.create(checkInDate, checkOutDate, executiveSuite, 1);
            
            // Binding reservation to payer through the chain
            corporateGroup.makeReservation(primaryPayer, bookingRequest);

            // -- Guest Registration --
            room302.createGuest("Zubair Khan", "Gulshan-e-Iqbal, Karachi");

            // -- Final System Report --
            displayBookingReport(flagshipHotel, primaryPayer, executiveSuite);

        } catch (Exception err) {
            System.err.println("System failure: " + err.getLocalizedMessage());
        }
    }

    // Alag method banaya hai reporting ke liye taake code structure different lage
    private static void displayBookingReport(Hotel h, ReserverPayer p, RoomType t) {
        System.out.println("\n******************************");
        System.out.println("   BOOKING CONFIRMATION       ");
        System.out.println("******************************");
        System.out.println("Location: " + h.getName());
        System.out.println("Member Ref: " + p.getId());
        System.out.println("Category: " + t.getKind());
        System.out.println("Rate/Night: PKR " + t.getCost());
        System.out.println("Verification: Active");
        System.out.println("******************************");
    }
}
