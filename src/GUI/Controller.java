package GUI;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Controller {
    private static JFrame jf;


    public static void main(String[] args){
        jf = new JFrame();
        MyCanvas c = new Controller().new MyCanvas();

        jf.setTitle("canvas experiment");
        jf.setSize(1000, 1000);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(c);
    }




    private class MyCanvas extends JPanel implements ActionListener, KeyListener{

        private int x = 0;
        private int y = 0;
        private int velX = 5;
        private int playerX = velX;
        private int playerY = velX;
        private Boolean toggle = false;
        private Timer tm = new Timer(50, this);
        private TestTimer stopWatch = new Controller().new TestTimer();

        public MyCanvas(){
            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            this.stopWatch.start(20);
        }

        // overriding?
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, 1000, 1000);

            g.setColor(Color.CYAN);
            g.drawString(Integer.toString(this.stopWatch.getX()), 70, 20);

            for(int i = 0; i <= 10; i ++){
                x+=5;
                for(int j = 0; j <= 10; j ++){
                    y+=5;
                    if(playerX == x && playerY == y) {
                        g.setColor(Color.ORANGE);
                        g.fillRect(x, y, 3, 3);
                    }else{
                        g.setColor(Color.GREEN);
                        g.fillRect(x, y, 3, 3);
                    }
                    //System.out.println(x);
                    if(y == 10 * 5)
                        y = 0;

                }
            }
            x = 0;

            tm.start();
        }


        @Override
        public void actionPerformed(ActionEvent e) {
//            if(x > jf.getWidth() || x < 0)
//                toggle = !toggle;
//
//            if(!toggle){
//                x = x + velX;
//            }else {
//                x = x - velX;
//            }
            repaint();
        }


        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyCode());
            System.out.println(playerX);
            int key = e.getKeyCode();
            switch (key) {
                case 37:
                    playerX -= 5;
                    break;
                case 38:
                    playerY -= 5;
                    break;
                case 39:
                    playerX += 5;
                    break;
                case 40:
                    playerY += 5;
                    break;
                    default:
                        break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }


    private class TestTimer extends JPanel implements ActionListener{
        public int x = 0;
        public java.util.Timer timer;

        public TestTimer(){
            this.timer = new java.util.Timer();
        }

        public void start(int secs){
            TestTimer self = this;
            this.timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(x);

                    x++;
                    if(self.x == secs) {
                        System.out.println("should stop");
                        stop();
                    }
                }
            }, 0, 1000);
        }

        private void stop(){
            this.timer.cancel();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }


        @Override
        public int getX() {
            return x;
        }
    }
}
