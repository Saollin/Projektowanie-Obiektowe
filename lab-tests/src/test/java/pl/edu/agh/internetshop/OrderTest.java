package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

public class OrderTest {

	private Order getOrderWithMockedProduct() {
		Product product = mock(Product.class);
		return new Order(Collections.singletonList(product));
	}

	@Test
	public void testGetProductThroughOrder() {
		// given
		Product expectedProduct = mock(Product.class);
		Order order = new Order(Collections.singletonList(expectedProduct));

		// when
		List<Product> actualProducts = order.getProducts();

		// then
		assertSame(expectedProduct, actualProducts.get(0));
	}

	@Test
	public void testProductListInNull() {
		// when then
		assertThrows(NullPointerException.class, () -> new Order(null));
	}

	@Test
	public void testGetMultipleProductsFromOrder() {
		//given
		Product expectedProduct1 = mock(Product.class);
		Product expectedProduct2 = mock(Product.class);
		Product expectedProduct3 = mock(Product.class);
		Order order = new Order(Arrays.asList(expectedProduct1,expectedProduct2, expectedProduct3));

		//when
		List<Product> actualProducts = order.getProducts();

		//then
		assertSame(expectedProduct1, actualProducts.get(0));
		assertSame(expectedProduct2, actualProducts.get(1));
		assertSame(expectedProduct3, actualProducts.get(2));
	}

	@Test
	public void testSetShipment() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();
		Shipment expectedShipment = mock(Shipment.class);

		// when
		order.setShipment(expectedShipment);

