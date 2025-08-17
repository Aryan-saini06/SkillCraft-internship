// File: Task4.java
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Task4 extends JFrame implements KeyListener {
    private FileWriter writer;

    public Task4() {
        try {
            writer = new FileWriter("key_log.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Keylogger Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setVisible(true);

        System.out.println("🟡 Keylogger started. Type something... (Close window to stop)");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            writer.write(e.getKeyChar());
            writer.flush();
            System.out.println("Key pressed: " + e.getKeyChar());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new Task4();
    }
}
