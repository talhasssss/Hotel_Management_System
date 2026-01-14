import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hotel {
    // Renamed fields for a different look
    private final String hotelTitle;
    private final List<Room> allRooms = new ArrayList<>();
    private final List<Reservation> bookingList;

    // Alternative Constructor implementation
    public Hotel(String hotelTitle) {
        // Validation using a different style (Objects.requireNonNull-like check)
        if (hotelTitle == null || hotelTitle.isBlank()) {
            throw new IllegalArgumentException("A valid hotel title is required.");
        }
        
        this.hotelTitle = hotelTitle;
        // Using a different List implementation for the bookings
        this.bookingList = new LinkedList<>(); 
    }

    /**
     * Checks if the hotel is currently capable of taking guests.
     * Renamed from available() to hasCapacity()
     */
    public boolean hasCapacity() {
        // More explicit logic than !rooms.isEmpty()
        return allRooms.size() > 0;
    }

    /**
     * Logic remains same, but implementation and messaging changed.
     */
    public void registerBooking(Reservation newBooking) {
        if (newBooking == null) {
            throw new IllegalArgumentException("Cannot process a null reservation object.");
        }
        
        this.bookingList.add(newBooking);
        System.out.printf("Successfully registered booking at %s.%n", hotelTitle);
    }

    public void includeNewRoom(Room r) {
        if (r != null) {
            this.allRooms.add(r);
        }
    }

    public String getHotelTitle() {
        return hotelTitle;
    }
}