		// then
		assertSame(expectedShipment, order.getShipment());
	}

	@Test
	public void testShipmentWithoutSetting() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();

		// when

		// then
		assertNull(order.getShipment());
	}

	@Test
	public void testGetPrice() throws Exception {
		// given
		BigDecimal expectedProductPrice = BigDecimal.valueOf(1000);
		Product product = mock(Product.class);
		given(product.getPrice()).willReturn(expectedProductPrice);
		Order order = new Order(Collections.singletonList(product));

		// when
		BigDecimal actualProductPrice = order.getPrice();

		// then
		assertBigDecimalCompareValue(expectedProductPrice, actualProductPrice);
	}

	@Test
	public void testGetPriceForMultiple() throws Exception {
		// given
		BigDecimal productPrice1 = BigDecimal.valueOf(1000);
		BigDecimal productPrice2 = BigDecimal.valueOf(50.99);
		BigDecimal productPrice3 = BigDecimal.valueOf(2000.99);
		BigDecimal expectedPrice = productPrice1.add(productPrice2).add(productPrice3);
		Product product1 = mock(Product.class);
		Product product2 = mock(Product.class);
		Product product3 = mock(Product.class);
		given(product1.getPrice()).willReturn(productPrice1);
		given(product2.getPrice()).willReturn(productPrice2);
		given(product3.getPrice()).willReturn(productPrice3);
		Order order = new Order(Arrays.asList(product1, product2, product3));

		// when
		BigDecimal actualProductPrice = order.getPrice();

		// then
		assertBigDecimalCompareValue(expectedPrice, actualProductPrice);
	}

	private Order getOrderWithCertainProductPrice(double productPriceValue) {
		BigDecimal productPrice = BigDecimal.valueOf(productPriceValue);
		Product product = mock(Product.class);
		given(product.getPrice()).willReturn(productPrice);
		return new Order(Collections.singletonList(product));
	}

	@Test
	public void testPriceWithTaxesWithoutRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(2); // 2 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(2.46)); // 2.46 PLN
	}

	@Test
	public void testPriceWithTaxesWithRoundDown() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(0.01); // 0.01 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.01)); // 0.01 PLN
																							
	}

	@Test
	public void testPriceWithTaxesWithRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(0.03); // 0.03 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.04)); // 0.04 PLN
																							
	}

	@Test
	public void testSetShipmentMethod() {
		// given
		Order order = getOrderWithMockedProduct();
		ShipmentMethod surface = mock(SurfaceMailBus.class);

		// when
		order.setShipmentMethod(surface);

		// then
		assertSame(surface, order.getShipmentMethod());
	}

	@Test
	public void testSending() {
		// given
		Order order = getOrderWithMockedProduct();
		SurfaceMailBus surface = mock(SurfaceMailBus.class);
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);

		// when
		order.setShipmentMethod(surface);
		order.setShipment(shipment);
		order.send();

		// then
		assertTrue(order.isSent());
	}

	@Test
	public void testIsSentWithoutSending() {
		// given
		Order order = getOrderWithMockedProduct();
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);

		// when

		// then
		assertFalse(order.isSent());
	}

	@Test
	public void testWhetherIdExists() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();

		// when

		// then
		assertNotNull(order.getId());
	}

	@Test
	public void testSetPaymentMethod() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);

		// when
		order.setPaymentMethod(paymentMethod);

		// then
		assertSame(paymentMethod, order.getPaymentMethod());
	}

	@Test
	public void testPaying() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);
		given(paymentMethod.commit(any(MoneyTransfer.class))).willReturn(true);
		MoneyTransfer moneyTransfer = mock(MoneyTransfer.class);
		given(moneyTransfer.isCommitted()).willReturn(true);

		// when
		order.setPaymentMethod(paymentMethod);
		order.pay(moneyTransfer);

		// then
		assertTrue(order.isPaid());
	}

	@Test
	public void testIsPaidWithoutPaying() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();

		// when

		// then
		assertFalse(order.isPaid());
	}

	@Test
	public void testOrderDiscount() throws Exception{
		//given
		Product product = mock(Product.class);
		double discountValue = 25.5;
		Discount expectedDiscount = new Discount(discountValue);

		// when
		Order order = new Order(Collections.singletonList(product), discountValue);

		// thenf
		assertEquals(order.getDiscount(), expectedDiscount);
	}

	@Test
	public void testSetDiscount() {
		//given
		Product product = mock(Product.class);
		double discountValue = 25.5;
		Order order = new Order(Collections.singletonList(product));
		Discount expectedDiscount = new Discount(discountValue);

		// when
		order.setDiscount(discountValue);

		// thenf
		assertEquals(order.getDiscount(), expectedDiscount);
	}

	@Test
	public void testGetDiscountOnlyOrder() {
		// given
		BigDecimal productPrice1 = BigDecimal.valueOf(1000);
		BigDecimal productPrice2 = BigDecimal.valueOf(50.99);
		BigDecimal productPrice3 = BigDecimal.valueOf(2000.99);
		BigDecimal sumPrice = productPrice1.add(productPrice2).add(productPrice3);
		Product product1 = mock(Product.class);
		Product product2 = mock(Product.class);
		Product product3 = mock(Product.class);
		given(product1.getDiscountPrice()).willReturn(productPrice1);
		given(product2.getDiscountPrice()).willReturn(productPrice2);
		given(product3.getDiscountPrice()).willReturn(productPrice3);
		Order order = new Order(Arrays.asList(product1, product2, product3));
		double discountValue = 20.5;
		Discount discount = new Discount(discountValue);
		order.setDiscount(discountValue);
		BigDecimal expectedPrice = sumPrice.multiply(discount.getDiscountMultiplier());

		// when
		BigDecimal actualProductPrice = order.getDiscountPrice();

		// then
		assertBigDecimalCompareValue(expectedPrice, actualProductPrice);
	}

	@Test
	public void testOrderWithoutDiscountReturnTheSameDiscountPriceAsNormal() {
		// given
		BigDecimal productPrice1 = BigDecimal.valueOf(1000);
		BigDecimal productPrice2 = BigDecimal.valueOf(50.99);
		BigDecimal productPrice3 = BigDecimal.valueOf(2000.99);
		Product product1 = mock(Product.class);
		Product product2 = mock(Product.class);
		Product product3 = mock(Product.class);
		given(product1.getDiscountPrice()).willReturn(productPrice1);
		given(product2.getDiscountPrice()).willReturn(productPrice2);
		given(product3.getDiscountPrice()).willReturn(productPrice3);
		given(product1.getPrice()).willReturn(productPrice1);
		given(product2.getPrice()).willReturn(productPrice2);
		given(product3.getPrice()).willReturn(productPrice3);
		Order order = new Order(Arrays.asList(product1, product2, product3));

		// when
		BigDecimal actualPrice = order.getDiscountPrice();
		BigDecimal expectedPrice = order.getPrice();

		// then
		assertBigDecimalCompareValue(expectedPrice, actualPrice);
	}

	@Test
	public void testDiscountPriceWithDiscountedProducts() {
		// given
		Discount discount1 = new Discount(20);
		Discount discount2 = new Discount(40);
		BigDecimal productPrice1 = BigDecimal.valueOf(1000).multiply(discount1.getDiscountMultiplier());
		BigDecimal productPrice2 = BigDecimal.valueOf(50.99).multiply(discount2.getDiscountMultiplier());
		BigDecimal productPrice3 = BigDecimal.valueOf(2000.99);
		Product product1 = mock(Product.class);
		Product product2 = mock(Product.class);
		Product product3 = mock(Product.class);
		given(product1.getDiscountPrice()).willReturn(productPrice1);
		given(product2.getDiscountPrice()).willReturn(productPrice2);
		given(product3.getDiscountPrice()).willReturn(productPrice3);
		Order order = new Order(Arrays.asList(product1, product2, product3));

		// when
		BigDecimal actualPrice = order.getDiscountPrice();
		BigDecimal expectedPrice = productPrice1.add(productPrice2).add(productPrice3);

		// then
		assertBigDecimalCompareValue(expectedPrice, actualPrice);
	}

	@Test
	public void testDiscountPriceWithDiscountedProductsAndDiscountOrder() {
		// given
		Discount discount1 = new Discount(20);
		Discount discount2 = new Discount(40);
		BigDecimal productPrice1 = BigDecimal.valueOf(1000).multiply(discount1.getDiscountMultiplier());
		BigDecimal productPrice2 = BigDecimal.valueOf(50.99).multiply(discount2.getDiscountMultiplier());
		BigDecimal productPrice3 = BigDecimal.valueOf(2000.99);
		BigDecimal sumPrice = productPrice1.add(productPrice2).add(productPrice3);
		Product product1 = mock(Product.class);
		Product product2 = mock(Product.class);
		Product product3 = mock(Product.class);
		given(product1.getDiscountPrice()).willReturn(productPrice1);
		given(product2.getDiscountPrice()).willReturn(productPrice2);
		given(product3.getDiscountPrice()).willReturn(productPrice3);
		double discountValue = 5;
		Discount generalDiscount = new Discount(discountValue);
		Order order = new Order(Arrays.asList(product1, product2, product3), discountValue);

		// when
		BigDecimal actualPrice = order.getDiscountPrice();
		BigDecimal expectedPrice = sumPrice.multiply(generalDiscount.getDiscountMultiplier());

		// then
		assertBigDecimalCompareValue(expectedPrice, actualPrice);
	}
}
