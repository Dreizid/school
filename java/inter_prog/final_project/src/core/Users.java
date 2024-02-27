package core;

import java.util.ArrayList;
import java.util.Arrays;

public class Users {
    public static ArrayList<PersonClass> users = new ArrayList<>(Arrays.asList(
        new PersonClass("Rei", "Rei A. Example", "Example@email.com", "123", "+63 012-345-6789"),
        new PersonClass("Ced", "Ced R. Ick", "Ick@gmail.com", "345", "+63 987-654-3210")));
    public Users() {

    }
}
