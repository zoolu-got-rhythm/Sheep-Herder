import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Slime on 01/01/2017.
 */
public class Player extends Monkey implements KeyListener{
    public Player(Vector v){
        super(v);
    }

    // add control event
//    @Override
//    public void move(int playerDir){
//        super.move(playerDir);
////        this.prevPos = this.pos;
////        this.pos = this.pos.plot(dir.get(this.direction[(int) Math.floor(Math.random() * direction.length)]));
//    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
