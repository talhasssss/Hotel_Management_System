


public class RoomType {

    private String kind;  // UML: RoomKind 
    private double cost;  // UML: Money 

    // Constructor: UML create() 
    public RoomType(String kind, double cost) {
        // Defensive Programming: Validation [cite: 25]
        if (cost < 0) throw new IllegalArgumentException("Cost cannot be negative"); 
        if (kind == null || kind.isEmpty()) throw new IllegalArgumentException("Kind is required");
        
        this.kind = kind;
        this.cost = cost;
    }

    public double getCost() { return cost; }
    public String getKind() { return kind; }
}
