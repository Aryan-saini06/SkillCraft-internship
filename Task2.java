import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Task2 {
    // image encryption/decryption
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter image path: ");
        String path = sc.nextLine();

        System.out.print("Encrypt or Decrypt? ");
        String choice = sc.nextLine().toLowerCase();

        System.out.print("Enter numeric key: ");
        int key = sc.nextInt();

        BufferedImage img = ImageIO.read(new File(path));
        int w = img.getWidth(), h = img.getHeight();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int p = img.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                if (choice.equals("encrypt")) {
                    r = (r + key) % 256;
                    g = (g + key) % 256;
                    b = (b + key) % 256;
                } else {
                    r = (r - key + 256) % 256;
                    g = (g - key + 256) % 256;
                    b = (b - key + 256) % 256;
                }

                p = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(x, y, p);
            }
        }

        String out = choice.equals("encrypt") ? "encrypted.png" : "decrypted.png";
        ImageIO.write(img, "png", new File(out));
        System.out.println("✅ Saved as " + out);

        sc.close();
    }
}
