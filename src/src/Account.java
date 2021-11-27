import java.io.Serializable;
import java.util.ArrayList;

enum Grade {A, B, C, D, F, X, Z}

public class Account implements Serializable {
    private final int id = hashCode();
    private String username;
    private String email;
    private String password;
    private final ArrayList<Integer> scores;
    private Grade grade;

    public Account(String user, String email, String pass) {
        this.username = user;
        this.email = email;
        this.password = pass;
        scores = new ArrayList<Integer>();
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

    public void giveScore(int score) {
        scores.add(score);
    }

    public void assignGrade() {
        if (scores.size() == 0) {
            return;
        }
        double sum = 0;
        for (int i : scores) {
            sum += i;
        }
        double fScore = sum / scores.size();
        if (fScore >= 90) {
            grade = Grade.A;
        } else if (fScore >= 80) {
            grade = Grade.B;
        } else if (fScore >= 70) {
            grade = Grade.C;
        } else if (fScore >= 60) {
            grade = Grade.D;
        } else if (fScore >= 50) {
            grade = Grade.F;
        } else if (fScore > 0) {
            grade = Grade.Z;
        } else if (fScore == 0) {
            grade = Grade.X;
        }
    }

    public Grade getGrade() {
        return grade;
    }

    public int getId() {
        return id;
    }

}
