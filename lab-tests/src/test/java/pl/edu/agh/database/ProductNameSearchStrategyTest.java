package pl.edu.agh.database;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.Order;
import pl.edu.agh.internetshop.Product;
import pl.edu.agh.internetshop.User;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ProductNameSearchStrategyTest {

    private static String name1 = "Lampa";
    private static String name2 = "Komputer";

    private Order getOrderWithProducts() {
        Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);
        given(product1.getName()).willReturn(name1);
        given(product2.getName()).willReturn(name2);
        Order order = mock(Order.class);
        given(order.getProducts()).willReturn(Arrays.asList(product1, product2));
        return order;
    }

    @Test
    public void testSearchingOrderWithExistingProductName() {
        // given
        SearchStrategy searchStrategy = new ProductNameSearchStrategy(name2);

        // when then
        assertTrue(searchStrategy.filter(getOrderWithProducts()));
    }

    @Test
    public void testSearchingOrderWithNonExistingProductName() {
        // given
        SearchStrategy searchStrategy = new ProductNameSearchStrategy("Mysz");

        // when then
        assertFalse(searchStrategy.filter(getOrderWithProducts()));
    }
}