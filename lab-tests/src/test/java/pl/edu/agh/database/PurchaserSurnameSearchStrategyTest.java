package pl.edu.agh.database;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.Order;
import pl.edu.agh.internetshop.Product;
import pl.edu.agh.internetshop.User;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PurchaserSurnameSearchStrategyTest {

    private static String surname = "Janosz";

    private Order getOrderWithProducts() {
        Product product1 = mock(Product.class);
        User user = mock(User.class);
        given(user.getSurname()).willReturn(surname);
        Order order = mock(Order.class);
        given(order.getPurchaser()).willReturn(user);
        return order;
    }

    @Test
    public void testSearchingOrderWithExistingProductName() {
        // given
        SearchStrategy searchStrategy = new PurchaserSurnameSearchStrategy(surname);

        // when then
        assertTrue(searchStrategy.filter(getOrderWithProducts()));
    }

    @Test
    public void testSearchingOrderWithNonExistingProductName() {
        // given
        SearchStrategy searchStrategy = new PurchaserSurnameSearchStrategy("Kowalski");

        // when then
        assertFalse(searchStrategy.filter(getOrderWithProducts()));
    }
}