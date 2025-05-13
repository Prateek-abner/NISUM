class User {
    private static User instance = null;
    public String name;

    private User() {
        name = "OnlyOneUser";
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        User u1 = User.getInstance();
        User u2 = User.getInstance();

        System.out.println(u1.name);
        System.out.println(u1 == u2); // true - same object
    }
}
