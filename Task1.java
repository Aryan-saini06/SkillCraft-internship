import java.util.Scanner;

public class Task1 {
    public static String caesarCipher(String text, int shift, String mode) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                if (mode.equals("encrypt"))
                    result.append((char) ((c - base + shift) % 26 + base));
                else if (mode.equals("decrypt"))
                    result.append((char) ((c - base - shift + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message: ");
        String message = sc.nextLine();

        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Encrypt or Decrypt? ");
        String mode = sc.nextLine().toLowerCase();

        System.out.println("Result: " + caesarCipher(message, shift, mode));

        sc.close();
    }
}

