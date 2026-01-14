import static org.junit.Assert.*;
import org.junit.Test;

public class How_ManyTest {

    @Test
    public void verifyObjectInitializationWithPositiveValue() {
        
        int initialAmount = 10;

        // Object creation
        How_Many counter = new How_Many(initialAmount);

  
        assertEquals("The stored count should match the input value", 
                     initialAmount, counter.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectZeroAsInput() {
       
        new How_Many(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectNegativeValues() {
        // Different negative value
        int invalidEntry = -50;

        // Action
        new How_Many(invalidEntry);
    }
}