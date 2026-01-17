import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTypeTest {

    @Test
    public void testRoomTypeCreation_ShouldSetCorrectValues() {
        // 1. Arrange (Setup karein)
        String expectedKind = "Deluxe";
        double expectedCost = 25000.0;

        // 2. Act (Method ko chalaein)
        RoomType room = new RoomType(expectedKind, expectedCost);

        // 3. Assert (Result check karein)
        assertEquals(expectedKind, room.getKind());
        assertEquals(expectedCost, room.getCost(), 0.001); // Double ke liye delta zaroori hai
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoomTypeCreation_NegativeCost_ShouldThrowException() {
        // 1. Arrange
        String kind = "Standard";
        double negativeCost = -100.0;

        // 2. Act
        // Is line par exception aani chahiye
        new RoomType(kind, negativeCost);

        // 3. Assert
        // Assert yahan @Test(expected...) handle kar raha hai
    }
}