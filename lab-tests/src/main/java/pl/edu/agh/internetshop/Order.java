package pl.edu.agh.internetshop;

import pl.edu.agh.database.OrdersDatabase;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


public class Order {
    private static final BigDecimal TAX_VALUE = BigDecimal.valueOf(1.23);
	private final UUID id;
    private final List<Product> products;
    private boolean paid;
    private Shipment shipment;
    private ShipmentMethod shipmentMethod;
    private PaymentMethod paymentMethod;
    private Discount discount;
    private User purchaser;

    public Order(List<Product> products, User purchaser) {
        this.products = Objects.requireNonNull(products);
        id = UUID.randomUUID();
        paid = false;
        this.purchaser = purchaser;
        OrdersDatabase.addOrder(this);
        this.discount = new Discount(0);
    }

    public Order(List<Product> products, User purchaser, double discountValue) {
        this(products, purchaser);
        this.discount = new Discount(discountValue);
    }

    public UUID getId() {
        return id;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }

    public boolean isPaid() { return paid; }

    public Shipment getShipment() {
        return shipment;
    }

    public BigDecimal getPrice() {
        BigDecimal result = BigDecimal.valueOf(0);
        for(Product p : products) {
            result = result.add(p.getPrice());
        }
        return result;
    }

    public BigDecimal getDiscountPrice() {
        BigDecimal result = BigDecimal.valueOf(0);
        for(Product p : products) {
            result = result.add(p.getDiscountPrice());
        }
        return result.multiply(discount.getDiscountMultiplier());
    }

    public BigDecimal getPriceWithTaxes() {
        return getPrice().multiply(TAX_VALUE).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }

    public BigDecimal getDiscountPriceWithTaxes() {
        return getDiscountPrice().multiply(TAX_VALUE).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }

    public List<Product> getProducts() {
        return products;
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccesful = getShipmentMethod().send(shipment, shipment.getSenderAddress(), shipment.getRecipientAddress());
        shipment.setShipped(sentSuccesful);
    }

    public void pay(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommitted(getPaymentMethod().commit(moneyTransfer));
        paid = moneyTransfer.isCommitted();
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = new Discount(discount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return paid == order.paid &&
                id.equals(order.id) &&
                products.equals(order.products) &&
                Objects.equals(shipment, order.shipment) &&
                Objects.equals(shipmentMethod, order.shipmentMethod) &&
                Objects.equals(paymentMethod, order.paymentMethod) &&
                discount.equals(order.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, paid, shipment, shipmentMethod, paymentMethod, discount);
    }
}
