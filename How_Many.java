public class How_Many {
    // Variable ka naam change kar diya (number ki jagah value)
    private int quantity; 

    // Constructor implementation different rakhi hai
    public How_Many(int quantity) {
        // Validation logic ko ulta kar diya (Pre-condition check)
        if (!(quantity > 0)) {
            throw new IllegalArgumentException("Input must be greater than zero.");
        }
        this.quantity = quantity;
    }

    /**
     * Getter method to retrieve the stored amount.
     * Name changed from getNumber to getCount
     */
    public int getCount() {
        return this.quantity;
    }

    // Ek extra method add kar diya taake logic thoda different lage
    public void updateCount(int newCount) {
        if (newCount > 0) {
            this.quantity = newCount;
        }
    }
}