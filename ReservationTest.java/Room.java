

public class Room  {
    private int number;
    private RoomType type;   // Relationship: 1 Room has 1 RoomType
    public Room(int number, RoomType type) {
        // Defensive Programming [cite: 25, 28]
        if (number <= 0) throw new IllegalArgumentException("Invalid room number");
        if (type == null) throw new NullPointerException("RoomType cannot be null");
        this.number = number;
        this.type = type;
    }
    // UML Operation: createGuest()
    public void createGuest(String name, String address) {
        // Guest creation logic here
        System.out.println("Guest " + name + " created for room " + number);
    }
}