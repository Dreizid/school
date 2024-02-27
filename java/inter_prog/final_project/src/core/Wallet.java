package core;

public class Wallet {
    private double balance;

    public Wallet() {
        balance = 3000;
    }

    public void addBalance(double addedBalance) {
        this.balance += addedBalance;
    }

    public void subtractBalance(double subtractedBalance) {
        this.balance -= subtractedBalance;
    }

    public double getBalance() {
        return this.balance;
    }
}
