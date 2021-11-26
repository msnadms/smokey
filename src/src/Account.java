import java.io.Serializable;

public class Account implements Serializable {
    private final int id = hashCode();
    private String username;
    private String email;
    private String password;
    private Grade grade;

    private enum Grade {A, B, C, D, F, X, Z}

    public Account(String user, String email, String pass) {
        this.username = user;
        this.email = email;
        this.password = pass;
    }

    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void changeEmail(String newEmail) {
        this.email = newEmail;
    }

    public int getId() {
        return id;
    }
}
