

public class ReserverPayer {
   // UML Attributes
    private String id;
    private String creditCardDetails;
    
    // Relationship: ReserverPayer has a Reservation (1 to 0..1)
    private Reservation reservation;

    // Private constructor as per 'create()' logic
    public ReserverPayer(String id, String creditCardDetails) {
        this.id = id;
        this.creditCardDetails = creditCardDetails;
    }

    // UML Operation: create()
    public static ReserverPayer create(String id, String creditCardDetails) {
        if (id == null || creditCardDetails == null) {
            throw new IllegalArgumentException("ID and Card details are required");
        }
        return new ReserverPayer(id, creditCardDetails);
    }
    public String getId() {
        return id;
    }
    public String getCreditCardDetails() {
        return creditCardDetails;
    }

    // Relation with Reservation and Guest
    // Payer reservation karta hai aur batata hai ke 'Guest' kon hoga
    public void makeReservation(Reservation res) {
        this.reservation = res;
        System.out.println("Payer " + id + " made a reservation.");
    }

    public Reservation getReservation() {
        return reservation;
    }
}
