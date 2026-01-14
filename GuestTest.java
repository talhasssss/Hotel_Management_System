public class GuestTest {
    public static void main(String[] args) {
        // 1. Arrange (Data set karna)
        String expectedName = "Talha";
        String expectedAddress = "talha@example.com";

        // 2. Act (Object create karna)
        Guest guest = new Guest(expectedName, expectedAddress);

        // Actual values nikalna
        String actualName = guest.getName();
        String actualAddress = guest.getAddressDetails();

        // 3. Assert (Check karna)
        System.out.println("--- Running Guest Class Test ---");
        
        boolean isNameCorrect = expectedName.equals(actualName);
        boolean isAddressCorrect = expectedAddress.equals(actualAddress);

        if (isNameCorrect && isAddressCorrect) {
            System.out.println("✅ Status: PASSED");
            System.out.println("Details: Guest name and address match perfectly.");
        } else {
            System.out.println("❌ Status: FAILED");
            // Galti dikhane ke liye
            if (!isNameCorrect) {
                System.out.println("   - Name Mismatch: Expected '" + expectedName + "' but got '" + actualName + "'");
            }
            if (!isAddressCorrect) {
                System.out.println("   - Address Mismatch: Expected '" + expectedAddress + "' but got '" + actualAddress + "'");
            }
        }
    }
}