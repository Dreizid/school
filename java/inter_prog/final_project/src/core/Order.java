package core;

public class Order {
    protected int orderNumber;
    protected String couponName;
    protected double discount;
    protected double finalPrice;
    protected double serviceFee;
    protected Cart order;

    public Order(int orderNumber, String coupon, double discount, double price, double serviceFee, Cart order) {
        System.out.println(coupon);
        this.orderNumber = orderNumber;
        this.couponName = coupon;
        this.discount = discount;
        this.finalPrice = price;
        this.serviceFee = serviceFee;
        this.order = order;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public String getUsedCoupon() {
        return this.couponName;
    }

    public double getDiscount() {
        return this.discount;
    }

    public double getTotal() {
        return this.finalPrice;
    }

    public double getServiceFee() {
        return this.serviceFee;
    }

    public Cart getCart() {
        return this.order;
    }

    public boolean usedCoupon() {
        System.out.println(couponName);
        if (couponName.isEmpty()) {
            return false;
        }
        return true;
    }

}
