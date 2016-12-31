package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controller {



    public static void main(String[] args){
        JFrame jf = new JFrame();
        MyCanvas c = new Controller().new MyCanvas();

        jf.setTitle("canvas experiment");
        jf.setSize(1000, 1000);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(new Controller().new MyCanvas());

        new Thread(c).start();
    }




    private class MyCanvas extends JPanel implements Runnable, ActionListener {
        private int x = 0;
        private int y = 0;

        // overriding?
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            g.setColor(Color.pink);
            g.fillRect(x, y, 20, 20);
        }

        @Override
        public void run() {

            try {
                while (true) {
                    x++;
                    y++;
                    repaint();
                    System.out.println(x);
                    Thread.sleep(100);
                }
            }catch (Exception e){
                e.getStackTrace();
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    // timer thread

    // user input (player) thread
}
