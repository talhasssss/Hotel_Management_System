import java.util.Date;

public class IntegrationTest {
    public static void main(String[] args) {
        try {
            Hotel myResort = new Hotel("Ocean View Residency");
            
            RoomType luxuryCategory = new RoomType("Super Deluxe", 45000.0);
            
            Room premiumRoom = new Room(909, luxuryCategory);
            myResort.addRoom(premiumRoom);

            ReserverPayer customer = ReserverPayer.create("ID-882", "1111-2222-3333-4444");
            
            long currentTime = System.currentTimeMillis();
            Date checkIn = new Date(currentTime);
            Date checkOut = new Date(currentTime + (7L * 24 * 60 * 60 * 1000));

            Reservation bookingEntry = Reservation.create(checkIn, checkOut, luxuryCategory, 1);
            bookingEntry.addRoom(premiumRoom);
            
            myResort.createReservation(bookingEntry);
            customer.makeReservation(bookingEntry);

            boolean hasRooms = myResort.available();
            boolean checkBookingMatch = (customer.getReservation() == bookingEntry);

            System.out.println("--- System Validation Results ---");
            if (hasRooms && checkBookingMatch) {
                System.out.println("Status: SUCCESS - System components are synchronized.");
                System.out.println("Property: " + myResort.getName());
                System.out.println("Allocated: " + premiumRoom.toString() + " [" + luxuryCategory.getKind() + "]");
                System.out.println("Client Reference: " + customer.getId());
            } else {
                System.out.println("Status: CRITICAL FAILURE - Data mismatch detected.");
            }

        } catch (Exception err) {
            System.err.println("Execution Error: " + err.getLocalizedMessage());
            err.printStackTrace();
        }
    }
}