import java.util.Scanner;

public class Task3{
    //PasswordStrength
    public static String checkPasswordStrength(String password) {
        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*\\d.*")) score++;
        if (password.matches(".*[@$!%*?&].*")) score++;

        if (score == 5) {
            return "Strong";
        } else if (score >= 3) {
            return "Medium";
        } else {
            return "Weak";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.println("Password Strength: " + checkPasswordStrength(password));
    }
}

