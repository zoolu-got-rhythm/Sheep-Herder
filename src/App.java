import javax.swing.*;

/**
 * Created by Slime on 26/12/2016.
 */

// change to game class
public class App {
    private static JFrame jf;

    public static void main(String[] args) {
        jf = new JFrame();
        Map level1 = new Map(10,10);


        // jframe api: set-up canvas
        jf.setTitle("canvas experiment");
        jf.setSize(1000, 1000);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(level1);
    }
}
