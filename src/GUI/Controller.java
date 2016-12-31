package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controller {
    private static JFrame jf;


    public static void main(String[] args){
        jf = new JFrame();
        MyCanvas c = new Controller().new MyCanvas();

        jf.setTitle("canvas experiment");
        jf.setSize(1000, 1000);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(new Controller().new MyCanvas());

        //new Thread(c).start();
    }




    private class MyCanvas extends JPanel implements ActionListener {
        private int x = 0;
        private int y = 0;
        private int velX = 5;
        private Boolean toggle = false;
        private Timer tm = new Timer(50, this);

        // overriding?
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            g.setColor(Color.pink);
            g.fillRect(x, y, 20, 20);
            tm.start();
        }


        @Override
        public void actionPerformed(ActionEvent e) {

            if(x > jf.getWidth() || x < 0)
                toggle = !toggle;

            if(!toggle){
                x = x + velX;
            }else {
                x = x - velX;
            }

            repaint();
        }
    }

    // timer thread

    // user input (player) thread
}
