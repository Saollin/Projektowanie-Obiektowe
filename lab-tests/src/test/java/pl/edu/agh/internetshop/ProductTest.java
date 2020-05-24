package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

import java.math.BigDecimal;


public class ProductTest {

    private static final String NAME = "Mr. Sparkle";
    private static final BigDecimal PRICE = BigDecimal.valueOf(1);
    private static final double DISCOUNT_VALUE = 20;
    private static final Discount DISCOUNT = new Discount(DISCOUNT_VALUE);

	@Test
    public void testProductName() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertEquals(NAME, product.getName());
    }
    
    @Test
    public void testProductPrice() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertBigDecimalCompareValue(product.getPrice(), PRICE);
    }

    @Test
    public void testProductDiscount() throws Exception{
        //given

        // when
        Product product = new Product(NAME, PRICE, DISCOUNT_VALUE);

        // then
        assertEquals(product.getDiscount(), DISCOUNT);
    }

    @Test
    public void testSetDiscount() {
        //given
        Product product = new Product(NAME, PRICE);

        // when
        product.setDiscount(DISCOUNT_VALUE);
        // then
        assertEquals(product.getDiscount(), DISCOUNT);
    }

    @Test
    public void testDiscountProductPrice() throws Exception{
        //given
        BigDecimal expectedPrice = PRICE.multiply(DISCOUNT.getDiscount());
        Product product = new Product(NAME, PRICE, DISCOUNT_VALUE);

        // when
        BigDecimal actualPrice = product.getDiscountPrice();

        // then
        assertBigDecimalCompareValue(expectedPrice, actualPrice);
    }

}