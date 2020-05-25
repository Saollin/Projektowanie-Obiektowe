package pl.edu.agh.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pl.edu.agh.database.OrdersDatabase;
import pl.edu.agh.internetshop.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

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

    private static String prodName1 = "Lampa";
    private static String prodName2 = "Mysz komputerowa";
    private static String prodName3 = "Komputer";
    private static String prodName4 = "Głośniki";
    private static String prodName5 = "Klawiatura";

    private static BigDecimal prodPrice1 = BigDecimal.valueOf(50.5);
    private static BigDecimal prodPrice2 = BigDecimal.valueOf(30);
    private static BigDecimal prodPrice3 = BigDecimal.valueOf(2596.99);
    private static BigDecimal prodPrice4 = BigDecimal.valueOf(60.99);
    private static BigDecimal prodPrice5 = BigDecimal.valueOf(200);

    private static String userSurname1 = "Janosz";
    private static String userSurname2 = "Kowalski";
    private static String userSurname3 = "Kubeczko";

    private static Order order1;
    private static Order order2;
    private static Order order3;
    private static Order order4;

    private void addSomeOrders() {
        // products
        Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);
        Product product3 = mock(Product.class);
        Product product4 = mock(Product.class);
        Product product5 = mock(Product.class);
        given(product1.getName()).willReturn(prodName1);
        given(product2.getName()).willReturn(prodName2);
        given(product3.getName()).willReturn(prodName3);
        given(product4.getName()).willReturn(prodName4);
        given(product5.getName()).willReturn(prodName5);
        given(product1.getDiscountPrice()).willReturn(prodPrice1);
        given(product2.getDiscountPrice()).willReturn(prodPrice2);
        given(product3.getDiscountPrice()).willReturn(prodPrice3);
        given(product4.getDiscountPrice()).willReturn(prodPrice4);
        given(product5.getDiscountPrice()).willReturn(prodPrice5);

        // users
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        User user3 = mock(User.class);
        given(user1.getSurname()).willReturn(userSurname1);
        given(user2.getSurname()).willReturn(userSurname2);
        given(user3.getSurname()).willReturn(userSurname3);
        order1 = new Order(Arrays.asList(product1, product5), user1);
        order2 = new Order(Arrays.asList(product1, product2, product3, product4, product5), user2);
        order3 = new Order(Collections.singletonList(product2), user3);
        order4 = new Order(Collections.singletonList(product3), user3);
    }

    @Test
    public void testFindingOrdersWithGivenSurname() {
        // given
        addSomeOrders();
        SearchStrategy searchStrategy = new PurchaserSurnameSearchStrategy(userSurname3);
        List<Order> expectedOrders = Arrays.asList(order3, order4);

        // when
        List<Order> foundOrders = OrdersDatabase.find(searchStrategy);

        // then
        assertEquals(expectedOrders, foundOrders);
    }

    @Test
    public void testFindingOrdersWithGivenProductName() {
        // given
        addSomeOrders();
        SearchStrategy searchStrategy = new ProductNameSearchStrategy(prodName4);
        List<Order> expectedOrders = Collections.singletonList(order2);

        // when
        List<Order> foundOrders = OrdersDatabase.find(searchStrategy);

        // then
        assertEquals(expectedOrders, foundOrders);
    }

    @Test
    public void testFindingOrdersWithGivenPrice() {
        // given
        addSomeOrders();
        BigDecimal price = prodPrice1.add(prodPrice5);
        SearchStrategy searchStrategy = new PriceSearchStrategy(price);
        List<Order> expectedOrders = Collections.singletonList(order1);

        // when
        List<Order> foundOrders = OrdersDatabase.find(searchStrategy);

        // then
        assertEquals(expectedOrders, foundOrders);
    }

    @Test
    public void testFindingOrdersWithMoreStrategies() {
        // given
        addSomeOrders();
        BigDecimal price = prodPrice1.add(prodPrice5);
        SearchStrategy searchStrategy1 = new ProductNameSearchStrategy(prodName1); // 2 such orders: 1 and 2
        SearchStrategy searchStrategy2 = new PurchaserSurnameSearchStrategy(userSurname2); // 1 such order: 2
        SearchStrategy searchStrategy = new CompositeSearchStrategy(searchStrategy1, searchStrategy2);
        List<Order> expectedOrders = Collections.singletonList(order2);

        // when
        List<Order> foundOrders = OrdersDatabase.find(searchStrategy);

        // then
        assertEquals(expectedOrders, foundOrders);
    }

    @AfterEach
    public void afterEach() {
        OrdersDatabase.clearDatabase();
    }
}