package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
	
	public static final int PRICE_PRECISION = 2;
	public static final RoundingMode ROUND_STRATEGY = RoundingMode.HALF_UP;
	
    private final String name;
    private final BigDecimal price;
    private Discount discount;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
        this.discount = new Discount(0);
    }

    public Product(String name, BigDecimal price, double discount) {
        this.name = name;
        this.price = price;
        this.price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
        this.discount = new Discount(discount);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscountPrice() {
        return price.multiply(discount.getDiscount());
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = new Discount(discount);
    }
}
