import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import javax.swing.Timer;

/**
 * Created by Slime on 23/12/2016.
 */
public class Map extends JPanel implements ActionListener, KeyListener {
    // compose all the objects
    List<Monkey> monkeys = new ArrayList<>();

    int height;
    int width;
    Boolean isPlayerDir = false;
    String playerDirection = "";

    private Timer tm = new Timer(150, this);

    public Map(int height, int width){
        this.height = height;
        this.width = width;


        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        monkeys.add(new Player(new Vector(5, 5)));
        // spawn monkeys
        for (int i = 0; i < 3; i++){
            monkeys.add(new Monkey(new Vector(i,i)));
        }
    }

    private Boolean isInside(Monkey actor) {
        return actor.getPos().getX() < this.width && actor.getPos().getX() >= 0 &&
                actor.getPos().getY() < this.height && actor.getPos().getY() >= 0;
    }

    private Boolean detection(Monkey monkey) {
        Monkey currentActor = monkey;
        for (int j = 0; j < this.monkeys.size(); j++) {
            if (this.monkeys.indexOf(currentActor) != j) { // stops the current actor from checking against itself
                if (currentActor.getPos().getX() == this.monkeys.get(j).getPos().getX() &&
                        currentActor.getPos().getY() == this.monkeys.get(j).getPos().getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    // toString
    @Override
    public String toString(){
        String output = "";
        for(int j = 0; j < 20; j++)
            output += "\n";

        // var row = new Array(this.width);
        // var colum = new Array(this.height);

        for (int x = 0; x < this.height; x++) {
            for (int y = 0; y < this.width; y++) {
                Vector place = new Vector(x, y);
                //console.log(place);
                String tile = "-";
                for (int i = 0; i < this.monkeys.size(); i++) {
                    Monkey actor = this.monkeys.get(i);
                    if (actor.getPos().getX() == place.getX() &&
                            actor.getPos().getY() == place.getY()) {
                        tile = "0";
                    }
                }
                output += tile;
            }
            output += "\n";
        }
        output += "monkeys: " + this.monkeys.size();
        return output;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int xBlockSize = 0;
        int yBlockSize = 0;

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1000, 1000);

        for (int x = 0; x < this.width; x++) {
            xBlockSize += 10;
            for (int y = 0; y < this.height; y++) {
                yBlockSize += 10;

                Vector place = new Vector(x, y);
                //console.log(place);

                g.setColor(Color.GREEN);
                g.fillRect(xBlockSize, yBlockSize, 9, 9);

                // loop through monkeys & override orange with green if a monkey is found
                for(int i = 0; i < this.monkeys.size(); i++){
                    Monkey actor = this.monkeys.get(i);
                    if (actor.getPos().getX() == place.getX() &&
                            actor.getPos().getY() == place.getY()) {
                        if(actor.getClass().getName() == "Monkey"){
                            g.setColor(Color.WHITE);
                        }else{
                            g.setColor(Color.BLUE);
                        }

                        g.fillRect(xBlockSize, yBlockSize, 9, 9);
                    }
                }


                if(yBlockSize == 10 * 10)
                    yBlockSize = 0;
            }
        }
        g.drawString("wrestlers: " + this.monkeys.size(), 200, 200);

        tm.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        for(Monkey monkey : monkeys){

            if(monkey.getClass().getName().equals("Player")){
                if(isPlayerDir == true) {
                    System.out.println(monkey.getClass().getName());
                    monkey.move(playerDirection);
                    isPlayerDir = false;
                }
            }else{
                monkey.move();
            }

            if(!(this.isInside(monkey))) {
                //System.out.println("out of bounds");
                monkey.undoMove();
            }

            if(this.detection(monkey)){
                //System.out.println("collision");
                monkey.undoMove();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        int key = e.getKeyCode();

        isPlayerDir = true;
        switch (key) {
            case 37:
                playerDirection = "w";
                break;
            case 38:
                playerDirection = "n";
                break;
            case 39:
                playerDirection = "e";
                break;
            case 40:
                playerDirection = "s";
                break;
            default:
                isPlayerDir = false;
                break;
        }

        System.out.println(playerDirection);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
