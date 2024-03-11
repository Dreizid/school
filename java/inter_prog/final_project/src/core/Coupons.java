package core;

import java.util.ArrayList;
import java.util.Arrays;

public class Coupons extends ArrayList<String>{
    private int maxVouchers = 1;
    private int usedVouchers = 0;
    protected ArrayList<String> usedCoupons;

    public Coupons() {
        addAll(Arrays.asList("10%OFF", "25%OFF", "50%OFF", "75%OFF", "100%OFF", "FREESERVICE"));
        usedCoupons = new ArrayList<>();
    }
    public Coupons getCoupons() {
        return this;
    }

    public void removeVoucher(String couponName) {
        usedCoupons.add(couponName);
        usedVouchers++;
        remove(couponName);
    }
    public int getMaxVouchers() {
        return this.maxVouchers;
    }
    public int getUsedVouchers() {
        return this.usedVouchers;
    }
}
