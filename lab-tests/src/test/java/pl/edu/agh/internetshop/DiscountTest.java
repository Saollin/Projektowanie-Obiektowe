package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

class DiscountTest {

    @Test
    public void testGetDiscountMultiplier() {
        // given
        double discountInPercent = 20.5;
        BigDecimal expectedDiscount = BigDecimal.valueOf((100 - discountInPercent)/100.0);
        Discount discount = new Discount(discountInPercent);

        // when
        BigDecimal actualDiscount = discount.getDiscountMultiplier();

        // then
        assertBigDecimalCompareValue(expectedDiscount, actualDiscount);
    }

    @Test
    public void testValueLessThan0() {
        // when then
        assertThrows(IllegalArgumentException.class, () -> new Discount(-5));
    }

    @Test
    public void testValueGreaterThan100() {
        // when then
        assertThrows(IllegalArgumentException.class, () -> new Discount(110.5));
    }

    @Test
    public void testValueEqual0() {
        // given
        BigDecimal expectedDiscount = BigDecimal.ONE;
        Discount discount = new Discount(0);

        // when
        BigDecimal actualDiscount = discount.getDiscountMultiplier();

        // then
        assertBigDecimalCompareValue(expectedDiscount, actualDiscount);
    }

    @Test
    public void testValueEqual100() {
        // given
        BigDecimal expectedDiscount = BigDecimal.ZERO;
        Discount discount = new Discount(100);

        // when
        BigDecimal actualDiscount = discount.getDiscountMultiplier();

        // then
        assertBigDecimalCompareValue(expectedDiscount, actualDiscount);
    }

    @Test
    public void testChangeValue() {
        // given
        Discount discount = new Discount(20);
        double newDiscountValue = 20.5;
        BigDecimal expectedDiscount = BigDecimal.valueOf((100 - newDiscountValue)/100.0);
        discount.changeDiscount(newDiscountValue);

        // when
        BigDecimal actualDiscount = discount.getDiscountMultiplier();

        // then
        assertBigDecimalCompareValue(expectedDiscount, actualDiscount);
    }
}