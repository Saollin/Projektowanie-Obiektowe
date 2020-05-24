package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;

class OrdersDatabaseTest {

    private Order getOrderWithMockProduct() {
        Product product = mock(Product.class);
        User user = mock(User.class);
        return new Order(Collections.singletonList(product), user);
    }

    @Test
    void testIsOrderInDatabaseAfterCreating() {
        // given
        Order expected = getOrderWithMockProduct();

        // when
        Order actual = OrdersDatabase.getOrder(expected.getId());

        // then
        assertEquals(expected, actual);
    }

    @Test
    void testIsOrderStillAfterItsChange() {
        // given
        Order order = getOrderWithMockProduct();
        PaymentMethod paymentMethod = mock(PaymentMethod.class);
        MoneyTransfer moneyTransfer = mock(MoneyTransfer.class);

        // when
        order.setPaymentMethod(paymentMethod);
        order.pay(moneyTransfer);

        // then
        assertEquals(order, OrdersDatabase.getOrder(order.getId()));
    }
}