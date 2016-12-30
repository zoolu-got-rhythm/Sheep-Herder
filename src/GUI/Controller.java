package GUI;
import java.awt.*;
import java.awt.event.*;

public class Controller {

    private Frame mainFrame;
    // private GraphicsConfiguration g;


    public Controller(){
        prepareGUI();
    }

    public static void main(String[] args){
        Controller  awtControlDemo = new Controller();
        awtControlDemo.showCanvasDemo();
        (new Thread(new Controller().new MyCanvas())).start();
    }

    private void prepareGUI(){
        mainFrame = new Frame("Java AWT Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);
    }

    private void showCanvasDemo(){
        mainFrame.add(new MyCanvas());
        mainFrame.setVisible(true);
    }



    private class MyCanvas extends Canvas implements Runnable {
        private int x = 0;
        private int y = 0;

        public MyCanvas () {
            setBackground (Color.GRAY);
            setSize(300, 300);
        }

        public void paint (Graphics g) {

            Graphics2D g2;
            g2 = (Graphics2D) g;
            g2.clearRect(0, 0, 300, 300);
            g2.drawRect(x, y, 10, 10);
            // g2.drawString ("It is a custom canvas area", 70, 70);
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
    }
}
