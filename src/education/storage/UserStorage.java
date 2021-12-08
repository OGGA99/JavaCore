package education.storage;

import education.model.User;

public class UserStorage {

    private static User[] users = new User[15];
    private static int size;

    public static User getByemail(String email) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        return null;
    }


    public static void add(User user) {
        if (size == users.length) {
            extend();
        }
        users[size++] = user;
    }

    private static void extend() {
        User[] tmp = new User[users.length * 2];
        System.arraycopy(users, 0, tmp, 0, size);
        users = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
    }

    public static String emailPassword(String email, String password) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email) && users[i].getPassword().equals(password)) {
                return users[i].getType();
            }
        }
        return null;
    }
}