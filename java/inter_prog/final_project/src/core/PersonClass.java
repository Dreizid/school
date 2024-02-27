package core;
public class PersonClass {
    private String username;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String profilePicturePath;
    private Wallet wallet = new Wallet();
    boolean remembered = false;
    private Coupons availableCoupons = new Coupons();
    public Cart cart = new Cart();
    public Orders order = new Orders();

    public PersonClass(String username, String name, String email, String password, String phoneNumber) {
        this.username = username;
        this.fullName = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public void setProfile(String imagePath) {
        this.profilePicturePath = imagePath;
    }

    public String getUsername() {
        return this.username;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNumber() {
        return this.phoneNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public Wallet getWallet() {
        return this.wallet;
    }

    public String getPicture() {
        if (this.profilePicturePath != null) {
            return this.profilePicturePath;
        }
        return "src\\gui\\static\\images\\defaultprofile.png";
    }

    public void isRemembered () {
        this.remembered = true;
    }

    public void createNewCart() {
        cart = new Cart();
    }

    public Coupons getAvailabeCoupons() {
        return this.availableCoupons;
    }
}
