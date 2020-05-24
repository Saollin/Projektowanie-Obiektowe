package pl.edu.agh.database;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.Order;
import pl.edu.agh.internetshop.Product;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PriceSearchStrategyTest {
    private static BigDecimal price = BigDecimal.valueOf(1250.99);

    private Order getOrderWithProducts() {
        Order order = mock(Order.class);
        given(order.getDiscountPrice()).willReturn(price);
        return order;
    }

    @Test
    public void testSearchingOrderWithExistingPrice() {
        // given
        SearchStrategy searchStrategy = new PriceSearchStrategy(price);

        // when then
        assertTrue(searchStrategy.filter(getOrderWithProducts()));
    }

    @Test
    public void testSearchingOrderWithNonExistingPrice() {
        // given
        SearchStrategy searchStrategy = new PriceSearchStrategy(BigDecimal.ONE);

        // when then
        assertFalse(searchStrategy.filter(getOrderWithProducts()));
    }
}