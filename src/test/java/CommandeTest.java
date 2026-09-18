import org.junit.jupiter.api.Test;

import static javax.swing.text.StyleConstants.Size;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

public class CommandeTest {

    @Test
    public void testGetTotalAmount() {
        // Arrange
        Customer customer = new Customer(
                "Doe", "John", LocalDate.of(1995, 5, 20),
                "12 rue de Paris", "john.doe@email.com", "0601020304"
        );

        Order order = new Order(LocalDate.now(), "Birthday order", customer);

        Top tShirt = new Top("T-Shirt", Size.M, 15.0, Material.COTTON, Sleeves.SHORT);
        Bottom jeans = new Bottom("Jeans", Size.L, 40.0, Material.OTHER, 32);

        order.addClothing(tShirt, 2); // 2 x 15.0
        order.addClothing(jeans, 1);  // 1 x 40.0

        double expectedTotal = (15.0 * 2) + (40.0 * 1); // = 70.0

        // Act
        double actualTotal = order.getTotalAmount();

        // Assert
        assertEquals(expectedTotal, actualTotal, 0.001);
    }
}
