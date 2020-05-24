package pl.edu.agh.database;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.Order;
import pl.edu.agh.internetshop.Product;
import pl.edu.agh.internetshop.User;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CompositeSearchStrategyTest {

    private static String surname = "Janosz";
    private static BigDecimal price = BigDecimal.valueOf(1250.99);

    private Order getOrder() {
        Product product1 = mock(Product.class);
        User user = mock(User.class);
        given(user.getSurname()).willReturn(surname);
        Order order = mock(Order.class);
        given(order.getPurchaser()).willReturn(user);
        given(order.getDiscountPrice()).willReturn(price);
        return order;
    }

    @Test
    public void testSearchingOrderWithExistingProductName() {
        // given
        SearchStrategy searchStrategy = new CompositeSearchStrategy(new PriceSearchStrategy(price),
                new PurchaserSurnameSearchStrategy(surname));

        // when then
        assertTrue(searchStrategy.filter(getOrder()));
    }

    @Test
    public void testSearchingOrderWithNonExistingProductName() {
        // given
        SearchStrategy searchStrategy = new CompositeSearchStrategy(new PriceSearchStrategy(BigDecimal.ONE),
                new PurchaserSurnameSearchStrategy(surname));

        // when then
        assertFalse(searchStrategy.filter(getOrder()));
    }
}