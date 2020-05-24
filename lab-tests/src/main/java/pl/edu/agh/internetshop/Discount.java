package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {
    private BigDecimal discount;

    public Discount(double discount) {
        if(discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Discount is percent value so should be between 0 and 100 (included)");
        }
        this.discount = BigDecimal.valueOf((100 - discount)/100.0);
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void changeDiscount(double newDiscount) {
        discount = new Discount(newDiscount).getDiscount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return discount.equals(discount1.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discount);
    }
}
