package core;
public class PersonClass {
    private String username;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    double balance = 0;
    boolean remembered = false;
    Cart cart = new Cart();
    // Create an instance of all items?

    public PersonClass(String username, String name, String email, String password, String phoneNumber) {
        this.username = username;
        this.fullName = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public void addBalance (int moneyAdded) {
        this.balance += moneyAdded;
    }

    public void subtractBalance (int moneySubtracted) {
        this.balance -= moneySubtracted;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void isRemembered () {
        this.remembered = true;
    }
}
