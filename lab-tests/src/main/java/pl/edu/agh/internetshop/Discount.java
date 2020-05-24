package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {
    private BigDecimal discountMultiplier;

    public Discount(double discount) {
        if(discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Discount is percent value so should be between 0 and 100 (included)");
        }
        this.discountMultiplier = BigDecimal.valueOf((100 - discount)/100.0);
    }

    public BigDecimal getDiscountMultiplier() {
        return discountMultiplier;
    }

    public void changeDiscount(double newDiscount) {
        discountMultiplier = new Discount(newDiscount).getDiscountMultiplier();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return discountMultiplier.equals(discount1.discountMultiplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountMultiplier);
    }
}
